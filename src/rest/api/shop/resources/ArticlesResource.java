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
import rest.api.shop.dao.ArticlesDao;
import rest.api.shop.model.Article;

@Path("/articles")
public class ArticlesResource {

	   @Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	    
	    @GET
	    @Produces({ MediaType.TEXT_XML,MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    public List<Article> getAllarticles() {
	      return ArticlesDao.getInstance().getAllArticles();
	    }
	    @Path("/{id}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Article getArticles(@PathParam("id") Integer id){
	        if(!ArticlesDao.getInstance().contentArticle.apply(id))
	        {        System.out.println(Response.status(Response.Status.NOT_FOUND).build());
	        return null;}
	        else{
	            Article a=ArticlesDao.getInstance().getArticleById(id);
	            System.out.println(Response.ok().entity(a).build());
	            return a;
	        }
	        
	    }

	    @DELETE
	    @Path("/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteArticles(@PathParam("id") Integer id){
	    	if(!ArticlesDao.getInstance().contentArticle.apply(id))
	        {      return Response.status(Response.Status.NOT_FOUND).build();
	        }
	        else{
	        	ArticlesDao.getInstance().deleteArticle(id);
	            return Response.ok().build();
	        }       
	    }
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Article addArticles(Article a) {
	    	Response.created(uriInfo.getAbsolutePath()).build();
	    	ArticlesDao.getInstance().addArticle(a);
	    	return a;
	    
	    }
	    @Path("/{id}")
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response updateArticle(Article a, @PathParam("id") Integer id){
	        if(!ArticlesDao.getInstance().contentArticle.apply(id)){
	            return Response.noContent().build();
	        }
	        else
	        {
	            ArticlesDao.getInstance().updateArticle(a,id);
	            return Response.created(uriInfo.getAbsolutePath()).build();
	        }
	    }
        
	    @Path("/categorie/{categorie}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Article> getArticleByCategorie( @PathParam("categorie") String categorie){
         return ArticlesDao.getInstance().getArticleByCategorie(categorie);
	        
	    }
	    @Path("/marque/{marque}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Article> getArticleByMarque( @PathParam("marque") String marque){
         return ArticlesDao.getInstance().getArticleByMarque(marque);
	        
	    }
	    
	    @GET
	    @Path("/search/{search}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Article> getArticleByQuery( @PathParam("search") String query){
         return ArticlesDao.getInstance().getArticleByQuery(query);
	        
	    }
	    

}
