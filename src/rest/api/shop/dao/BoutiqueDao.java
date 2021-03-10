package rest.api.shop.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import rest.api.shop.model.Boutique;


public class BoutiqueDao {

	 protected static BoutiqueDao instance;
	    protected Map< Integer,Boutique> boutiques;
	    
	    private BoutiqueDao() {
	        boutiques=new HashMap<>();
	        Boutique b=new Boutique(1,"b2 service IPG ","01678789","b2@gmail.com","1 Rue le Febvre Grigny 91350");
	        Boutique b1=new Boutique(1,"b1 service IPG ","01678790","b1@gmail.com","1 Rue de lilette 77500 Chelles");
	        boutiques.put(b1.getId(),b1 );
	    }
	    
	    public static  BoutiqueDao getInstance() {
	        if(instance==null)
	            instance=new BoutiqueDao();
	        return instance;
	    }
	    public List<Boutique> getAllBoutiques(){
	    	return boutiques.values().stream().collect(Collectors.toList());
	    }
	    
	    public Boutique getBoutiqueById(Integer id) {
	        return boutiques.get(id);
	    }
	    
	    public void addBoutique(Boutique b) {
	    	Comparator<Boutique> comparator = Comparator.comparing( Boutique::getId );
	    	Integer id=boutiques.values().stream().max(comparator).get().getId()+1;
	        this.boutiques.put(id, b);
	        
	    }
	    
	    public void deleteBoutique( Integer id) {
	            this.boutiques.remove(id);       
	    }
	    
	    
	    public void updateBoutique(Boutique b,Integer id) {
	        Boutique ad =new Boutique();
	        ad.setId(id);
	            ad.setAdress(b.getAdress());
	            ad.setEmail(b.getEmail());
	            ad.setPhone(b.getPhone());
	            ad.setDesc(b.getDesc());	            
	           this.addBoutique(ad);
	    }
	    
	    public Function<Integer,Boolean> contentBoutique=(id)-> boutiques.containsKey(id);
	    

}
