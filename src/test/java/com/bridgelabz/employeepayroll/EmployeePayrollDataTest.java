package com.bridgelabz.employeepayroll;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollDataTest {
	@Test
	public void givenEmployeePayrollData_WhenAdded_ShouldPassTheDeatils() {
		EmployeePayrollData empPayrollData = new EmployeePayrollData(1, "Akash GUpta", 51000);
		boolean result = (empPayrollData.empId == 1) && (empPayrollData.empName.equals("Akash GUpta"))
				&& (empPayrollData.empSalary == 51000);
		Assert.assertTrue(result);
	}
}
