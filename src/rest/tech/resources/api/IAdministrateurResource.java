package rest.tech.resources.api;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import rest.tech.model.impl.Administrateur;


public interface IAdministrateurResource {

	Administrateur getAdministrateur(Integer id);
	Administrateur getAdministrateurHtm(Integer id);
	void deleteAdministrateur(Integer id);
	Response putAndGetResponse(Administrateur admin);
	Response putAdmin(JAXBElement<Administrateur> admin);
	void addAministrateur(Administrateur admin);
}
