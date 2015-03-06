/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2i.zk.zkhibernate.impl;

import com.i2i.zk.zkhibernate.AbstractHibernateDAO;
import com.i2i.zk.zkhibernate.ZKSpringHibernate;
import com.i2i.zk.zkhibernate.domain.Student;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("zkSpringHibernateImpl")
public class ZKSpringHibernateImpl extends AbstractHibernateDAO<Student> implements ZKSpringHibernate  {

  
    public ZKSpringHibernateImpl(){
     setClazz(Student.class );
     }

    @Transactional
    public List<Student> findAll() {
        List<Student> exList;
        
            StringBuffer hqlQuery = new StringBuffer("from Student");
            Query query = getCurrentSession().createQuery(hqlQuery.toString());

            exList =  query.list();

        
        
       return exList;
    }
}
