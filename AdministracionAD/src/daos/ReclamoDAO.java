package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.PersonaEntity;
import entities.ReclamoEntity;
import exceptions.PersonaException;
import hibernate.HibernateUtil;
import modelo.Persona;
import modelo.Reclamo;

public class ReclamoDAO {

	private static ReclamoDAO instancia;
	
	private ReclamoDAO() { }
	
	public static ReclamoDAO getInstancia() {
		if(instancia==null)
			instancia = new ReclamoDAO();
		return instancia;
	}
	
	public List<Reclamo> getAll(){
		List<Reclamo> resultado = new ArrayList<Reclamo>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		List<ReclamoEntity> reclamos = s.createQuery("from ReclamoEntity").list();
		for(ReclamoEntity r : reclamos)
			resultado.add(toNegocio(r));
		s.getTransaction().commit();
		return resultado;
	}

	public Reclamo findByID(int id) {
		Reclamo resultado = null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		ReclamoEntity reclamo = (ReclamoEntity) s.createQuery("from ReclamoEntity r where r.id = ?").setInteger(0, id).uniqueResult();
		s.getTransaction().commit();
		if(reclamo != null) {
			resultado = toNegocio(reclamo);
			return resultado;
		}
		return resultado;
			
	}
	
	public void save(Reclamo reclamo){ 
		ReclamoEntity pe = this.toEntity(reclamo);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(pe);
		s.getTransaction().commit();
		reclamo.setIdentificador(pe.getIdentificador());
	}


	public void update(Reclamo reclamo) {
		ReclamoEntity pe = this.toEntity(reclamo);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(pe);
		s.getTransaction().commit();
	}
	
	Reclamo toNegocio(ReclamoEntity r) {
		Reclamo reclamo = null;
		if(r!=null) {
			reclamo = new Reclamo(r.getId());
		}
		return reclamo;
	}
	
	ReclamoEntity toEntity(Reclamo r) {
		return new ReclamoEntity(r.getId());
	}
}
