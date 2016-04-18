package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.HibernateUtil;
import datos.Institucion;
import datos.Localidad;
import datos.Partido;
import datos.TipoInst;

public class LocalidadDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	public Localidad traerLocalidad(long idLocalidad) throws HibernateException {
		Localidad localidad = null;

		try {
			iniciaOperacion();
			localidad = (Localidad) session.get(Localidad.class, idLocalidad);
			
		} finally {

			session.close();
		}
		return localidad;
	}
	

	public List<Localidad> traerListaLocalidades() throws HibernateException {
		List<Localidad> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("FROM Localidad l inner join fetch l.partido").list();

		} finally {
			session.close();
		}

		return lista;
	}
}