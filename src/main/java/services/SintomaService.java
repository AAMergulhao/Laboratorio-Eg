package services;

import model.Sintoma;

public interface SintomaService {
    
    public Sintoma criarSintoma(Sintoma sintoma);

    public Sintoma deletarSintoma(Sintoma sintoma);

    public Sintoma alterarSintoma(Sintoma sintoma);

    public Sintoma buscarSintomaPorId(Sintoma sintoma);
}
