package rest.api.shop.model;

public class Marque {
	
	public Integer id;
	public String nom;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marque other = (Marque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	public Marque(Integer id, String nom) {
		this.id=id;
		this.nom=nom;
	}
	public Marque() {
		
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	
//	APPLE, DELL, ASUS, LENOVO, MICROSOFT
}

