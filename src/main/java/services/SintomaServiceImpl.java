adcpackage services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

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

}
