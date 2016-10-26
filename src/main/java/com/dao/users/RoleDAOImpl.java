package com.dao.users;


import com.dto.users.RoleDTO;
import com.model.security.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    public RoleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(Role role) {
        getCurrentSession().saveOrUpdate(role);
    }

    @Override
    public List<RoleDTO> getListRoles() {
        return getCurrentSession()
                .createSQLQuery("SELECT r.id AS id, r.name_role AS nameRole FROM role r")
                .addScalar("id", IntegerType.INSTANCE)
                .addScalar("nameRole", StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(RoleDTO.class))
                .list();
    }

    @Override
    public Role getRoleByName(String role) {
        return (Role) getCurrentSession()
                .createQuery("from Role r where r.nameRole = :nameRole")
                .setParameter("nameRole", role)
                .uniqueResult();
    }
}