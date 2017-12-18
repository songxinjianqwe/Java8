package cn.sinjinsong.java8.domain;

public class Employee {
	private String name;
	private int age;
	private double salary;
	private Status status;
	
	
	public Employee(String name, int age, double salary, Status status) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", status=" + status + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
}
