package com.example.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Model.Mago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ControllerMago {

    Controller controller = Controller.getInstance();

    public ControllerMago() {
    }

    public void guardarMago(Mago mago) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(mago);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void actualizarMago(Mago mago) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(mago);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
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
