/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.jpacontroller;

import co.com.poli.appcreditos.jpacontroller.exceptions.NonexistentEntityException;
import co.com.poli.appcreditos.jpacontroller.exceptions.PreexistingEntityException;
import co.com.poli.appcreditos.model.Credito_1;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.com.poli.appcreditos.model.Tipocredito;
import co.com.poli.appcreditos.model.Tipotrabajador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author wilmar.duque
 */
public class Credito_1JpaController implements Serializable {

    public Credito_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Credito_1 credito_1) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipocredito tipocredito = credito_1.getTipocredito();
            if (tipocredito != null) {
                tipocredito = em.getReference(tipocredito.getClass(), tipocredito.getId());
                credito_1.setTipocredito(tipocredito);
            }
            Tipotrabajador tipotrabajador = credito_1.getTipotrabajador();
            if (tipotrabajador != null) {
                tipotrabajador = em.getReference(tipotrabajador.getClass(), tipotrabajador.getId());
                credito_1.setTipotrabajador(tipotrabajador);
            }
            em.persist(credito_1);
            if (tipocredito != null) {
                tipocredito.getCreditoCollection().add(credito_1);
                tipocredito = em.merge(tipocredito);
            }
            if (tipotrabajador != null) {
                tipotrabajador.getCreditoCollection().add(credito_1);
                tipotrabajador = em.merge(tipotrabajador);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCredito_1(credito_1.getId()) != null) {
                throw new PreexistingEntityException("Credito_1 " + credito_1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Credito_1 credito_1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Credito_1 persistentCredito_1 = em.find(Credito_1.class, credito_1.getId());
            Tipocredito tipocreditoOld = persistentCredito_1.getTipocredito();
            Tipocredito tipocreditoNew = credito_1.getTipocredito();
            Tipotrabajador tipotrabajadorOld = persistentCredito_1.getTipotrabajador();
            Tipotrabajador tipotrabajadorNew = credito_1.getTipotrabajador();
            if (tipocreditoNew != null) {
                tipocreditoNew = em.getReference(tipocreditoNew.getClass(), tipocreditoNew.getId());
                credito_1.setTipocredito(tipocreditoNew);
            }
            if (tipotrabajadorNew != null) {
                tipotrabajadorNew = em.getReference(tipotrabajadorNew.getClass(), tipotrabajadorNew.getId());
                credito_1.setTipotrabajador(tipotrabajadorNew);
            }
            credito_1 = em.merge(credito_1);
            if (tipocreditoOld != null && !tipocreditoOld.equals(tipocreditoNew)) {
                tipocreditoOld.getCreditoCollection().remove(credito_1);
                tipocreditoOld = em.merge(tipocreditoOld);
            }
            if (tipocreditoNew != null && !tipocreditoNew.equals(tipocreditoOld)) {
                tipocreditoNew.getCreditoCollection().add(credito_1);
                tipocreditoNew = em.merge(tipocreditoNew);
            }
            if (tipotrabajadorOld != null && !tipotrabajadorOld.equals(tipotrabajadorNew)) {
                tipotrabajadorOld.getCreditoCollection().remove(credito_1);
                tipotrabajadorOld = em.merge(tipotrabajadorOld);
            }
            if (tipotrabajadorNew != null && !tipotrabajadorNew.equals(tipotrabajadorOld)) {
                tipotrabajadorNew.getCreditoCollection().add(credito_1);
                tipotrabajadorNew = em.merge(tipotrabajadorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = credito_1.getId();
                if (findCredito_1(id) == null) {
                    throw new NonexistentEntityException("The credito with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Credito_1 credito_1;
            try {
                credito_1 = em.getReference(Credito_1.class, id);
                credito_1.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The credito with id " + id + " no longer exists.", enfe);
            }
            Tipocredito tipocredito = credito_1.getTipocredito();
            if (tipocredito != null) {
                tipocredito.getCreditoCollection().remove(credito_1);
                tipocredito = em.merge(tipocredito);
            }
            Tipotrabajador tipotrabajador = credito_1.getTipotrabajador();
            if (tipotrabajador != null) {
                tipotrabajador.getCreditoCollection().remove(credito_1);
                tipotrabajador = em.merge(tipotrabajador);
            }
            em.remove(credito_1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Credito_1> findCredito_1Entities() {
        return findCredito_1Entities(true, -1, -1);
    }

    public List<Credito_1> findCredito_1Entities(int maxResults, int firstResult) {
        return findCredito_1Entities(false, maxResults, firstResult);
    }

    private List<Credito_1> findCredito_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Credito_1.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Credito_1 findCredito_1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Credito_1.class, id);
        } finally {
            em.close();
        }
    }

    public int getCredito_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Credito_1> rt = cq.from(Credito_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public String ObtenerCreditoMasutilizado() {
        List<Credito_1> listaCred = findCredito_1Entities();
        int contVivienda = 0;
        int contEstudio = 0;
        int contInversion = 0;
        String mayor = "";
        for (Credito_1 cred : listaCred) {
            switch (cred.getTipocredito().getId()) {
                case 1:
                    contVivienda++;
                    break;
                case 2:
                    contEstudio++;
                    break;
                case 3:
                    contInversion++;
                    break;
            }
        }

        if (contVivienda > contEstudio) {
            if (contVivienda > contInversion) {
                mayor = "Vivienda";
            }
        } else if (contEstudio > contInversion) {
            mayor = "Estudio";
        } else if (contInversion > contVivienda) {
            mayor = "Libre Inversion";
        }
        return mayor;
    }

    public String ObtenerPrestamoMayorAcumulado() {
        List<Credito_1> listaCred = findCredito_1Entities();
        double acumVivienda = 0;
        double acumtEstudio = 0;
        double acumtInversion = 0;
        String mayor = "";
        for (Credito_1 cred : listaCred) {
            switch (cred.getTipocredito().getId()) {
                case 1:
                    acumVivienda += cred.getMontocredito();
                    break;
                case 2:
                    acumtEstudio += cred.getMontocredito();
                    break;
                case 3:
                    acumtInversion += cred.getMontocredito();
                    break;
            }
        }

        if (acumVivienda > acumtEstudio) {
            if (acumVivienda > acumtInversion) {
                mayor = "Vivienda, con un total de: " + acumVivienda;
            }
        } else if (acumtEstudio > acumtInversion) {
            mayor = "Estudio, con un total de: " + acumtEstudio;
        } else if (acumtInversion > acumVivienda) {
            mayor = "Libre Inversión Inversion, con un total de: " + acumtInversion;
        }
        return mayor;
    }

    public String ObtenerMayorPrestamista() {
        String mayor = "";
        List<Credito_1> listaCred = findCredito_1Entities();
        int contIndep = 0;
        int contDep = 0;
        for (Credito_1 cred : listaCred) {
            switch (cred.getTipotrabajador().getId()) {
                case 1:
                    contIndep++;
                    break;
                case 2:
                    contDep++;
                    break;
            }
        }

        if (contIndep >= contDep) {
            mayor = "Independiente";
        } else {
            mayor = "Dependiente";
        }
        return mayor;
    }

}
