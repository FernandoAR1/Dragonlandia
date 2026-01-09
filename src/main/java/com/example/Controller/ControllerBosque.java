package com.example.Controller;

import com.example.Model.Bosque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ControllerBosque {

    Controller controller = Controller.getInstance();

    public ControllerBosque() {;
    }

    public void guardarBosque(Bosque bosque) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(bosque);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void actualizarBosque(Bosque bosque) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(bosque);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void eliminarBosque(Bosque bosque) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Bosque managed = em.contains(bosque) ? bosque : em.merge(bosque);
            em.remove(managed);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public Bosque obtenerBosquePorId(int id) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Bosque bosque = null;

        try {
            tx.begin();
            bosque = em.find(Bosque.class, id);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }

        return bosque;
    }
}
