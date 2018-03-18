/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dikantech.apsu2005.services;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author GEN-NTB-431
 */
@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);
    @Resource
    PersonServices personServices;
    @Resource
    TransactionTemplate transactionTemplate;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("person", new PersonEntity());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("person") PersonEntity person) {
        try {

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus ts) {
                    try {
                        personServices.addMember(person);
                    } catch (Exception ex) {
                        logger.error("Failed to process subjects within transaction: " + ex.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
        }
        personServices.sendMail("Thank You", "Thank you for registering your details", person.getEmail());
        return new ModelAndView("welcome", "firstname", person.getFirstName());
    }

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public ModelAndView showMail(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("mail");
        mav.addObject("mailer", new Mailer());
        return mav;
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public ModelAndView showMembers(HttpServletRequest request, HttpServletResponse response) {
         return transactionTemplate.execute(new TransactionCallback<ModelAndView>() {
            @Override
            public ModelAndView doInTransaction(TransactionStatus ts) {
                try {
                    List<PersonEntity> list = new ArrayList<>();
                    list = personServices.getMembers();
                    ModelAndView view = new ModelAndView("showAll", "members", list);
                    logger.info("Got all members, returning");
                    return view;
                } catch (Exception ex) {
                    logger.error("Failed to process subjects within transaction: " + ex.getLocalizedMessage());
                }
                logger.info("failed to return in try");
                return null;
            }

        });
    }

    @RequestMapping(value = "/mailProcess", method = RequestMethod.POST)
    public ModelAndView sendMail(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("mailer") Mailer mailer) {
        try {

            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus ts) {
                    try {
                        List<PersonEntity> members = personServices.getMembers();
                        for (PersonEntity member : members) {
                            personServices.sendMail(mailer.getSubject(), mailer.getMessage(), member.getEmail());
                        }
                    } catch (Exception ex) {
                        logger.error("Failed to process subjects within transaction: " + ex.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
        }
        return new ModelAndView("sent");
    }

}
