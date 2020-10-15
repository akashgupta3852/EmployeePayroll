package com.bridgelabz.employeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePayrollFileIOService {
	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String empDataString = employee.toString().concat("\n");
			empBuffer.append(empDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public long countEntries() {
		long numOfEntries = 0;
		try {
			numOfEntries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return numOfEntries;
	}

	public long printData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(lines -> System.out.println(lines));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return countEntries();
	}

	public List<String> readData() {
		 List<String> listOfEmpsData = new ArrayList<String>();
		try {
			listOfEmpsData = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).map(line -> line.toString()).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return listOfEmpsData;
	}
}