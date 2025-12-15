package com.example.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Model.Dragon;

public class ControllerDragon {

    public ControllerDragon() {
    }

    public void guardarDragon(Dragon dragon) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.persist(dragon);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarDragon(Dragon dragon) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.merge(dragon);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarDragon(Dragon dragon) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.remove(dragon);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Dragon obtenerDragonPorId(int id) {
        Session session = null;
        Dragon dragon = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            dragon = session.get(Dragon.class, id);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return dragon;
    }
}
