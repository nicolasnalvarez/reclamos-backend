package modelo;

import daos.ReclamoDAO;
import views.ReclamoView;

public class Reclamo {

	private int id;
	
	public Reclamo(int id) {
		this.id = id;
	}
	
	public void save(){
		ReclamoDAO.getInstancia().save(this);
	}
	
	public void update(){
		ReclamoDAO.getInstancia().update(this);
	}

	public int getId() {
		return id;
		}

	public ReclamoView toView() {
		return new ReclamoView(id);
	}



	public void delete() {
		
	}	
}