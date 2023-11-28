package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services;

import java.util.List;
import java.util.Optional;

public interface IServices<T, ID>{
    boolean insert(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(T t) throws Exception;
    Optional<T> findById(ID id) throws Exception;
    List<T> findAll() throws Exception;
}
