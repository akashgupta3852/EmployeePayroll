package com.bridgelabz.employeepayroll;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollServiceTest {
	@Test
	public void given4EmployeesData_WhenWrittenToFile_ShouldMatchNumOfEmployeeEntries() {
		EmployeePayrollData[] employeesArray = { new EmployeePayrollData(1, "Akash Gupta", 50500.0),
				new EmployeePayrollData(2, "Diksha Gupta", 52000.0),
				new EmployeePayrollData(3, "Divyansh Kumar", 51000.0),
				new EmployeePayrollData(4, "Golu Jaiswal", 51900.0) };
		EmployeePayrollService empPayrollService = new EmployeePayrollService(Arrays.asList(employeesArray));
		empPayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		long entriesCount = empPayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(4, entriesCount);
	}

	@Test
	public void givenFileofEmployeesData_OnPrintingEmployeesData_ShouldMatchNumOfEmployeeCounts() {
		EmployeePayrollService empPayrollService = new EmployeePayrollService();
		long entriesCount = empPayrollService.printEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(4, entriesCount);
	}
}