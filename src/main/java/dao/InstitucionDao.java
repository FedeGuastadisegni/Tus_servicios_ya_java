package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.HibernateUtil;
import datos.Institucion;

public class InstitucionDao {

	private static Session session;
	private Transaction tx;

	public void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregarInstitucion(Institucion inst) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(inst).toString());
			tx.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return id;
	}
	
	
	public void modificarInstitucion(Institucion institucion) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(institucion);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	
	public void eliminarInstitucion(Institucion institucion) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(institucion);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	
	public List<Institucion> traerInstituciones() {
		List<Institucion> lista = null;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst order by i.idInstitucion desc")
					.list();

		} finally {
			session.close();
		}

		return lista;
	}
	
	public List<Institucion> traerInstitucionesFiltradas(long idLocalidad, long idTipoInst)throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session.createQuery("FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.localidad.idLocalidad="+idLocalidad+" AND i.tipoInst.idTipoInst ="+idTipoInst).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Institucion traerInstitucion(long idInstitucion)
			throws HibernateException {
		Institucion institucion = null;
		try {
			iniciaOperacion();
			institucion = (Institucion) session
					.createQuery(
							"From Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.idInstitucion = "
									+ idInstitucion).uniqueResult();

		} finally {
			session.close();
		}
		return institucion;
	}

	public List<Institucion> traerInstitucionesLocalidad(String nombre)
			throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.localidad.nombre like '"
									+ nombre + "'").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesLocalidad(long idLocalidad)
			throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.localidad.idLocalidad = "
									+ idLocalidad).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesTipo(String tipo)
			throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.tipoInst.tipo like '"
									+ tipo + "'").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesTipo(long idTipoInst)
			throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.tipoInst.idTipoInst = "
									+ idTipoInst).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesTipoLoc(String tipo,
			String nombre) throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.tipoInst.tipo like '"
									+ tipo
									+ "' AND i.localidad.nombre like '"
									+ nombre + "'").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesXNombre(String nombre)
			throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.nombre like '"
									+ nombre + "'").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesXTelefono(String nombre)
			throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.telefono like '"
									+ nombre + "'").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesXDireccion(String direccion)
			throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.direccion like '"
									+ direccion + "'").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesXCoordenadas(float x, float y)
			throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session
					.createQuery(
							"FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.coordenadasx = "
									+ x + " AND i.coordenadasy = " + y).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Institucion> traerInstitucionesUbicacion(float arriba, float abajo,float derecha,float izquierda,long idTipo)throws Exception {
		List<Institucion> lista = new ArrayList<Institucion>();
		try {
			iniciaOperacion();
			
			if(idTipo==0){
				lista = session.createQuery("FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.coordenadasx BETWEEN :arriba AND :abajo AND i.coordenadasy BETWEEN :derecha AND :izquierda")
						.setParameter("arriba", arriba)
						.setParameter("abajo", abajo)
						.setParameter("derecha", derecha)
						.setParameter("izquierda", izquierda)
						.list();
			}else if(idTipo == 1){
				lista = session.createQuery("FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where (i.coordenadasx BETWEEN :arriba AND :abajo AND i.coordenadasy BETWEEN :derecha AND :izquierda) AND  (i.tipoInst.idTipoInst = "+1+" OR i.tipoInst.idTipoInst ="+2+" OR i.tipoInst.idTipoInst ="+3+" OR i.tipoInst.idTipoInst ="+4+")")
						.setParameter("arriba", arriba)
						.setParameter("abajo", abajo)
						.setParameter("derecha", derecha)
						.setParameter("izquierda", izquierda)
						.list();
			}else if(idTipo == 5){
				lista = session.createQuery("FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.coordenadasx BETWEEN :arriba AND :abajo AND i.coordenadasy BETWEEN :derecha AND :izquierda AND i.tipoInst.idTipoInst = :idTipo")
						.setParameter("arriba", arriba)
						.setParameter("abajo", abajo)
						.setParameter("derecha", derecha)
						.setParameter("izquierda", izquierda)
						.setParameter("idTipo", idTipo)
						.list();
			}
		else if(idTipo == 6){
			lista = session.createQuery("FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.coordenadasx BETWEEN :arriba AND :abajo AND i.coordenadasy BETWEEN :derecha AND :izquierda AND i.tipoInst.idTipoInst = :idTipo")
					.setParameter("arriba", arriba)
					.setParameter("abajo", abajo)
					.setParameter("derecha", derecha)
					.setParameter("izquierda", izquierda)
					.setParameter("idTipo", idTipo)
					.list();
		}
		} finally {
			session.close();
		}
		return lista;
	}
	
	
	
	public List<Institucion> traerInstitucionesFiltradasTodas(long idPartido)throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session.createQuery("FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.localidad.partido.idPartido="+idPartido).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Institucion> traerInstitucionesFiltradasTodasTipo(long idLocalidad)throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session.createQuery("FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.localidad.idLocalidad="+idLocalidad).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Institucion> traerInstitucionesFiltradasTodasLocalidad(long idPartido, long idTipoInst)throws Exception {
		List<Institucion> lista;
		try {
			iniciaOperacion();
			lista = session.createQuery("FROM Institucion i inner join fetch i.localidad inner join fetch i.tipoInst where i.localidad.partido.idPartido="+idPartido+"AND i.tipoInst.idTipoInst ="+idTipoInst).list();
		} finally {
			session.close();
		}
		return lista;
	}

}