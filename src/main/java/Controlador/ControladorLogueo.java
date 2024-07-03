package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TblLogueoImp;
import Model.TblUsuariocl3;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorLogueo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogueo() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreUsuario = request.getParameter("usuariocl3");
	    String contraseña = request.getParameter("passwordcl3");

	    TblUsuariocl3 cliente = new TblUsuariocl3();
	    cliente.setUsuariocl3(nombreUsuario);;
	    cliente.setPasswordcl3(contraseña);;

	    TblLogueoImp logueoDao = new TblLogueoImp();
	    TblUsuariocl3 usuarioEncontrado = logueoDao.BuscarUsuario(cliente);

	    if (usuarioEncontrado != null) {
	    	response.sendRedirect("index.jsp");
	        System.out.println("CREDENCIALES CORRECTAS");
	    } else {
	    	System.out.println("Contraseña incorrecta");
	        response.sendRedirect("Error.jsp");
	    }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
