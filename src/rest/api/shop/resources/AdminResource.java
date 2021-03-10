package rest.api.shop.resources;

import rest.api.shop.dao.AdminDao;
import rest.api.shop.model.Admin;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;


@Path("/admin")
public class AdminResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    @GET
    @Produces({ MediaType.TEXT_XML,MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Admin> getAlldmins() {
      return AdminDao.getInstance().getAllAdmins();
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Admin getAdmin(@PathParam("id") Integer id){
        if(!AdminDao.getInstance().contenetAdmin.apply(id))
        {        System.out.println(Response.status(Response.Status.NOT_FOUND).build());
        return null;}
        else{
            Admin admin=AdminDao.getInstance().getAdminById(id);
            System.out.println(Response.ok().entity(admin).build());
            return admin;
        }
        
    }
    @GET
    @Path("/login/{email}/{password}/")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean login(@PathParam("email") String email , @PathParam("password") String password ){
    	return AdminDao.getInstance().connexion.apply(email,password);
        //if(AdminDao.getInstance().connexion.apply(email,password)) {
        	//return Response.ok().build(); 
//        }
//        else
        	//return Response.status(Response.Status.NOT_FOUND).build();      	      	
        
    }
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAdmin(@PathParam("id") Integer id){
    	if(!AdminDao.getInstance().contenetAdmin.apply(id))
        {      return Response.status(Response.Status.NOT_FOUND).build();
        }
        else{
        	AdminDao.getInstance().deleteAdmin(id);
            return Response.ok().build();
        }       
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Admin addAdmin(Admin admin) {
    	Response.created(uriInfo.getAbsolutePath()).build();
    	AdminDao.getInstance().addAdmin(admin.getId(), admin);
    	return admin;
    
    }
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAdmin(Admin admin, @PathParam("id") Integer id){
        if(!AdminDao.getInstance().contenetAdmin.apply(id)){
            return Response.noContent().build();
        }
        else
        {
            AdminDao.getInstance().updateAdmin(admin,id);
            return Response.created(uriInfo.getAbsolutePath()).build();
        }
    }
  
}
