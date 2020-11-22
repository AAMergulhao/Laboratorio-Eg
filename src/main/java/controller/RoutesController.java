package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import java.io.PrintWriter;

@WebServlet({ "*.action", "/" })
public class RoutesController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		ServletContext sc = req.getServletContext();
		System.out.println(path);
		switch (path) {
			case "/":
				try {
					sc.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "/home":
				try {
					sc.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "/cadastro_doenca":
				try {
					sc.getRequestDispatcher("/jsp/cadastro_doenca.jsp").forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			default:
				break;
		}
	}
}