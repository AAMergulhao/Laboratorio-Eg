package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Retorno;
import model.Sintoma;
import services.SintomaService;
import services.SintomaServiceImpl;

@WebServlet(urlPatterns = "/sintoma")
public class SintomaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private SintomaService sintomaService = new SintomaServiceImpl();

    private Retorno retorno = new Retorno();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        Sintoma sintoma = new Sintoma();
        Sintoma sintomaRetornado;

        if (req.getParameter("id") != null)
            sintoma.setId(new Long(req.getParameter("id")));
        if (req.getParameter("nome") != null)
            sintoma.setNome(req.getParameter("nome"));
        if (req.getParameter("descricao") != null)
            sintoma.setDescricao(req.getParameter("descricao"));

        String action = req.getParameter("action");
        switch (action) {
            case "criar":
                sintomaRetornado = sintomaService.criarSintoma(sintoma);
                if (sintomaRetornado != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(sintomaRetornado);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Erro ao criar usuario");
                }
                break;
            case "alterar":
                sintomaRetornado = sintomaService.alterarSintoma(sintoma);
                if (sintomaRetornado != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(sintomaRetornado);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Sintoma não encontrado");
                }
                break;
            case "deletar":
                sintomaRetornado = sintomaService.deletarSintoma(sintoma);
                if (sintomaRetornado != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(sintomaRetornado);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Erro ao deletar encontrado");
                }
                break;
            default:
                retorno.setStatus(0l);
                retorno.setRetorno("Action não encontrado");
                break;

        }
        out.print(new Gson().toJson(retorno));

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        Sintoma sintoma = new Sintoma();
        Sintoma sintomaRetornado;

        if (req.getParameter("id") != null)
            sintoma.setId(new Long(req.getParameter("id")));
        if (req.getParameter("nome") != null)
            sintoma.setNome(req.getParameter("nome"));
        if (req.getParameter("email") != null)
            sintoma.setDescricao(req.getParameter("email"));

        String action = req.getParameter("action");
        switch (action) {
            case "buscarPorId":
                sintomaRetornado = sintomaService.buscarSintomaPorId(sintoma);
                if (sintomaRetornado != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(sintomaRetornado);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Sintoma não encontrado");
                }
                break;
            case "buscarTodos":
                ArrayList<Sintoma> sintomaRetornados = sintomaService.buscarSintomas();
                if (sintomaRetornados != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(sintomaRetornados);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Sintomas não encontrados");
                }
                break;
            default:
                retorno.setStatus(0l);
                retorno.setRetorno("Action não encontrado");
                break;
        }

        out.print(new Gson().toJson(retorno));
    }
}
