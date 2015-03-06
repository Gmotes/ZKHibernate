/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2i.zk.zkhibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Repository
public abstract class AbstractHibernateDAO< T extends Serializable>{
    private Class< T > clazz;

    @Autowired
    SessionFactory sessionFactory;



    public void setClazz( final Class< T > clazzToSet ){
        clazz = clazzToSet;
    }


    public T findOne( final Long id ){
        //   Preconditions.checkArgument( id != null );
        return (T) getCurrentSession().get( clazz, id );
    }



    public List< T > findAll(){
        return getCurrentSession()
                .createQuery( "from " + clazz.getName() ).list();
    }

    public void save( final T entity ){
        //     Preconditions.checkNotNull( entity );
        getCurrentSession().persist( entity );
    }

    public void update( final T entity ){
        //  Preconditions.checkNotNull( entity );
        getCurrentSession().merge( entity );
    }

    public void delete( final T entity ){
        //    Preconditions.checkNotNull( entity );
        getCurrentSession().delete( entity );
    }
    public void deleteById( final Long entityId ){
        final T entity = findOne( entityId );
        //    Preconditions.checkState( entity != null );
        delete( entity );
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


}