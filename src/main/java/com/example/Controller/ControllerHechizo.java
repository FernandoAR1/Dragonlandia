package com.example.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Model.Hechizo;

public class ControllerHechizo {

    public ControllerHechizo() {
    }

    public void guardarHechizo(Hechizo hechizo) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.persist(hechizo);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarHechizo(Hechizo hechizo) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.merge(hechizo);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarHechizo(Hechizo hechizo) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.remove(hechizo);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Hechizo obtenerHechizoPorId(int id) {
        Session session = null;
        Hechizo hechizo = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            hechizo = session.get(Hechizo.class, id);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return hechizo;
    }
}
