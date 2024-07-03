package Test;

import DAO.TblLogueoImp;
import Model.TblUsuariocl3;

public class TestLogueo {

	public static void main(String[] args) {
	
		 TblUsuariocl3 cliente = new TblUsuariocl3();
	        cliente.setUsuariocl3("josenina");
	        cliente.setPasswordcl3("230608");

	        TblLogueoImp logueoDao = new TblLogueoImp();

	        TblUsuariocl3 usuarioEncontrado = logueoDao.BuscarUsuario(cliente);

	        if (usuarioEncontrado != null) {
	            System.out.println("Usuario encontrado: " + usuarioEncontrado.getUsuariocl3());
	        } else {
	            System.out.println("Usuario no encontrado");
	        }
	}

}
