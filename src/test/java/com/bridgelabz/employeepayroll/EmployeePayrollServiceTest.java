package com.bridgelabz.employeepayroll;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeePayrollServiceTest {
	private static EmployeePayrollService empPayrollService;
	private static EmployeePayrollData[] employeesArray = { new EmployeePayrollData(1, "Akash Gupta", 50500.0),
			new EmployeePayrollData(2, "Diksha Gupta", 52000.0), new EmployeePayrollData(3, "Divyansh Kumar", 51000.0),
			new EmployeePayrollData(4, "Golu Jaiswal", 51900.0) };

	@BeforeClass
	public static void initalize() {
		empPayrollService = new EmployeePayrollService(Arrays.asList(employeesArray));
	}

	@Test
	public void given4EmployeesData_WhenWrittenToFile_ShouldMatchNumOfEmployeeEntries() {
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

	@Test
	public void given4EmployeesData_WhenWrittenToFile_ShouldShowNumOfEmployeeEntries() {
		empPayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		long entriesCount = empPayrollService.showEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(4, entriesCount);
	}

	@Test
	public void givenFileofEmployeesData_OnReadingEmployeesData_ShouldMatchNumOfEmployeeCounts() {
		EmployeePayrollService empPayrollService = new EmployeePayrollService();
		long entriesCount = empPayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO).size();
		Assert.assertEquals(4, entriesCount);
	}
}