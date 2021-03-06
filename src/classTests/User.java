package classTests;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String firstName;
	private String lastName;
	@Id
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}