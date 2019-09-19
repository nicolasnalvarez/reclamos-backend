package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import views.ReclamoView;

@Entity
@Table(name="reclamos")
public class ReclamoEntity {

	@Id
	private int id;
	
	public ReclamoEntity() { }
	
	public ReclamoEntity(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}


}
