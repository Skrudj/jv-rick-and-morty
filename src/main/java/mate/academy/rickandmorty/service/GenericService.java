package mate.academy.rickandmorty.service;

import java.util.List;

public interface GenericService<T> {
    T save(T entity);

    List<T> getAll();

    T getById(Long id);

    void update(T entity);

    void deleteById(Long id);
}
