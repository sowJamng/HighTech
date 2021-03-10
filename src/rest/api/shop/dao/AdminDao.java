package rest.api.shop.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import rest.api.shop.model.Admin;


public class AdminDao {
    protected static AdminDao instance;
    protected Map< Integer,Admin> admins;
    
    private AdminDao() {
        admins=new HashMap<>();
        Admin a=new Admin();
        a.setId(1);
        a.setPrenom("Maodo"); a.setNom("nom"); a.setEmail("maodosowdev7@gmail.com"); a.setMdp("maodo7");
     
        admins.put(a.getId(),a);
        Admin admin=new Admin();
        admin.setId(2);
        admin.setPrenom("Ahlem"); admin.setNom("Fantazi"); admin.setEmail("ahlem@gmail.com"); admin.setMdp("4321");
        admins.put(admin.getId(),admin );
    }
    
    public static  AdminDao getInstance() {
        if(instance==null)
            instance=new AdminDao();
        return instance;
    }
    public List<Admin> getAllAdmins(){
    	return admins.values().stream().collect(Collectors.toList());
    }
    
    public Admin getAdminById(Integer id) {
        return admins.get(id);
    }
    
    public void addAdmin( Integer key, Admin admin) {
        this.admins.put(key, admin);
        
    }
    
    public void deleteAdmin( Integer id) {
            this.admins.remove(id);       
    }
    
    
    public void updateAdmin(Admin admin,Integer id) {
        Admin ad =new Admin();
        ad.setId(id);
            ad.setNom(admin.getNom());
            ad.setPrenom(admin.getPrenom());
            ad.setEmail(admin.getEmail());
            ad.setMdp(admin.getMdp());
           this.addAdmin(ad.getId(),ad);
    }
    
    public Function<Integer,Boolean> contenetAdmin=(id)-> admins.containsKey(id);
    
  
   public BiFunction<String ,String,Boolean> connexion=(email,password)-> 
    admins.values().stream().anyMatch(a->a.getEmail().equals(email) && a.getMdp().equals(password));
   
    

}
