/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dikantech.apsu2005.services;

import java.util.List;

/**
 *
 * @author GEN-NTB-431
 */
public class PersonServices {
    PersonDAO personDAO;

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    
    public void addMember(PersonEntity member){
        personDAO.persistMember(member);
    }
    
    public List<PersonEntity> getMembers(){
        List<PersonEntity> allMembers = this.personDAO.getAllMembers();
        return allMembers;
    }
    
    public List<PersonEntity> getMembersByClass(String courseClass){
        List<PersonEntity> allMembers = this.personDAO.getMemberByClass(courseClass);
        return allMembers;
    }
    
     public List<PersonEntity> getMembersByCourse(String course){
        List<PersonEntity> allMembers = this.personDAO.getMemberByCourse(course);
        return allMembers;
    }
     
     public List<PersonEntity> getMembersByCountry(String country){
        List<PersonEntity> allMembers = this.personDAO.getMemberByCountry(country);
        return allMembers;
    }
     
     public List<PersonEntity> getMembersByHouse(String house){
        List<PersonEntity> allMembers = this.personDAO.getMemberByHouse(house);
        return allMembers;
    }
     
    public void sendMail(String subject, String message, String recepeints){
        MailSender sender = new MailSender();
        sender.sendMail(subject, message, recepeints);
        
    }
     
     
     
     
    
}
