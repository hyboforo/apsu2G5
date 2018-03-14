/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dikantech.apsu2005.services;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateJdbcException;

/**
 *
 * @author GEN-NTB-431
 */
public class PersonDAO extends DefaultHibernateDAOImpl{
    
    
    private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);
    
     public List<PersonEntity> getAllMembers(){
         Criteria cr = createCriteria(PersonEntity.class);      
        List<PersonEntity> members = cr.list();
        logger.info(members.size() + " license found");
        return members;
            
    }
     
      public void saveOrUpdate(PersonEntity members){
        try {
           super.saveOrUpdate(members);
        } catch (HibernateJdbcException ex) {
            logger.error(ex.getLocalizedMessage());
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
        }
    }
    
    /**
     * Write a new offender into the database 
     * @param members
     */
    public void persistMember(PersonEntity members){
        try {
           super.persist(members);
        } catch (HibernateJdbcException ex) {
            logger.error(ex.getLocalizedMessage());
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
        }
        
    }
    
    public List<PersonEntity> getMemberByHouse(String house){
        Criteria cr = createCriteria(PersonEntity.class);
        cr.add(Restrictions.eq("house", house));
        List<PersonEntity> members =  cr.list();
        return members;
        
    }
    
     public List<PersonEntity> getMemberByCourse(String course){
        Criteria cr = createCriteria(PersonEntity.class);
        cr.add(Restrictions.eq("course", course));
        List<PersonEntity> members =  cr.list();
        return members;
        
    }
     
     public List<PersonEntity> getMemberByClass(String courseClass){
        Criteria cr = createCriteria(PersonEntity.class);
        cr.add(Restrictions.eq("class", courseClass));
        List<PersonEntity> members =  cr.list();
        return members;
        
    }
     
     public List<PersonEntity> getMemberByCountry(String country){
        Criteria cr = createCriteria(PersonEntity.class);
        cr.add(Restrictions.eq("country", country));
        List<PersonEntity> members =  cr.list();
        return members;
        
    }
        
}
