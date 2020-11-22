package services;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Sintoma;

public class SintomaServiceImpl implements SintomaService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    @Override
    public Sintoma criarSintoma(Sintoma sintoma) {

        try {
            em.getTransaction().begin();
            em.persist(sintoma);
            em.getTransaction().commit();
            return sintoma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Sintoma deletarSintoma(Sintoma sintoma) {
        if (buscarSintomaPorId(sintoma) != null) {
            em.getTransaction().begin();
            em.remove(em.find(Sintoma.class, sintoma.getId()));
            em.getTransaction().commit();
            return sintoma;
        }
        return null;

    }

    @Override
    public Sintoma alterarSintoma(Sintoma sintoma) {
        if (buscarSintomaPorId(sintoma) != null) {
            em.getTransaction().begin();
            em.merge(sintoma);
            em.getTransaction().commit();

            return sintoma;
        }
        return null;

    }

    @Override
    public Sintoma buscarSintomaPorId(Sintoma sintoma) throws NoResultException {
        try {
            return em.find(Sintoma.class, sintoma.getId());
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ArrayList<Sintoma> buscarSintomas() {
        Query query = em.createQuery("SELECT s FROM Sintoma s");

        ArrayList<Sintoma> sintomasRetornados = (ArrayList<Sintoma>)query.getResultList();

        if(!sintomasRetornados.isEmpty()){
            return sintomasRetornados;
        }
        return null;
    }

}
