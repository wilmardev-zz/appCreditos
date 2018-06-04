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
import co.com.poli.appcreditos.model.Tipocredito;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author wilmar.duque
 */
public class TipocreditoJpaController implements Serializable {

    public TipocreditoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipocredito tipocredito) throws PreexistingEntityException, Exception {
        if (tipocredito.getCreditoCollection() == null) {
            tipocredito.setCreditoCollection(new ArrayList<Credito_1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Credito_1> attachedCreditoCollection = new ArrayList<Credito_1>();
            for (Credito_1 creditoCollectionCredito_1ToAttach : tipocredito.getCreditoCollection()) {
                creditoCollectionCredito_1ToAttach = em.getReference(creditoCollectionCredito_1ToAttach.getClass(), creditoCollectionCredito_1ToAttach.getId());
                attachedCreditoCollection.add(creditoCollectionCredito_1ToAttach);
            }
            tipocredito.setCreditoCollection(attachedCreditoCollection);
            em.persist(tipocredito);
            for (Credito_1 creditoCollectionCredito_1 : tipocredito.getCreditoCollection()) {
                Tipocredito oldTipocreditoOfCreditoCollectionCredito_1 = creditoCollectionCredito_1.getTipocredito();
                creditoCollectionCredito_1.setTipocredito(tipocredito);
                creditoCollectionCredito_1 = em.merge(creditoCollectionCredito_1);
                if (oldTipocreditoOfCreditoCollectionCredito_1 != null) {
                    oldTipocreditoOfCreditoCollectionCredito_1.getCreditoCollection().remove(creditoCollectionCredito_1);
                    oldTipocreditoOfCreditoCollectionCredito_1 = em.merge(oldTipocreditoOfCreditoCollectionCredito_1);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipocredito(tipocredito.getId()) != null) {
                throw new PreexistingEntityException("Tipocredito " + tipocredito + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipocredito tipocredito) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipocredito persistentTipocredito = em.find(Tipocredito.class, tipocredito.getId());
            Collection<Credito_1> creditoCollectionOld = persistentTipocredito.getCreditoCollection();
            Collection<Credito_1> creditoCollectionNew = tipocredito.getCreditoCollection();
            List<String> illegalOrphanMessages = null;
            for (Credito_1 creditoCollectionOldCredito_1 : creditoCollectionOld) {
                if (!creditoCollectionNew.contains(creditoCollectionOldCredito_1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Credito_1 " + creditoCollectionOldCredito_1 + " since its tipocredito field is not nullable.");
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
            tipocredito.setCreditoCollection(creditoCollectionNew);
            tipocredito = em.merge(tipocredito);
            for (Credito_1 creditoCollectionNewCredito_1 : creditoCollectionNew) {
                if (!creditoCollectionOld.contains(creditoCollectionNewCredito_1)) {
                    Tipocredito oldTipocreditoOfCreditoCollectionNewCredito_1 = creditoCollectionNewCredito_1.getTipocredito();
                    creditoCollectionNewCredito_1.setTipocredito(tipocredito);
                    creditoCollectionNewCredito_1 = em.merge(creditoCollectionNewCredito_1);
                    if (oldTipocreditoOfCreditoCollectionNewCredito_1 != null && !oldTipocreditoOfCreditoCollectionNewCredito_1.equals(tipocredito)) {
                        oldTipocreditoOfCreditoCollectionNewCredito_1.getCreditoCollection().remove(creditoCollectionNewCredito_1);
                        oldTipocreditoOfCreditoCollectionNewCredito_1 = em.merge(oldTipocreditoOfCreditoCollectionNewCredito_1);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipocredito.getId();
                if (findTipocredito(id) == null) {
                    throw new NonexistentEntityException("The tipocredito with id " + id + " no longer exists.");
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
            Tipocredito tipocredito;
            try {
                tipocredito = em.getReference(Tipocredito.class, id);
                tipocredito.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipocredito with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Credito_1> creditoCollectionOrphanCheck = tipocredito.getCreditoCollection();
            for (Credito_1 creditoCollectionOrphanCheckCredito_1 : creditoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tipocredito (" + tipocredito + ") cannot be destroyed since the Credito_1 " + creditoCollectionOrphanCheckCredito_1 + " in its creditoCollection field has a non-nullable tipocredito field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipocredito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipocredito> findTipocreditoEntities() {
        return findTipocreditoEntities(true, -1, -1);
    }

    public List<Tipocredito> findTipocreditoEntities(int maxResults, int firstResult) {
        return findTipocreditoEntities(false, maxResults, firstResult);
    }

    private List<Tipocredito> findTipocreditoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipocredito.class));
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

    public Tipocredito findTipocredito(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipocredito.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipocreditoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipocredito> rt = cq.from(Tipocredito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
