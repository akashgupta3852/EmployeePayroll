package com.bridgelabz.employeepayroll;

public class EmployeePayrollData {
	public int empId;
	public String empName;
	public double empSalary;

	public EmployeePayrollData(int id, String name, double salary) {
		this.empId = id;
		this.empName = name;
		this.empSalary = salary;
	}

	public String toString() {
		return "id= " + empId + ", name: " + empName + ", salary: " + empSalary;
	}
}
