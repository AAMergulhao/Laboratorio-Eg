package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Usuario;
import services.UsuarioService;
import services.UsuarioServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/usuario")
public class UsuarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UsuarioService userService = new UsuarioServiceImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        Usuario usuario = new Usuario();
                usuario.setNome(req.getParameter("nome"));
                usuario.setEmail(req.getParameter("email"));
                usuario.setSenha(req.getParameter("senha"));

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        switch (action) {
            case "criar":
                out.print(new Gson().toJson(userService.criarUsuario(usuario)));
                break;
            case "logar":
                out.print(new Gson().toJson(userService.buscarUsuarioPorEmailESenha(usuario)));
                break;
            default:
                break;
        }

    }

}
