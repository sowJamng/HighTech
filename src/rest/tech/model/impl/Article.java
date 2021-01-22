package rest.tech.model.impl;

public class Article {
protected static Article instance;
private Integer id;
private String libelle;
private String marque;
private Integer prix;
private Categorie categorie;
private Boutique boutique ;
private Article() {}

public static Article getInstance() {
	if(instance==null)
		instance=new Article();
	return instance;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}

public String getMarque() {
	return marque;
}

public void setMarque(String marque) {
	this.marque = marque;
}

public Categorie getCategorie() {
	return categorie;
}

public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}

public Integer getPrix() {
	return prix;
}

public void setPrix(Integer prix) {
	this.prix = prix;
}

@Override
public boolean equals(Object o) {
	if(this==o)
		return true;
	if(o.getClass()!=this.getClass())
		return false;
	if(o==null)
		return false;
	Article a=(Article)o;
	if(this.getId()!=a.getId())
		return false;
	if(!this.getLibelle().equals(a.getLibelle()))
		return false;
	else if(this.libelle==null) {
		if(a.getLibelle()!=null)
			return false;
	}
	if(!this.getCategorie().equals(a.getCategorie()))
		return false;
	else if(this.getCategorie()==null)
	{
		if(a.getCategorie()!=null)
			return false;
	}
	if(!this.getMarque().equals(a.getMarque()))
		return false;
	else if(this.getMarque()==null) {
	  if(a.getMarque()!=null)
		  return false;
	}
	return true;
	
}

public Boutique getBoutique() {
	return boutique;
}

public void setBoutique(Boutique boutique) {
	this.boutique = boutique;
}

}
