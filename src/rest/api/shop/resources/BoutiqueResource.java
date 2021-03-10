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

import rest.api.shop.dao.BoutiqueDao;
import rest.api.shop.model.Boutique;

@Path("/boutiques")
public class BoutiqueResource {


	  @Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	    
	    @GET
	    @Produces({ MediaType.TEXT_XML,MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    public List<Boutique> getAllarticles() {
	      return BoutiqueDao.getInstance().getAllBoutiques();
	    }
	    @Path("/{id}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Boutique getBoutique(@PathParam("id") Integer id){
	        if(!BoutiqueDao.getInstance().contentBoutique.apply(id))
	        {        System.out.println(Response.status(Response.Status.NOT_FOUND).build());
	        return null;}
	        else{
	            Boutique a=BoutiqueDao.getInstance().getBoutiqueById(id);
	            System.out.println(Response.ok().entity(a).build());
	            return a;
	        }
	        
	    }

	    @DELETE
	    @Path("/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteBoutique(@PathParam("id") Integer id){
	    	if(!BoutiqueDao.getInstance().contentBoutique.apply(id))
	        {      return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        else{
	        	BoutiqueDao.getInstance().deleteBoutique(id);
	            return Response.ok().build();
	        }       
	    }
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Boutique addBoutique(Boutique a) {
	    	Response.created(uriInfo.getAbsolutePath()).build();
	    	BoutiqueDao.getInstance().addBoutique(a);
	    	return a;
	    
	    }
	    @Path("/{id}")
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response updateBoutique(Boutique a, @PathParam("id") Integer id){
	        if(!BoutiqueDao.getInstance().contentBoutique.apply(id)){
	            return Response.noContent().build();
	        }
	        else
	        {
	            BoutiqueDao.getInstance().updateBoutique(a,id);
	            return Response.created(uriInfo.getAbsolutePath()).build();
	        }
	    }
}
