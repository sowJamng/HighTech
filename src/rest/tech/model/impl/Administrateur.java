package rest.tech.model.impl;

import java.util.Set;

import rest.tech.model.api.Personne;

public class Administrateur extends Personne {
	protected static  Administrateur instance;
	private Set<Article> articles;
	private Administrateur() {
		// TODO Auto-generated constructor stub
		}		
	
	public static Administrateur getInstance() {
		if(instance==null)
			instance=new Administrateur();
		return instance;
		
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}
