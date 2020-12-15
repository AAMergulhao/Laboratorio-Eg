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
import com.google.gson.GsonBuilder;

import model.Doenca;
import model.Retorno;
import services.DoencaService;
import services.DoencaServiceImpl;

@WebServlet(urlPatterns = "/doenca")
public class DoencaController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    private DoencaService doencaService = new DoencaServiceImpl();

    private Retorno retorno = new Retorno();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        Doenca doenca = new Doenca();
        Doenca doencaRetornada;

        if (req.getParameter("id") != null)
            doenca.setId(new Long(req.getParameter("id")));
        if (req.getParameter("nome") != null)
            doenca.setNome(req.getParameter("nome"));
        if (req.getParameter("descricao") != null)
            doenca.setDescricao(req.getParameter("descricao"));

        String action = req.getParameter("action");
        switch (action) {
            case "criar":
                doencaRetornada = doencaService.criarDoenca(doenca);
                if (doencaRetornada != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(doencaRetornada);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Erro ao criar usuario");
                }
                break;
            case "alterar":
                doencaRetornada = doencaService.alterarDoenca(doenca);
                if (doencaRetornada != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(doencaRetornada);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Doenca não encontrada");
                }
                break;
            case "deletar":
                doencaRetornada = doencaService.deletarDoenca(doenca);
                if (doencaRetornada != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(doencaRetornada);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Erro ao deletar doença");
                }
                break;
            default:
                retorno.setStatus(0l);
                retorno.setRetorno("Action não encontrada");
                break;

        }
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        out.print( gson.toJson(retorno));

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();

        Doenca doenca = new Doenca();
        Doenca doencaRetornada = null;
        ArrayList<Doenca> doencaRetornadas = new ArrayList();
        

        if (req.getParameter("id") != null)
            doenca.setId(new Long(req.getParameter("id")));
        if (req.getParameter("nome") != null)
            doenca.setNome(req.getParameter("nome"));
        if (req.getParameter("email") != null)
            doenca.setDescricao(req.getParameter("email"));

        String action = req.getParameter("action");
        switch (action) {
            case "buscarPorId":
                doencaRetornada = doencaService.buscarDoencaPorId(doenca);
                if (doencaRetornada != null) {
                    retorno.setStatus(1l);
                    retorno.setRetorno(doencaRetornada);
                } else {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Doencas não encontrada");
                }
                break;
            case "buscarTodos":
                doencaRetornadas = doencaService.buscarDoencas();
                if (doencaRetornadas == null) {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Doencas não encontradas");
                }
                break;
            default:
                retorno.setStatus(0l);
                retorno.setRetorno("Action não encontrada");
                break;
        }

        if (doencaRetornada != null) {
            retorno.setStatus(1l);
            retorno.setRetorno(doencaRetornada);
        }

        if (!doencaRetornadas.isEmpty()) {
            retorno.setStatus(1l);
            retorno.setRetorno(doencaRetornadas);
        }
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        out.print( gson.toJson(retorno));
    }
}
