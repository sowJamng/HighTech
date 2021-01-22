package rest.tech.model.impl;

import java.util.Set;

public class Categorie {

	protected static Categorie instance;
	private Integer id;
	private String nom;
	private Set<Article> articles;
	
	private Categorie() {
		// TODO Auto-generated constructor stub
	}
  public static Categorie getInstance() {
	  if(instance==null)
		  instance=new Categorie();
	  return instance;
	  }
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Override 
public boolean equals(Object o) {
	if(this==o)
		return true;
	if(o==null)
		return false;
	if(o.getClass()!=this.getClass())
			return false;
	Categorie c=(Categorie)o;
	
	if(this.getId()!=(c.getId()))
		return false;
	if(this.getNom()!=c.getNom())
		return false;
	else if(this.getNom()==null)
	{
		if(c.getNom()!=null)
			return false;
	}
	return true;
}
@Override
public String toString() {
	return this.getNom();
}
public Set<Article> getArticles() {
	return articles;
}
public void setArticles(Set<Article> articles) {
	this.articles = articles;
}

  }
