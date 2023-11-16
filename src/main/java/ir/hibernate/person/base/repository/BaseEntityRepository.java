package ir.hibernate.person.base.repository;
import ir.hibernate.person.base.domain.BaseEntity;


import java.io.Serializable;
import java.util.List;
//Hosen Rezaei
public interface BaseEntityRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    void save(T entity);

    void update(String firstname,String lastname,ID id);

    void deleteById(ID id);

    List<T> findAll();

    boolean containsbyId(ID id);

    T findById(ID id);

}
