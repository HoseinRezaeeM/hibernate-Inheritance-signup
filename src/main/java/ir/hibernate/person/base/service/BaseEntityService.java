package ir.hibernate.person.base.service;

import ir.hibernate.person.base.domain.BaseEntity;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface BaseEntityService<T extends BaseEntity<ID>, ID extends Serializable> {

    void save(T entity) throws IOException, SAXException;

    void update(String firstname, String lastname, ID id);

    void deleteById(ID id);

    List<T> findAll();

    boolean contains(ID id);

    T findById(ID id);

}
