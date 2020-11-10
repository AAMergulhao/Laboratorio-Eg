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
		switch (path) {
			case "/":
				System.out.println(path);
				try {
					sc.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "/home":
				System.out.println(path);
				try {
					sc.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			default:
				break;
		}
	}
}