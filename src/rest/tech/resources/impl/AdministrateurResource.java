package rest.tech.resources.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.ws.rs.core.Response;
import rest.tech.dao.impl.AdministrateurDao;
import rest.tech.model.impl.Administrateur;



public class AdministrateurResource implements IAdministrateurResource{
	    protected  AdministrateurDao adminDao=AdministrateurDao.getInstance();
	    @Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	   
	    protected static  AdministrateurResource instance;
		private AdministrateurResource() {}
		
	  public void setUriInfo(UriInfo url){
		  this.uriInfo=url;
	    	
	    }
	  public void setRequest(Request request) {
		  this.request=request;
	  }
	  
	
	public static AdministrateurResource getInstance() {
		if(instance==null)
			instance=new AdministrateurResource();
		return instance;
	}

	@Override
	@GET
	 @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Administrateur getAdministrateur(String id) {
		 Administrateur admin = adminDao.getAdmins().get(id);
	        if(admin==null)
	            throw new RuntimeException("Get: Todo with " + id +  " not found");
	        return admin;
	}

	@Override
	@GET
    @Produces(MediaType.TEXT_XML)
	public Administrateur getAdministrateurHtm(String id) {
		 Administrateur admin = adminDao.getAdmins().get(id);
	        if(admin==null)
	            throw new RuntimeException("Get: Todo with " + id +  " not found");
	        return admin;
	}
	@Override
	public Response putAndGetResponse(Administrateur admin) {
		 Response res;
	        if(adminDao.getAdmins().containsKey(admin.getId())) {
	            res = Response.noContent().build();
	        } else {
	            res = Response.created(this.uriInfo.getAbsolutePath()).build();
	        }
	        adminDao.addAdmin(admin.getId(), admin);
	        return  res;
	}
	
	@Override
	@PUT
    @Consumes(MediaType.APPLICATION_XML)
	public Response putAdmin(JAXBElement<Administrateur> admin) {
		Administrateur a =admin.getValue();
		return putAndGetResponse(a);
	}

	@Override
	@DELETE
	public void deleteAdministrateur(String id) {
		adminDao.deleteAdmin(id);
		
	}
	@Override
	@POST
	public void addAministrateur(Administrateur admin) {
		adminDao.addAdmin(admin.getId(), admin);		
	}

}
