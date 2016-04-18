package dao;

import java.util.List;

import datos.HibernateUtil;
import datos.Localidad;
import datos.Partido;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class	PartidoDao {
	
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
	
	public Partido traerPartido(long idPartido) throws HibernateException {
		Partido partido = null;

		try {
			iniciaOperacion();
			partido = (Partido) session.get(Partido.class, idPartido);
			
		} finally {

			session.close();
		}
		return partido;
	}
	
	public int agregarPartido(Partido partido) {
		int id = 0;
		try {

			iniciaOperacion();
			id = Integer.parseInt(session.save(partido).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return id;
	}

	public void actualizarPartido(Partido partido) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(partido);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public List<Partido> traerListaPartidos() throws HibernateException {
		List<Partido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Partido r inner join fetch r.provincia order by r.nombre asc").list();

		} finally {
			session.close();
		}

		return lista;
	}
	
}

