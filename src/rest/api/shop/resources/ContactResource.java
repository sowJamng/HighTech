package rest.api.shop.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import rest.api.shop.dao.ContactDao;
import rest.api.shop.model.Contact;

@Path("/contacts")
public class ContactResource {
	 @Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	    
	    @GET
	    @Produces({ MediaType.TEXT_XML,MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    public List<Contact> getAllcontacts() {
	      return ContactDao.getInstance().getAllContacts();
	    }
	    @Path("/{id}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Contact getContact(@PathParam("id") Integer id){
	        if(!ContactDao.getInstance().contentContact.apply(id))
	        {        System.out.println(Response.status(Response.Status.NOT_FOUND).build());
	        return null;}
	        else{
	           Contact a=ContactDao.getInstance().getContactById(id);
	            System.out.println(Response.ok().entity(a).build());
	            return a;
	        }
	        
	    }

	    @DELETE
	    @Path("/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteContact(@PathParam("id") Integer id){
	    	if(!ContactDao.getInstance().contentContact.apply(id))
	        {      return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        else{
	        	ContactDao.getInstance().deleteContact(id);
	            return Response.ok().build();
	        }       
	    }
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Contact addContact(Contact a) {
	    	Response.created(uriInfo.getAbsolutePath()).build();
	    	ContactDao.getInstance().addContact(a);
	    	return a;
	    
	    }
	    @Path("/{id}")
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response updateContact(Contact a, @PathParam("id") Integer id){
	        if(!ContactDao.getInstance().contentContact.apply(id)){
	            return Response.noContent().build();
	        }
	        else
	        {
	           ContactDao.getInstance().updateContact(a,id);
	            return Response.created(uriInfo.getAbsolutePath()).build();
	        }
	    }

}
