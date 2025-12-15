package com.example.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Model.Monstruo;

public class ControllerMonstruo {

    public ControllerMonstruo() {
    }

    public void guardarMonstruo(Monstruo monstruo) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.persist(monstruo);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarMonstruo(Monstruo monstruo) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.merge(monstruo);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarMonstruo(Monstruo monstruo) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.remove(monstruo);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Monstruo obtenerMonstruoPorId(int id) {
        Session session = null;
        Monstruo monstruo = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            monstruo = session.get(Monstruo.class, id);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return monstruo;
    }
}
