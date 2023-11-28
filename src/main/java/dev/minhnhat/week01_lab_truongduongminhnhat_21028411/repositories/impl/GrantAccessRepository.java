package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccess;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccessID;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class GrantAccessRepository implements IRepositories<GrantAccess, GrantAccessID> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public GrantAccessRepository() {
        entityManager = Persistence.createEntityManagerFactory("week01").createEntityManager();
        transaction = entityManager.getTransaction();
    }
    @Override
    public boolean insert(GrantAccess grantAccess) {
        try {
            transaction.begin();
            entityManager.persist(grantAccess);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(GrantAccess grantAccess) {
        try {
            transaction.begin();
            entityManager.merge(grantAccess);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(GrantAccess grantAccess) {
        try {
            transaction.begin();
            entityManager.remove(grantAccess);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<GrantAccess> findById(GrantAccessID grantAccessID) {
//        return Optional.of(entityManager.createNamedQuery("GrantAccess.findById", GrantAccess.class)
//                .setParameter("account", grantAccessID.getAccount())
//                .setParameter("role", grantAccessID.getRole()).getSingleResult());
        return null;
    }

    public Optional<GrantAccess> findById(Account account, Role role) {
        try {
            TypedQuery<GrantAccess> query = entityManager.createNamedQuery("GrantAccess.findById", GrantAccess.class);
            query.setParameter("account", account);
            query.setParameter("role", role);
            GrantAccess grantAccess = query.getSingleResult();
            return Optional.of(grantAccess);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GrantAccess> findAll() {
        return entityManager.createNamedQuery("GrantAccess.findAll", GrantAccess.class).getResultList();
    }

}
