package com.example.Controller;

import com.example.Model.Dragon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ControllerDragon {

    Controller controller = Controller.getInstance();

    public ControllerDragon() {
    }

    public void guardarDragon(Dragon dragon) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(dragon);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void actualizarDragon(Dragon dragon) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(dragon);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void eliminarDragon(Dragon dragon) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Dragon managed = em.contains(dragon) ? dragon : em.merge(dragon);
            em.remove(managed);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public Dragon obtenerDragonPorId(int id) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Dragon dragon = null;

        try {
            tx.begin();
            dragon = em.find(Dragon.class, id);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }

        return dragon;
    }
}
