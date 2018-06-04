/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.appcreditos.jpacontroller;

import co.com.poli.appcreditos.jpacontroller.exceptions.IllegalOrphanException;
import co.com.poli.appcreditos.jpacontroller.exceptions.NonexistentEntityException;
import co.com.poli.appcreditos.jpacontroller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.com.poli.appcreditos.model.Credito_1;
import co.com.poli.appcreditos.model.Tipotrabajador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author wilmar.duque
 */
public class TipotrabajadorJpaController implements Serializable {

    public TipotrabajadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipotrabajador tipotrabajador) throws PreexistingEntityException, Exception {
        if (tipotrabajador.getCreditoCollection() == null) {
            tipotrabajador.setCreditoCollection(new ArrayList<Credito_1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Credito_1> attachedCreditoCollection = new ArrayList<Credito_1>();
            for (Credito_1 creditoCollectionCredito_1ToAttach : tipotrabajador.getCreditoCollection()) {
                creditoCollectionCredito_1ToAttach = em.getReference(creditoCollectionCredito_1ToAttach.getClass(), creditoCollectionCredito_1ToAttach.getId());
                attachedCreditoCollection.add(creditoCollectionCredito_1ToAttach);
            }
            tipotrabajador.setCreditoCollection(attachedCreditoCollection);
            em.persist(tipotrabajador);
            for (Credito_1 creditoCollectionCredito_1 : tipotrabajador.getCreditoCollection()) {
                Tipotrabajador oldTipotrabajadorOfCreditoCollectionCredito_1 = creditoCollectionCredito_1.getTipotrabajador();
                creditoCollectionCredito_1.setTipotrabajador(tipotrabajador);
                creditoCollectionCredito_1 = em.merge(creditoCollectionCredito_1);
                if (oldTipotrabajadorOfCreditoCollectionCredito_1 != null) {
                    oldTipotrabajadorOfCreditoCollectionCredito_1.getCreditoCollection().remove(creditoCollectionCredito_1);
                    oldTipotrabajadorOfCreditoCollectionCredito_1 = em.merge(oldTipotrabajadorOfCreditoCollectionCredito_1);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipotrabajador(tipotrabajador.getId()) != null) {
                throw new PreexistingEntityException("Tipotrabajador " + tipotrabajador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipotrabajador tipotrabajador) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipotrabajador persistentTipotrabajador = em.find(Tipotrabajador.class, tipotrabajador.getId());
            Collection<Credito_1> creditoCollectionOld = persistentTipotrabajador.getCreditoCollection();
            Collection<Credito_1> creditoCollectionNew = tipotrabajador.getCreditoCollection();
            List<String> illegalOrphanMessages = null;
            for (Credito_1 creditoCollectionOldCredito_1 : creditoCollectionOld) {
                if (!creditoCollectionNew.contains(creditoCollectionOldCredito_1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Credito_1 " + creditoCollectionOldCredito_1 + " since its tipotrabajador field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Credito_1> attachedCreditoCollectionNew = new ArrayList<Credito_1>();
            for (Credito_1 creditoCollectionNewCredito_1ToAttach : creditoCollectionNew) {
                creditoCollectionNewCredito_1ToAttach = em.getReference(creditoCollectionNewCredito_1ToAttach.getClass(), creditoCollectionNewCredito_1ToAttach.getId());
                attachedCreditoCollectionNew.add(creditoCollectionNewCredito_1ToAttach);
            }
            creditoCollectionNew = attachedCreditoCollectionNew;
            tipotrabajador.setCreditoCollection(creditoCollectionNew);
            tipotrabajador = em.merge(tipotrabajador);
            for (Credito_1 creditoCollectionNewCredito_1 : creditoCollectionNew) {
                if (!creditoCollectionOld.contains(creditoCollectionNewCredito_1)) {
                    Tipotrabajador oldTipotrabajadorOfCreditoCollectionNewCredito_1 = creditoCollectionNewCredito_1.getTipotrabajador();
                    creditoCollectionNewCredito_1.setTipotrabajador(tipotrabajador);
                    creditoCollectionNewCredito_1 = em.merge(creditoCollectionNewCredito_1);
                    if (oldTipotrabajadorOfCreditoCollectionNewCredito_1 != null && !oldTipotrabajadorOfCreditoCollectionNewCredito_1.equals(tipotrabajador)) {
                        oldTipotrabajadorOfCreditoCollectionNewCredito_1.getCreditoCollection().remove(creditoCollectionNewCredito_1);
                        oldTipotrabajadorOfCreditoCollectionNewCredito_1 = em.merge(oldTipotrabajadorOfCreditoCollectionNewCredito_1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipotrabajador.getId();
                if (findTipotrabajador(id) == null) {
                    throw new NonexistentEntityException("The tipotrabajador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipotrabajador tipotrabajador;
            try {
                tipotrabajador = em.getReference(Tipotrabajador.class, id);
                tipotrabajador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipotrabajador with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Credito_1> creditoCollectionOrphanCheck = tipotrabajador.getCreditoCollection();
            for (Credito_1 creditoCollectionOrphanCheckCredito_1 : creditoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tipotrabajador (" + tipotrabajador + ") cannot be destroyed since the Credito_1 " + creditoCollectionOrphanCheckCredito_1 + " in its creditoCollection field has a non-nullable tipotrabajador field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipotrabajador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipotrabajador> findTipotrabajadorEntities() {
        return findTipotrabajadorEntities(true, -1, -1);
    }

    public List<Tipotrabajador> findTipotrabajadorEntities(int maxResults, int firstResult) {
        return findTipotrabajadorEntities(false, maxResults, firstResult);
    }

    private List<Tipotrabajador> findTipotrabajadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipotrabajador.class));
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

    public Tipotrabajador findTipotrabajador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipotrabajador.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipotrabajadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipotrabajador> rt = cq.from(Tipotrabajador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
