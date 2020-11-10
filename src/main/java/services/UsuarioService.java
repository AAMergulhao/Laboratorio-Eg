package services;

import model.Usuario;

public interface UsuarioService {
    
    public Usuario criarUsuario(Usuario usuario);

    public Usuario buscarUsuarioPorEmailESenha(Usuario usuario);

    public void deletarUsuario(Usuario Usuario);

}
