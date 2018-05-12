package com.wsh.ssh.dao;

import com.wsh.ssh.domain.PersonModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//Repository用于标注数据访问组件，即DAO类组件
@Repository
@Transactional
public class PersonDao {

    @Resource
    private SessionFactory sessionFactory;

    public Session getSession() throws HibernateException{

            return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPerson(PersonModel personModel) {
        this.getSession().save(personModel);
    }

    public void deletePersonById(String id) {
        String deleteSql = "delete from PersonModel where id = ? ";
        this.getSession().createQuery(deleteSql).setParameter(0, id).executeUpdate();
    }

    public void updatePerson(PersonModel personModel) {
        getSession().update(personModel);
    }

    public List<PersonModel> queryPerson() {
        return this.getSession().createCriteria(PersonModel.class).list();
    }

    public PersonModel queryPersonById(String id) {
        return (PersonModel)this.getSession().createQuery("from PersonModel where id = ?").setParameter(0,id).uniqueResult();
    }

}
