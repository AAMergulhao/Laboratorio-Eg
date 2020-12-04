package services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Doenca;

public class DoencaServiceImpl implements DoencaService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    @Override
    public Doenca criarDoenca(Doenca doenca) {

        try {
            em.getTransaction().begin();
            em.persist(doenca);
            em.getTransaction().commit();
            return doenca;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Doenca deletarDoenca(Doenca doenca) {
        if (buscarDoencaPorId(doenca) != null) {
            em.getTransaction().begin();
            em.remove(em.find(Doenca.class, doenca.getId()));
            em.getTransaction().commit();
            return doenca;
        }
        return null;
    }

    @Override
    public Doenca alterarDoenca(Doenca doenca) {
        if (buscarDoencaPorId(doenca) != null) {
            em.getTransaction().begin();
            em.merge(doenca);
            em.getTransaction().commit();

            return doenca;
        }
        return null;
    }

    @Override
    public Doenca buscarDoencaPorId(Doenca doenca) {
        try {
            return em.find(Doenca.class, doenca.getId());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Doenca> buscarDoencas() {
        Query query = em.createQuery("SELECT d FROM Doenca d");

        ArrayList<Doenca> doencasRetornados = (ArrayList<Doenca>) query.getResultList();

        if (!doencasRetornados.isEmpty()) {
            return doencasRetornados;
        }
        return null;
    }

}
