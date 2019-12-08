package io.kielbi.sda.sda.jpa_17.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

//@NoRepositoryBean
public interface CustomCrudRepository<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T create(T obj);

    T update(T obj);

    void deleteById(ID id);

    void delete(T obj);



}
