package com.example.Controller;

import com.example.Model.Monstruo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ControllerMonstruo {

    Controller controller = Controller.getInstance();

    public ControllerMonstruo() {
    }

    public void guardarMonstruo(Monstruo monstruo) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(monstruo);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void actualizarMonstruo(Monstruo monstruo) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(monstruo);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public void eliminarMonstruo(Monstruo monstruo) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Monstruo managed = em.contains(monstruo) ? monstruo : em.merge(monstruo);
            em.remove(managed);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    public Monstruo obtenerMonstruoPorId(int id) {
        EntityManager em = controller.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Monstruo monstruo = null;

        try {
            tx.begin();
            monstruo = em.find(Monstruo.class, id);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (em.isOpen()) em.close();
        }

        return monstruo;
    }
}
