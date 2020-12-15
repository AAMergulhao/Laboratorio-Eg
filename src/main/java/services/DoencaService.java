package services;

import java.util.ArrayList;

import model.Doenca;

public interface DoencaService {
    
    public Doenca criarDoenca(Doenca doenca);

    public Doenca deletarDoenca(Doenca doenca);

    public Doenca alterarDoenca(Doenca doenca);

    public Doenca buscarDoencaPorId(Doenca doenca);
    
    public ArrayList<Doenca> buscarDoencas();
}
