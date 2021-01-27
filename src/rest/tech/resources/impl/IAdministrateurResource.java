package rest.tech.resources.impl;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import rest.tech.model.impl.Administrateur;


public interface IAdministrateurResource {

	Administrateur getAdministrateur(String id);
	Administrateur getAdministrateurHtm(String id);
	void deleteAdministrateur(String id);
	Response putAndGetResponse(Administrateur admin);
	Response putAdmin(JAXBElement<Administrateur> admin);
	void addAministrateur(Administrateur admin);
}
