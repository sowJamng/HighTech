package rest.api.shop.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import rest.api.shop.model.Article;
import rest.api.shop.model.Boutique;
import rest.api.shop.model.Categorie;
import rest.api.shop.model.Contact;
import rest.api.shop.model.Marque;
import rest.api.shop.model.SousCategorie;

public class ArticlesDao {
	 protected static ArticlesDao instance;
	    protected Map< Integer,Article> articles;
	    
	    private ArticlesDao() {
	    	
	    	Boutique b1=new Boutique(1,"b1 service IPG ","01678790","b1@gmail.com","1 Rue de lilette 77500 Chelles");
	    	SousCategorie sousC1=new SousCategorie(1,"PC Portable");
	    	SousCategorie sousC2=new SousCategorie(1,"PC Burreau");
	  Article a1=new Article();
	  
	  a1.setId(1); a1.setBoutique(b1); a1.setCategorie(sousC1);a1.setLibelle("Ram 16GB disque 500Gb fr:2.5");
	  a1.setQuantity(3);
	  Marque m1=new Marque(1,"DELL");
	  Marque m2= new Marque(2,"ASUS");
	  a1.setPrix(500.0); a1.setPhoto("potho1"); a1.setMarque(m1);
	  a1.setDescription("description article");
	  Article a2= new Article();
	  a2.setDescription("description aartcile");
	  a2.setId(2); a2.setBoutique(b1); a2.setLibelle("Ram 8GB disque 500Gb fr:2.5");
	  a2.setPhoto("photo2"); a2.setMarque(m2);
	  a2.setCategorie(sousC2);
	  a2.setQuantity(4);
	  articles=new HashMap<>();
	    	  articles.put(a1.getId(),a1);
	    	  articles.put(a2.getId(),a2);
	    }
	    
	    public static  ArticlesDao getInstance() { 
	        if(instance==null)
	            instance=new ArticlesDao();
	        return instance;
	    }
	    public List<Article> getAllArticles(){
	    	return articles.values().stream().collect(Collectors.toList());
	    }
	    
	    public Article getArticleById(Integer id) {
	        return articles.get(id);
	    }
	    
	    public void addArticle(Article article) {
	    	Comparator<Article> comparator = Comparator.comparing( Article::getId );
	    	Integer id=articles.values().stream().max(comparator).get().getId()+1;
	    	article.setId(id);
	        this.articles.put(id, article);
	        
	    }
	    
	    public void deleteArticle( Integer id) {
	            this.articles.remove(id);       
	    }
	    
	    public Function<Integer,Boolean> contentArticle=(id)-> articles.containsKey(id);
	    
	    public void updateArticle(Article article,Integer id) {
	        Article ad =new Article();
	        ad.setId(id);
	           ad.setBoutique(article.getBoutique());
	           ad.setCategorie(article.getCategorie());
	           ad.setLibelle(article.getLibelle());
	           ad.setPhoto(article.getPhoto());
	           ad.setPrix(article.getPrix());
	         
	           this.addArticle(ad);
	    }
	    
	    public List<Article> getArticleByMarque(String marque){
	    	return this.articles.values().stream().filter(article ->article.getMarque().getNom().toLowerCase().contains(marque)).collect(Collectors.toList());
	    	
	    }
	    public List<Article> getArticleByCategorie(String categorie){
	    	return this.articles.values().stream().filter(article ->article.getCategorie().getNom().toLowerCase().contains(categorie)).collect(Collectors.toList());
	    	
	    }

	    public List<Article> getArticleByQuery(String query){
	    	return this.articles.values().stream().filter(article ->article.getLibelle().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList());
	    	
	    }

}
