package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.repositories;

import java.util.List;
import java.util.Optional;

public interface IRepositories<T, ID>{
    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
    Optional<T> findById(ID id);
    List<T> findAll();
}
