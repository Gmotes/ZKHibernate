/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2i.zk.zkhibernate;


import com.i2i.zk.zkhibernate.domain.Student;
import java.util.List;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SpringTest  {

    
    @WireVariable
    private ZKSpringHibernate zkSpringHibernateImpl;
    
    
    @AfterCompose
    public void initSetup(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);

    }
    
    
    public List<Student> getStudentListData() {
        List<Student> result = zkSpringHibernateImpl.findAll();
        return new ListModelList<Student>(result);
    }
    
   
}
