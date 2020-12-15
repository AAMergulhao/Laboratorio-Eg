package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Doenca;
import model.Ocorrencia;
import model.Retorno;
import services.DoencaService;
import services.DoencaServiceImpl;
import services.OcorrenciaService;
import services.OcorrenciaServiceImpl;

@WebServlet(urlPatterns = "/ocorrencia")
public class OcorrenciaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private OcorrenciaService OcorrenciaService = new OcorrenciaServiceImpl();
    private DoencaService doencaService = new DoencaServiceImpl();

    private Retorno retorno = new Retorno();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        Ocorrencia ocorrencia = new Ocorrencia();
        Ocorrencia OcorrenciaRetornada = null;

        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");

        if (req.getParameter("id") != null)
            ocorrencia.setId(new Long(req.getParameter("id")));
        if (req.getParameter("quantidade") != null)
            ocorrencia.setQuantidade(new Long(req.getParameter("quantidade")));

        if (req.getParameter("data") != null) {
            try {
                ocorrencia.setData(formatoData.parse(req.getParameter("data")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        String action = req.getParameter("action");
        switch (action) {
            case "adicionar":
                Doenca doenca = new Doenca();
                doenca.setId(new Long(req.getParameter("doencaId")));
                doenca = doencaService.buscarDoencaPorId(doenca);
                OcorrenciaRetornada = OcorrenciaService.adicionarOcorrencia(doenca, ocorrencia);
                if (OcorrenciaRetornada == null) {
                    retorno.setStatus(0l);
                    retorno.setRetorno("Erro ao adicionar ocorrencia");
                }
                break;
            default:
                retorno.setStatus(0l);
                retorno.setRetorno("Action não encontrada");
                break;

        }
        if (OcorrenciaRetornada != null) {
            retorno.setStatus(1l);
            retorno.setRetorno(OcorrenciaRetornada);
        }
        
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        out.print( gson.toJson(retorno));

    }
}
