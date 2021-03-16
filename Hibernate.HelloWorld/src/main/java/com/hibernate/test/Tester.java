package com.hibernate.test;

import org.hibernate.Session;

import com.hibernate.pojo.TEST_BLOB_CONTENT;
import com.hibernate.util.HibernateUtil;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + Oracle");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        TEST_BLOB_CONTENT testBlob = new TEST_BLOB_CONTENT();

        testBlob.setFILE_NAME("Hibernate Test");
        testBlob.setBLOB_CONTENT(null);

        session.save(testBlob);
        session.getTransaction().commit();
    }
}
