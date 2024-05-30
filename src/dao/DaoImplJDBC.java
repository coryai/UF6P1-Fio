package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;


public class DaoImplJDBC implements Dao {
  private Connection connection;
  
  
  public void connect() throws SQLException {
	  try {
		  String url = "jdbc:mysql://localhost:3306/shop";
		  String user = "root";
		  String pass = "root";
		  this.connection= DriverManager.getConnection(url, user, pass);
	  }catch(SQLException e){
		  e.printStackTrace();
	  }
	 }
  
  
  public Employee getEmployee(int employeeId, String password) {
	  Employee employee = null;
	  try {
		  String query = "select * from employee where employeeId = ? and password = ?";
		  PreparedStatement ps = connection.prepareStatement(query);
		  ps.setInt(1, employeeId);
		  ps.setString(2, password);
		  ResultSet rs = ps.executeQuery();
		  	if(rs.next()) {
		  		employee = new Employee(employeeId, password);
				}
	  }catch(SQLException e){
		  e.printStackTrace();
	  }
	return employee;
  }
  
  
  
  public void disconnect() throws SQLException {
		  if(connection != null) {
			  connection.close();
		  }
  }
  
}
