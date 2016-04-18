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

public class TipoInstDao {
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

	public List<TipoInst> traerListaTipoInst() throws HibernateException {
		List<TipoInst> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("FROM TipoInst").list();

		} finally {
			session.close();
		}

		return lista;
	}
	
	public TipoInst traerTipo(long idTipoInst) throws HibernateException {
		TipoInst tipoInst = null;

		try {
			iniciaOperacion();
			tipoInst = (TipoInst) session.get(TipoInst.class, idTipoInst);
			
		} finally {

			session.close();
		}
		return tipoInst;
	}
}
