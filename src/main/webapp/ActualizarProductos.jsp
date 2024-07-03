<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="Model.TblProductocl3" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Actualizar producto</title>
</head>
<body  bgcolor="#c5dec9">
    <h1 align="center">Actualizar producto</h1>

    <form method="post" action="ControladorProducto">

    <%
        String id = (request.getAttribute("idproductocl3") != null) ? request.getAttribute("idproductocl3").toString() : "";
        String nom = (request.getAttribute("nombrecl3") != null) ? request.getAttribute("nombrecl3").toString() : "";
        String pventa = (request.getAttribute("precioventacl3") != null) ? request.getAttribute("precioventacl3").toString() : "";
        String pcompra = (request.getAttribute("preciocompcl3") != null) ? request.getAttribute("preciocompcl3").toString() : "";
        String estado = (request.getAttribute("estadocl3") != null) ? request.getAttribute("estadocl3").toString() : "";
        String descri = (request.getAttribute("descripcl3") != null) ? request.getAttribute("descripcl3").toString() : "";  
    %>
    <table align="center" border="2">
        <input type="hidden" name="idproductocl3" value="<%= id %>">
        <tr>
            <td>Nombre</td>
            <td><input type="text" name="nombrecl3" value="<%= nom %>"></td>
        </tr>
        <tr>
            <td>Precio Venta</td>
            <td><input type="text" name="precioventacl3" value="<%= pventa %>"></td>
        </tr>
        <tr>
            <td>Precio Compra</td>
            <td><input type="text" name="preciocompcl3" value="<%= pcompra %>"></td>
        </tr>
        <tr>
            <td>Estado</td>
            <td><input type="text" name="estadocl3" value="<%= estado %>"></td>
        </tr>
        <tr>
            <td>Descripcion</td>
            <td><input type="text" name="descripcl3" value="<%= descri %>"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Actualizar Producto"></td>
        </tr>
    </table>
    </form>
</body>
</html>
