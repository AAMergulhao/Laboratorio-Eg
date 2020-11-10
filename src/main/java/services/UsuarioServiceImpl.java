package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();
    
    @Override
    public Usuario criarUsuario(Usuario usuario) {
        System.out.println(usuario);
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    @Override
    public Usuario buscarUsuarioPorEmailESenha(Usuario usuario) {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email=:email AND u.senha=:senha");
        query.setParameter("email", usuario.getEmail());
        query.setParameter("senha", usuario.getSenha());
        Usuario usuarioRetornado = (Usuario)query.getSingleResult();
        
        return usuarioRetornado;
    }

    @Override
    public void deletarUsuario(Usuario Usuario) {
        // TODO Auto-generated method stub

    }
    
}
