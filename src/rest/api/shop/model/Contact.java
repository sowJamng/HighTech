package rest.api.shop.model;

public class Contact {
	private Integer id;
	private String tel;
	private String email;
	private String adresse;

	public Contact() {
	}
	public Contact(Integer id,String tel,String email,String adress) {
		this.adresse=adress;
		this.email=email;
		this.id=id;
		this.tel=tel;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
