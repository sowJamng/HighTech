package rest.tech.model.impl;

import java.util.Set;


public class Administrateur {
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
	private Integer id;
	private  String nom;
	private  String prenom;
	private  String email;
	private  String adress;
	private  String password;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean equals(Object o) {
        if(this==o)
        	return true;
		if(o.getClass()!=this.getClass())
			return false;
		if(o==null)
			return  false;
		Administrateur person= (Administrateur)o;
		if(!person.getNom().equals(this.getNom()))
			return false;
		else if(person.getNom()==null)
		{
			if(this.getNom()!=null)
				return false;
		}
		if(!person.getPrenom().equals(this.getPrenom()))
			return false;
		else if(person.getPrenom()==null)
		{
			if(this.getPrenom()!=null)
				return false;
		}
		if(!person.getAdress().equals(this.getAdress()))
			return false;
		else if(person.getAdress()==null)
		{
			if(this.getAdress()!=null)
				return false;
		}
		if(!person.getEmail().equals(this.getEmail()))
			return false;
		else if(person.getEmail()==null)
		{
			if(this.getEmail()!=null)
				return false;
		}
		if(!person.getPassword().equals(this.getPassword()))
				return false;
		else if(person.getPassword()==null)
			return false;
			
		return true;
		
	}
	@Override
	public String toString() {
		return this.getPrenom() +" "+this.getNom()+" "+ this.getAdress()+" "+this.getEmail();
	}
	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}
