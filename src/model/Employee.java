package model;

import java.sql.SQLException;

import dao.Dao;
import dao.DaoImplJDBC;
import main.Logable;

public class Employee extends Person implements Logable {
    private int employeeId;
    private String name;
    private DaoImplJDBC dao;
    private String password;
    
	public Employee(int numeroEmpleado, String password) {
		super(password);
		this.employeeId= numeroEmpleado;
		this.password = password;
	}
		
	@Override
	public boolean login(int user, String password) {
		/*if(user == USER && password.equals(PASSWORD)) {
			System.out.println("Login correcto");
			return true;
		}else {
			System.out.println("Login incorrecto");
			return false;
		}*/
		dao = new DaoImplJDBC();
		try {
			dao.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employee employee = dao.getEmployee(user, password);
		try {
			dao.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee != null;
		
	}
	
	
	
	
	
	//getters y setters
	
	public String getName() {
		return name;
	}
	
	public void seetName(String name) {
		this.name = name;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}

