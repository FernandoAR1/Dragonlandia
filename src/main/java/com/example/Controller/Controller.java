package com.example.Controller;

import com.example.Model.Bosque;
import com.example.Model.Mago;
import com.example.Model.Monstruo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Controller {

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

    public void simularBatalla(Mago mago, Monstruo monstruo) {
        int i=1;

        while (mago.getVida() > 0 && monstruo.getVida() > 0) {
            mago.lanzarHechizo(monstruo);
            monstruo.atacar(mago);
            System.out.println("Ronda "+ i );
            System.out.println("Vida del mago " + mago.getNombre() + ": " + mago.getVida());
            System.out.println("Vida del monstruo " + monstruo.getNombre() + ": " + monstruo.getVida());
            i++;
        }

        if (mago.getVida() > 0) {
            System.out.println("El mago " + mago.getNombre() + " domina el bosque!");
        } else {
            System.out.println("El monstruo " + monstruo.getNombre() + " domina el bosque!");
        }
    }
}
