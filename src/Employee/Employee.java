package Employee;

public class Employee {
	private String name;
	private int employeeNum;

	public Employee(String name, int employeeNum) {
		super();
		this.name = name;
		this.employeeNum = employeeNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}

}
