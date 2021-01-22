package rest.tech.model.impl;

import java.util.Set;

public class Boutique {

	protected  static Boutique instance;
	private Integer d;
	private String description ;
	private String contact;
	Set<Article> articles;
	private Boutique() {}
	public static Boutique getInstance() {
		if(instance==null)
			instance=new Boutique();
		return instance;
	}
	public Integer getD() {
		return d;
	}
	public void setD(Integer d) {
		this.d = d;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
  @Override
  public boolean equals(Object o) {
	  if(o==null)
		  return false;
	  if(this==o)
		  return true;
	  Boutique b=(Boutique)o;
	  if(!this.getDescription().equals(b.getDescription()))
		  return false;
	  else if(this.getContact()==null) {
		  if(b.getContact()!=null)
			  return false;
	  }
		  
	  if(!this.getContact().equals(b.getContact()))
	     return true;
	  else if(this.getContact()==null) {
		  if(b.getContact()!=null)
			  return false;
	  }
	  return true;
	  
  }
}
