package com.example.Controller;

import com.example.Model.Hechizo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ControllerHechizo {

    Controller controller = Controller.getInstance();

    public ControllerHechizo() {
    }

    public void guardarHechizo(Hechizo hechizo) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = controller.getTransaction();

        try {
            tx.begin();
            em.persist(hechizo);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void actualizarHechizo(Hechizo hechizo) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = controller.getTransaction();

        try {
            tx.begin();
            em.merge(hechizo);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void eliminarHechizo(Hechizo hechizo) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = controller.getTransaction();

        try {
            tx.begin();
            Hechizo managed = em.contains(hechizo) ? hechizo : em.merge(hechizo);
            em.remove(managed);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public Hechizo obtenerHechizoPorId(int id) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = controller.getTransaction();
        Hechizo hechizo = null;

        try {
            tx.begin();

            hechizo = em.find(Hechizo.class, id);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }

        return hechizo;
    }
}
