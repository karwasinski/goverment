package db.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Zip_codes {
	@Id
	private int id;
	private String zip_code;
	public int getId() {
		return id;
	}
	public void setId(int userId) {
		this.id = userId;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String userName) {
		this.zip_code = userName;
	}
}
