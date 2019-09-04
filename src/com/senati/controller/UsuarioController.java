package com.senati.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senati.dao.UsuarioDAO;
import com.senati.model.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet(description = "administra peticiones para la tabla usuarios", urlPatterns = { "/usuario" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String opcion=request.getParameter("opcion");
		if (opcion.equals("crear")) {
			System.out.println("Usted ha presionado opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/crear.jsp");
			requestDispatcher.forward(request, response);
		}else if (opcion.equals("listar")){
			System.out.println("Usted ha presionado opcion listar");
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> lista = new ArrayList<>();
			try {
				lista=usuarioDAO.obtenerUsuario();
				for (Usuario usuario : lista) {
					System.out.println(usuario);
				}
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/listar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String opcion=request.getParameter("opcion");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setNombre_usu(request.getParameter("nombre"));
		usuario.setClave(request.getParameter("clave"));
		
		try {
			usuarioDAO.guardar(usuario);
			System.out.println("Conforme");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
