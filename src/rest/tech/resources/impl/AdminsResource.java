package rest.tech.resources.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import rest.tech.dao.impl.AdministrateurDao;
import rest.tech.model.impl.Administrateur;


@Path("/admins")
public class AdminsResource {
	 @Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	    protected static  AdminsResource instance;
	    
	    public static AdminsResource getInstance() {
			if(instance==null)
				instance=new AdminsResource();
			return instance;
		}
	    
	    public void setUriInfo(UriInfo url){
			  this.uriInfo=url;
		    	
		    }
	    
		 public void setRequest(Request request) {
			  this.request=request;
		  }
		  @GET
		    @Produces(MediaType.TEXT_XML)
		    public List<Administrateur> getAdminBrowser() {
		        List<Administrateur> admins = new ArrayList<Administrateur>();
		        admins.addAll(AdministrateurDao.getInstance().getAdmins().values());
		        return admins;
		    }

		    // Return the list of todos for applications
		    @GET
		    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		    public List<Administrateur> getTodos() {
		    	
		         List<Administrateur> admins = new ArrayList<Administrateur>();
		         admins.addAll(AdministrateurDao.getInstance().getAdmins().values());
		         return admins;
		    }
		    
		  @Path("{admin}")
		    public AdministrateurResource getTodo(@PathParam("admin") Integer id) {
		        AdministrateurResource adresource= AdministrateurResource.getInstance();
		        adresource.setRequest(request);
		        adresource.setUriInfo(uriInfo);
		        return adresource;
		    }
		  
	  private AdminsResource() {}
	     @POST
	     @Produces(MediaType.TEXT_HTML)
	     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    public void newAdmin(@FormParam("id") Integer id,
	            @FormParam("nom") String nom,
	            @FormParam("nom") String prenom,
	            @FormParam("adress") String adress,
	            @FormParam("email") String email,
	            @FormParam("password") String password,
	            @Context HttpServletResponse servletResponse) throws IOException {
	        Administrateur admin = Administrateur.getInstance();
	      admin.setNom(nom);
	      admin.setPrenom(prenom);
	      admin.setAdress(adress);
	      admin.setEmail(email);
	      admin.setId(id);
	      admin.setPassword(password);
	      AdministrateurDao.getInstance().addAdmin(admin.getId(), admin);
	      servletResponse.sendRedirect("../index.html");
	    }
}
