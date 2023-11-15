package ir.hibernate.person.base.service.impl;


import ir.hibernate.person.base.domain.BaseEntity;
import ir.hibernate.person.base.repository.BaseEntityRepository;
import ir.hibernate.person.base.service.BaseEntityService;




import javax.xml.transform.Source;
import javax.xml.validation.Validator;

import java.io.Serializable;
import java.util.List;


public class BaseEntityServiceImpl<T extends BaseEntity<ID>, ID extends Serializable, R extends BaseEntityRepository<T, ID>>
        implements BaseEntityService<T, ID> {

    protected final R baseRepository;



    public BaseEntityServiceImpl(R baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public void save(T entity) {
            baseRepository.save(entity);
    }

    @Override
    public void update(String firstname, String lastname, ID id) {
        baseRepository.update(firstname, lastname, id);
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public boolean contains(ID id) {
        return baseRepository.containsbyId(id);
    }

    @Override
    public T findById(ID id) {
        return baseRepository.findById(id);
    }
}
