package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TblProductoImp;
import Model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblProductocl3 prodcuto = new TblProductocl3();
		TblProductoImp crud = new TblProductoImp();
		
		String accion = request.getParameter("accion");

		if(accion!=null) {
			switch (accion) {
			case "Modificar":
				int id = Integer.parseInt(request.getParameter("id"));
                
                prodcuto.setIdproductocl3(id);
                TblProductocl3 buscar = crud.BuscarProducto(prodcuto);
                
                request.setAttribute("idproductocl3", buscar.getIdproductocl3());
                request.setAttribute("nombrecl3", buscar.getNombrecl3());
                request.setAttribute("precioventacl3", buscar.getPrecioventacl3());
                request.setAttribute("preciocompcl3", buscar.getPreciocompcl3());
                request.setAttribute("estadocl3", buscar.getEstadocl3());
                request.setAttribute("descripcl3", buscar.getDescripcl3());
                
                request.getRequestDispatcher("/ActualizarProductos.jsp").forward(request, response);
                break;
				
			case "Eliminar":
				int idEli = Integer.parseInt(request.getParameter("id"));
				prodcuto.setIdproductocl3(idEli);
				crud.EliminarProducto(prodcuto);
				List<TblProductocl3> lista = crud.ListarProducto();
				request.setAttribute("listaproductos", lista);
				request.getRequestDispatcher("/ListadoProductos.jsp");
				break;
			}
		}
		
		List<TblProductocl3> listadoproducto =crud.ListarProducto();
		request.setAttribute("ListadoProductos", listadoproducto);
		request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idprod = request.getParameter("idproductocl3");
        String nombre = request.getParameter("nombrecl3");
        double precioVen = Double.parseDouble(request.getParameter("precioventacl3"));
        double precioCom = Double.parseDouble(request.getParameter("preciocompcl3"));
        String estado = request.getParameter("estadocl3");
        String descripcion = request.getParameter("descripcl3");

        TblProductocl3 prod = new TblProductocl3();
        TblProductoImp crud = new TblProductoImp();

        prod.setNombrecl3(nombre);
        prod.setPrecioventacl3(precioVen);
        prod.setPreciocompcl3(precioCom);
        prod.setEstadocl3(estado);
        prod.setDescripcl3(descripcion);

        if (idprod != null && !idprod.trim().isEmpty()) {
            Integer cod = Integer.parseInt(idprod);
            prod.setIdproductocl3(cod);
            crud.ActualizarProducto(prod);
        } else {
            crud.RegistrarProducto(prod);
        }

        List<TblProductocl3> listadoproducto = crud.ListarProducto();

       
		request.setAttribute("ListadoProductos", listadoproducto);
		request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
		
	}

}
