package com.example.Controller;

import com.example.Model.Mago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ControllerMago {

    Controller controller = Controller.getInstance();

    public ControllerMago() {
    }

    public void guardarMago(Mago mago) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = controller.getTransaction();

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
        EntityTransaction tx = controller.getTransaction();

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
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = controller.getTransaction();

        try {
            tx.begin();
            Mago managed = em.find(Mago.class, mago.getId());
            if (managed != null) {
                em.remove(managed);
            }
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public Mago obtenerMagoPorId(int id) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = controller.getTransaction();
        Mago mago = null;

        try {
            tx.begin();
            mago = em.find(Mago.class, id);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }

        return mago;
    }
}
