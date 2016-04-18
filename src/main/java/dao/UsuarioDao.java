package dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.HibernateUtil;

public class UsuarioDao {
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
	
	public boolean verificarUsuario(String username, String password) throws HibernateException {
		boolean verify = false;
		try {
			iniciaOperacion();
			Object v = session.createQuery("FROM Usuario u WHERE u.username='"+username+"' AND u.password='"+password+"' ").uniqueResult();
			
			if(v != null) {
				verify = true;
			}
			
		} finally {
			session.close();
		}

		return verify;
	}

}