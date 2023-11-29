package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class AccountRepository implements IRepositories<Account, Long> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public AccountRepository() {
        entityManager = Persistence.createEntityManagerFactory("week01").createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public boolean insert(Account account) {
        try {
            transaction.begin();
            entityManager.persist(account);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Account account) {
        try {
            transaction.begin();
            entityManager.merge(account);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Account account) {
        try {
            transaction.begin();
            entityManager.remove(account);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.of((Account) entityManager.createNamedQuery("Account.findById").setParameter("id", id).getSingleResult());
    }

    @Override
    public List<Account> findAll() {
        return entityManager.createNamedQuery("Account.findAll").getResultList();
    }

    public Optional<Account> findAccountByEmailAndPassword(String email, String password) {
        try {
            TypedQuery<Account> query = entityManager.createNamedQuery("Account.findAccountByEmailAndPassword", Account.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return Optional.of(query.getSingleResult());
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
