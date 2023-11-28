package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class RoleRepository implements IRepositories<Role, Long> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public RoleRepository() {
        entityManager = Persistence.createEntityManagerFactory("week01").createEntityManager();
        transaction = entityManager.getTransaction();
    }
    @Override
    public boolean insert(Role role) {
        try {
            transaction.begin();
            entityManager.persist(role);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Role role) {
        try {
            transaction.begin();
            entityManager.merge(role);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Role role) {
        try {
            transaction.begin();
            entityManager.remove(role);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.of(entityManager.createNamedQuery("Role.findById", Role.class).setParameter("id", id).getSingleResult());
    }

    @Override
    public List<Role> findAll() {
        return entityManager.createNamedQuery("Role.findAll", Role.class).getResultList();
    }
}
