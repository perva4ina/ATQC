package com.gmail.perva4ina.BE.OnlineShop;

import com.gmail.perva4ina.helper.HibernateClient;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class BusinessEntity {

    public void addEntity() {
        Session session = null;
        try {
            session = HibernateClient.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(this);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
