package services;

import model.Doenca;
import model.Ocorrencia;

public interface OcorrenciaService {
    
    public Ocorrencia adicionarOcorrencia(Doenca doenca, Ocorrencia ocorrencia);

    public Ocorrencia buscarOcorrenciaPorId(Ocorrencia ocorrencia);

    public Ocorrencia buscarOcorrenciaPorData(Ocorrencia ocorrencia);
}
