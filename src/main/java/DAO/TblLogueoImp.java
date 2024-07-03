package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import Interfaces.IntLogueo;
import Model.TblUsuariocl3;

public class TblLogueoImp implements IntLogueo{

	@Override
	public TblUsuariocl3 BuscarUsuario(TblUsuariocl3 cliente) {
		 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_NINAOCROSJOSE");
	    EntityManager em = emf.createEntityManager();
	        
	    TblUsuariocl3 bususuario = null;
	        try {
	            em.getTransaction().begin();
	            bususuario = em.createQuery(
	                "SELECT u FROM TblUsuariocl3 u WHERE u.usuariocl3 = :nombreUsuario", 
	                Model.TblUsuariocl3.class).setParameter("nombreUsuario", cliente.getUsuariocl3()).getSingleResult();
	            em.getTransaction().commit();
	            if (bususuario != null && bususuario.getPasswordcl3().equals(cliente.getPasswordcl3())) {
	                return bususuario;
	            }
	        } catch (NoResultException e) {
	    
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            em.close();
	        }
	        return null;
	    }
}
