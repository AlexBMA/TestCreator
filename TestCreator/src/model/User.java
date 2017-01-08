package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@Column(name = "id", updatable = false, nullable = false)
		private int id;
		
		@Column(name="user_name")
		private String userName;
		@Column(name="pass")
		private String pass;
		@Column(name="role")
		private String role;
		
		public User()
		{
			
		}		
		
		public User(String userName, String pass, String role) {
			super();
			this.userName = userName;
			this.pass = pass;
			this.role = role;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
}
