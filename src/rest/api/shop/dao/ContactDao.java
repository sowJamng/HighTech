package rest.api.shop.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import rest.api.shop.model.Contact;


public class ContactDao {

	 protected static ContactDao instance;
	    protected Map< Integer,Contact> contacts;
	    
	    private ContactDao() {
	        contacts=new HashMap<>();
	        Contact c1=new Contact(1,"0108908789","b1@gmail.com","1 Ruele Fiebre Grigny 91350");

	        contacts.put(c1.getId(),c1 );
	    }
	    
	    public static  ContactDao getInstance() {
	        if(instance==null)
	            instance=new ContactDao();
	        return instance;
	    }
	    public List<Contact> getAllContacts(){
	    	return contacts.values().stream().collect(Collectors.toList());
	    }
	    
	    public Contact getContactById(Integer id) {
	        return contacts.get(id);
	    }
	    
	    public void addContact(Contact b) {
	    	Comparator<Contact> comparator = Comparator.comparing( Contact::getId );
	    	Integer id=contacts.values().stream().max(comparator).get().getId()+1;
	        this.contacts.put(id, b);
	        
	    }
	    
	    public void deleteContact( Integer id) {
	            this.contacts.remove(id);       
	    }
	    
	    
	    public void updateContact(Contact b,Integer id) {
	        Contact ad =new Contact();
	        ad.setId(id);
	            ad.setAdresse(b.getAdresse());
	            ad.setEmail(b.getEmail());
	            ad.setTel(b.getTel());
	           	            
	           this.addContact(ad);
	    }
	    
	    public Function<Integer,Boolean> contentContact=(id)-> contacts.containsKey(id);
	    

}
