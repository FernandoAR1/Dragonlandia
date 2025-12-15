package com.example.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Model.Mago;

public class ControllerMago {

    public ControllerMago() {
    }

    public void guardarMago(Mago mago) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.persist(mago);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarMago(Mago mago) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.merge(mago);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarMago(Mago mago) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.remove(mago);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Mago obtenerMagoPorId(int id) {
        Session session = null;
        Mago mago = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            mago = session.get(Mago.class, id);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return mago;
    }
}
