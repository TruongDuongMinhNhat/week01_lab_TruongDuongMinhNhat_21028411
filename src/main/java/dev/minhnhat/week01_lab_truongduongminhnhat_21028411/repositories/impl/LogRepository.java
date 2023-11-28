package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.impl;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Log;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class LogRepository implements IRepositories<Log, Long> {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public LogRepository() {
        entityManager = Persistence.createEntityManagerFactory("week01").createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public boolean insert(Log log) {
        try {
            transaction.begin();
            entityManager.persist(log);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Log log) {
        try {
            transaction.begin();
            entityManager.merge(log);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Log log) {
        try {
            transaction.begin();
            entityManager.remove(log);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Log> findById(Long id) {
        return Optional.of(entityManager.createNamedQuery("Log.findById", Log.class).setParameter("id", id).getSingleResult());
    }

    @Override
    public List<Log> findAll() {
        return entityManager.createNamedQuery("Log.findAll", Log.class).getResultList();
    }
}
