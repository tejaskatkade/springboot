package com.tejas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //Creating student
        Student s = new Student(13,"sachin","Mumbai");
        System.out.println(s);
        
        // Session session = factory.getCurrentSession();
        Session session = factory.openSession();

        // session.beginTransaction();  // start transaction
        // session.persist(s);  // save() is deprecated
        // session.getTransaction().commit(); //session gives current trancsaction and commity it

        // OR
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();

        //System.out.println(factory);
    }
}