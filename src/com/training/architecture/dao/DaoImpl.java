package com.training.architecture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 

import com.training.architecture.logic.Person;

public class DaoImpl implements IDao {
	//private String url = "jdbc:mysql://localhost:3306/personDB?serverTimezone=UTC";
		private String url = "jdbc:mysql://localhost:3306/personDB?serverTimezone=UTC";
		private String login = "root";
		private String password = "";
		Person p = new Person();
		
		public boolean loadDriver() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("\nDriver loaded");
				return true;
			} catch (ClassNotFoundException ex) {
			    // handle any errors
			    System.out.println("Class not found : " + ex.getMessage());
			    return false;
			}
			
		}
		
		@Override
		public Connection connectDB () {
			// 1 . Check driver
			boolean isDriverPresent = loadDriver();
			Connection conn = null;
			// Check connection
			if (isDriverPresent) {
				try {
					conn = DriverManager.getConnection(url,login,password);
					System.out.println("Connection established");
				} 	catch (SQLException e) {
						e.printStackTrace();
				}
				
			}
			return conn;	
		}
		
		@Override
		public int addPerson(Person p) {
			try {
				Connection conn = connectDB();
				
				String sql = "INSERT INTO person(name,surname,age) VALUES(?,?,?)";
				PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, p.getName());
				st.setString(2, p.getSurname());
				st.setInt(3, p.getAge());
				
				st.executeUpdate();
				
				conn.close();
				System.out.println("Person added");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			return 0;
		}

	@Override
	public int removePerson(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Person getPerson(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> listAll() {
		// TODO Auto-generated method stub
		Connection conn = connectDB();
		List<Person> allPerson = new ArrayList<Person>();
		
		try {

			String sql = "SELECT * FROM person";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSurname(rs.getString("surname"));
				p.setAge(rs.getInt("age"));
				allPerson.add(p);
			}
			
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return allPerson;
	}

}
