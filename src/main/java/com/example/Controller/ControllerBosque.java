package com.example.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Model.Bosque;

public class ControllerBosque {

    public ControllerBosque() {
    }

    public void guardarBosque(Bosque bosque) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.persist(bosque);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarBosque(Bosque bosque) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.merge(bosque);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarBosque(Bosque bosque) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.remove(bosque);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Bosque obtenerBosquePorId(int id) {
        Session session = null;
        Bosque bosque = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            bosque = session.get(Bosque.class, id);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return bosque;
    }
}
