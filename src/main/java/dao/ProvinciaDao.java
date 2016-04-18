package dao;

import java.util.List;

import datos.HibernateUtil;
import datos.Localidad;
import datos.Partido;
import datos.Provincia;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class	ProvinciaDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public Provincia traerProvincia(long idProvincia) throws HibernateException {
		Provincia provincia = null;

		try {
			iniciaOperacion();
			provincia = (Provincia) session.get(Provincia.class, idProvincia);
			
		} finally {

			session.close();
		}
		return provincia;
	}
	
	public int agregarProvincia(Provincia provincia) {
		int id = 0;
		try {

			iniciaOperacion();
			id = Integer.parseInt(session.save(provincia).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return id;
	}

	public void actualizarProvincia(Provincia provincia) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(provincia);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public List<Provincia> traerListaProvincias() throws HibernateException {
		List<Provincia> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Provincia r order by r.nombre asc").list();

		} finally {
			session.close();
		}

		return lista;
	}
	
}


