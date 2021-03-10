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
import rest.api.shop.dao.SousCategorieDao;
import rest.api.shop.model.SousCategorie;

@Path("/sousCategories")
public class SousCategorieResource {


	   @Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	    
	    @GET
	    @Produces({ MediaType.TEXT_XML,MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    public List<SousCategorie> getAllsousCategories() {
	      return SousCategorieDao.getInstance().getAllSousCategories();
	    }
	    @Path("/{id}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public SousCategorie getSousCategorie(@PathParam("id") Integer id){
	        if(!SousCategorieDao.getInstance().contentSousCategorie.apply(id))
	        {        System.out.println(Response.status(Response.Status.NOT_FOUND).build());
	        return null;}
	        else{
	            SousCategorie a=SousCategorieDao.getInstance().getSousCategorieById(id);
	            System.out.println(Response.ok().entity(a).build());
	            return a;
	        }
	        
	    }

	    @DELETE
	    @Path("/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteSousCategorie(@PathParam("id") Integer id){
	    	if(!SousCategorieDao.getInstance().contentSousCategorie.apply(id))
	        {      return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        else{
	        	SousCategorieDao.getInstance().deleteSousCategorie(id);
	            return Response.ok().build();
	        }       
	    }
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public SousCategorie addSousCategorie(SousCategorie a) {
	    	Response.created(uriInfo.getAbsolutePath()).build();
	    	SousCategorieDao.getInstance().addSousCategorie(a);
	    	return a;
	    
	    }
	    @Path("/{id}")
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response updateSousCategorie(SousCategorie a, @PathParam("id") Integer id){
	        if(!SousCategorieDao.getInstance().contentSousCategorie.apply(id)){
	            return Response.noContent().build();
	        }
	        else
	        {
	            SousCategorieDao.getInstance().updateSousCategorie(a,id);
	            return Response.created(uriInfo.getAbsolutePath()).build();
	        }
	    }

}
