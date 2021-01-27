package rest.tech.dao.api;

import rest.tech.model.impl.Administrateur;

public interface IAdministrateurDao {
	void addAdmin(String key,Administrateur admin );	
    Administrateur updateAddmin(Administrateur admin);
    void deleteAdmin(String  id); 
    Administrateur getAdmin(String id);
}
