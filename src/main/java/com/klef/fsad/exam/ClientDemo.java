package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;

public class ClientDemo
{
    public static void main(String[] args)
    {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // INSERT using persistent object
        Service s = new Service("Cleaning Service", new Date(), "Pending");
        session.save(s);

        tx.commit();

        System.out.println("Service inserted successfully");

        // HQL UPDATE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String hql = "update Service set name=:name, status=:status where id=:id";

        Query<?> query = session.createQuery(hql);

        query.setParameter("name", "Repair Service");
        query.setParameter("status", "Completed");
        query.setParameter("id", 1);

        int result = query.executeUpdate();

        tx.commit();

        System.out.println("Records updated : " + result);

        session.close();
    }
}
