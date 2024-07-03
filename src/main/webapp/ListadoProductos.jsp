<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
  	<%@page import="Model.TblProductocl3" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listado de Productos</title>
</head>
<body bgcolor=#c5dec9>
	<h1 align="center" >Listado de Clientes</h1>
	<h2 align="center">
	<a href="RegistrarProductos.jsp" style="text-decoration:none">Registrar Producto</a></h2>
	<table align="center" border="2">
		<tr>
			<td>Codigo</td>
			<td>Nombre</td>
			<td>PV</td>
			<td>PC</td>
			<td>Estado</td>
			<td>Descripcion</td>
			<td colspan="2" align="center">Acciones</td>
			
		<%
			List<TblProductocl3> listadoproducto=(List<TblProductocl3>)request.getAttribute("ListadoProductos");
			if(listadoproducto!=null){
				for(TblProductocl3 lis:listadoproducto){
			%>

			<tr>
			<td>
				<%=lis.getIdproductocl3()%>
			</td>
			<td>
				<%=lis.getNombrecl3()%>
			</td>
			<td>
				<%=lis.getPrecioventacl3()%>
			</td>
			<td>
				<%=lis.getPreciocompcl3()%>
			</td>
			<td>
				<%=lis.getEstadocl3()%>
			</td>
			<td>
				<%=lis.getDescripcl3()%>
			</td>
			<td><a href="ControladorProducto?accion=Eliminar&id=<%=lis.getIdproductocl3() %>">Eliminar</a></td>
	    	<td><a href="ControladorProducto?accion=Modificar&id=<%=lis.getIdproductocl3()%>">Actualizar</a></td>
			</tr>
			<%
   				}
			}  
		%>

	</table>
</body>
</html>