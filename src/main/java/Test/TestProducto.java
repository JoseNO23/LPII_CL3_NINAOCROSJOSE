package Test;

import java.util.List;

import DAO.TblProductoImp;
import Model.TblProductocl3;

public class TestProducto {

	public static void main(String[] args) {

		// REALIZAMOS LAS RESPECTIVAS INSTANCIAS
				TblProductocl3 producto = new TblProductocl3();
				TblProductoImp crud=new TblProductoImp();
				/*//insertamos datos
				producto.setNombrecl3("Lijadora de Pared");
				producto.setPrecioventacl3(925.9);
				producto.setPreciocompcl3(158.89);
				producto.setEstadocl3("nuevo");
				producto.setDescripcl3("Funciona a corriente");
			
				//invocamos el metodo registrar...
				crud.RegistrarProducto(producto);
				System.out.println("Registrado correctamente");
				*/
				
				List<TblProductocl3> listado=crud.ListarProducto();
				//aplicacos un bucle
				for(TblProductocl3 lis:listado){
					//imprimir por pantalla
					System.out.println("codigo "+ lis.getIdproductocl3()+"\n"+
					"nombre" + lis.getNombrecl3()+"\n"+
							"PV" + lis.getPrecioventacl3()+"\n"+
							"PC"+lis.getPreciocompcl3()+"\n"+
							"Estado: " + lis.getEstadocl3()+"\n"+
							"Desc: " + lis.getDescripcl3());
	}

}
}
