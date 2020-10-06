package security.thymeleaf.ThymeleafSecurity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mails 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int ano;
	private String name;
	private String email;
	public Mails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mails(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public Mails(int ano, String name, String email) {
		super();
		this.ano = ano;
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Mails [ano=" + ano + ", name=" + name + ", email=" + email + "]";
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
