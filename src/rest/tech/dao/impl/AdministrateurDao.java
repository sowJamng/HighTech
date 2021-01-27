package rest.tech.dao.impl;

import java.util.Map;

import rest.tech.dao.api.IAdministrateurDao;
import rest.tech.model.impl.Administrateur;

public class AdministrateurDao implements IAdministrateurDao {
    protected static AdministrateurDao instance;
	protected Map<String,Administrateur> admins;
	
private AdministrateurDao() {
	Administrateur a=Administrateur.getInstance();
	a.setId("1");
	a.setPrenom("Maodo"); a.setNom("nom"); a.setEmail("maodo@gmail.com"); a.setPassword("1234");
	a.setAdress("92000 Nanterre");
	admins.put("1",a);
}

	public static  AdministrateurDao getInstance() {
		if(instance==null)
			instance=new AdministrateurDao();
		return instance;
	}
	@Override
	public Administrateur getAdmin(String id) {
		return admins.get(id);
	}
	@Override
	public void addAdmin(String key, Administrateur admin) {
		this.admins.put(key, admin);
		
	}

	@Override
	public void deleteAdmin(String id) {
		if(admins.containsKey(id))
			this.admins.remove(id);
		else
			System.out.println("Suppresion impossible ,l'administateur specifié n'existe pas");
		
	}

	@Override
	public Administrateur updateAddmin(Administrateur admin) {
		Administrateur ad =Administrateur.getInstance();
		if(admins.containsKey((admin.getId()))) {
		   ad.setNom(admin.getNom());
		   ad.setPrenom(admin.getPrenom());
		   ad.setEmail(admin.getEmail());
		   ad.setPassword(admin.getPassword());
		   ad.setAdress(admin.getAdress());
		   ad.setArticles(admin.getArticles());
		   return ad;
		}
		else
			{System.out.println("Modification impossible");
			return null;
			}
		
	}
	public Map<String,Administrateur> getAdmins(){
		return this.admins;
	}

	
}
