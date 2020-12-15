package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Doenca;
import model.Ocorrencia;

public class OcorrenciaServiceImpl implements OcorrenciaService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Ocorrencia adicionarOcorrencia(Doenca doenca, Ocorrencia ocorrencia) {
        Ocorrencia ocorrenciaRetornada = this.buscarOcorrenciaPorData(ocorrencia);

        if (ocorrenciaRetornada != null) {
            ocorrenciaRetornada.setQuantidade(ocorrenciaRetornada.getQuantidade() + ocorrencia.getQuantidade());
            ocorrenciaRetornada.setDoenca(doenca);
            em.getTransaction().begin();
            em.merge(ocorrenciaRetornada);
            em.getTransaction().commit();

            return ocorrenciaRetornada;
        } else {
            ocorrencia.setDoenca(doenca);
            try {
                em.getTransaction().begin();
                em.persist(ocorrencia);
                em.getTransaction().commit();
                return ocorrencia;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    @Override
    public Ocorrencia buscarOcorrenciaPorId(Ocorrencia ocorrencia) {

        Ocorrencia ocorrenciaRetornada = em.find(Ocorrencia.class, ocorrencia.getId());
        if (ocorrenciaRetornada != null) {
            return ocorrenciaRetornada;
        }
        return null;
    }

    @Override
    public Ocorrencia buscarOcorrenciaPorData(Ocorrencia ocorrencia) {
        System.out.println("DAAAAAAAAAAAAAAAAAAAAAAATA  " + this.formatoData.format(ocorrencia.getData()));
        Query query = em.createQuery(
                "SELECT o FROM Ocorrencia o WHERE o.data='" + this.formatoData.format(ocorrencia.getData()) + "'",
                Ocorrencia.class);
        try {
            ArrayList<Ocorrencia> ocorrenciasRetornadas = (ArrayList<Ocorrencia>) query.getResultList();
            if (!ocorrenciasRetornadas.isEmpty()) {
                ocorrencia = ocorrenciasRetornadas.get(0);
                return ocorrencia;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
