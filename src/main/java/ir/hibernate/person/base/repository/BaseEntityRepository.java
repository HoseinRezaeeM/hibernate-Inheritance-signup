package ir.hibernate.person.base.repository;
import ir.hibernate.person.base.domain.BaseEntity;


import java.io.Serializable;
import java.util.List;

public interface BaseEntityRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    void save(T entity);

    void update(T entity,ID id);

    void deleteById(ID id);

    List<T> findAll();

    boolean containsbyId(ID id);


}