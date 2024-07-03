package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IntProducto;
import Model.TblProductocl3;

public class TblProductoImp implements IntProducto{

	// REGISTRAR
	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		EntityManagerFactory em=Persistence.createEntityManagerFactory("LPII_CL3_NINAOCROSJOSE");
		EntityManager emanager= em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(producto);
		System.out.println("Producto Registrado en la base de datos");
		emanager.getTransaction().commit();
		emanager.close();
	}

	// LISTAR
	@Override
	public List<TblProductocl3> ListarProducto() {
		EntityManagerFactory fab= Persistence.createEntityManagerFactory("LPII_CL3_NINAOCROSJOSE");
		EntityManager em= fab.createEntityManager();
		em.getTransaction().begin();
		List<TblProductocl3> listado=em.createQuery("select c from TblProductocl3 c", TblProductocl3.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listado;
	}

	// ACTUALIZAR
	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
        EntityManagerFactory fab = Persistence.createEntityManagerFactory("LPII_CL3_NINAOCROSJOSE");
        EntityManager em = fab.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
            System.out.println("Producto actualizado en la base de datos");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
	}

	// ELIMINAR
	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		EntityManagerFactory fab = Persistence.createEntityManagerFactory("LPII_CL3_NINAOCROSJOSE");
		EntityManager em = fab.createEntityManager();
		em.getTransaction().begin();
		TblProductocl3 eli = em.merge(producto);
		em.remove(eli);
		System.out.println("Producto eliminado de la base de datos");
		em.getTransaction().commit();
		em.close();
	}

	// BUSCAR
	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
		EntityManagerFactory fab = Persistence.createEntityManagerFactory("LPII_CL3_NINAOCROSJOSE");
		EntityManager em = fab.createEntityManager();
		em.getTransaction().begin();
		TblProductocl3 buscar = em.find(TblProductocl3.class, producto.getIdproductocl3());
		em.getTransaction().commit();
		em.close();
		return buscar;
	}
	
	
}
