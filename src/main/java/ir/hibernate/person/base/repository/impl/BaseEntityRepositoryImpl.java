package ir.hibernate.person.base.repository.impl;

import ir.hibernate.person.base.domain.BaseEntity;
import ir.hibernate.person.base.repository.BaseEntityRepository;
import ir.hibernate.person.domain.Person;
import ir.hibernate.person.domain.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class BaseEntityRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements BaseEntityRepository<T, ID> {
    private final Session session;

    public BaseEntityRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(T entity) {
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(T entity, ID id) {
        String hql = "UPDATE %s SET first_name=:first_name Where id=:id";
        Person person =new Person();

        try {
            session.beginTransaction();
            Query query = session.createQuery(String.format(hql,getEntityTableName()));
            query.setParameter("first_name",person.getFirstname());
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();

        }
    }

    @Override
    public void deleteById(ID id) {
        String hql = "DELETE FROM %s Where id=:id";
        try {
            session.beginTransaction();
            final Query query = session.createQuery(String.format(hql, getEntityTableName()));
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public List<T> findAll() {
        String hql = "FROM %s";
        Query query = session.createQuery(String.format(hql, getEntityTableName()));
        List list = query.list();
        return list;
    }


    @Override
    public boolean containsbyId(ID id) {
        String hql = "SELECT COUNT(*) FROM %s WHERE id=:id";
        Long count = (Long) session.createQuery(String.format(hql, getEntityTableName()))
                .setParameter("id", id)
                .uniqueResult();
        return count > 0;
    }

    protected abstract String getEntityTableName();
}
