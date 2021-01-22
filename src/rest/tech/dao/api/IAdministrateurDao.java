package rest.tech.dao.api;

import rest.tech.model.impl.Administrateur;

public interface IAdministrateurDao {
	void addAdmin(Integer key,Administrateur admin );	
    Administrateur updateAddmin(Administrateur admin);
    void deleteAdmin(Integer  id); 
    Administrateur getAdmin(Integer id);
}
