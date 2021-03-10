package rest.api.shop.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import rest.api.shop.model.SousCategorie;
import rest.api.shop.model.Contact;

public class SousCategorieDao {


	 protected static SousCategorieDao instance;
	    protected Map< Integer,SousCategorie> scategories;
	    
	    private SousCategorieDao() {
	        scategories=new HashMap<>();
	        SousCategorie b=new SousCategorie();
	    	SousCategorie b1=new SousCategorie(1,"PC Burreau");
	        scategories.put(b1.getId(),b1 );
	    }
	    
	    public static  SousCategorieDao getInstance() {
	        if(instance==null)
	            instance=new SousCategorieDao();
	        return instance;
	    }
	    public List<SousCategorie> getAllSousCategories(){
	    	return scategories.values().stream().collect(Collectors.toList());
	    }
	    
	    public SousCategorie getSousCategorieById(Integer id) {
	        return scategories.get(id);
	    }
	    
	    public void addSousCategorie(SousCategorie b) {
	    	Comparator<SousCategorie> comparator = Comparator.comparing( SousCategorie::getId );
	    	Integer id=scategories.values().stream().max(comparator).get().getId()+1;
	        this.scategories.put(id, b);
	        
	    }
	    
	    public void deleteSousCategorie( Integer id) {
	            this.scategories.remove(id);       
	    }
	    
	    
	    public void updateSousCategorie(SousCategorie b,Integer id) {
	        SousCategorie ad =new SousCategorie();
	        ad.setId(id);
	           ad.setNom(b.getNom());
	           
	           this.addSousCategorie(ad);
	    }
	    
	    public Function<Integer,Boolean> contentSousCategorie=(id)-> scategories.containsKey(id);
	    

}
