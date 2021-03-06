package com.employee.details;

import java.util.ArrayList;
import java.util.*;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private List<EmployeePayrollData> empList;

	public EmployeePayrollService() {
	}

	public EmployeePayrollService(List<EmployeePayrollData> empList) {
		this.empList = empList;
	}

	private void readEmployeePayrollData(Scanner s) {
		System.out.println("Enter ID");
		int id = s.nextInt();
		System.out.println("Enter Name");
		String name = s.next();
		System.out.println("Enter salary");
		Double salary = s.nextDouble();
		empList.add(new EmployeePayrollData(id, name, salary));
	}

	void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting Payroll to Console\n" + empList);
		else if (ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(empList);

	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> empList = new ArrayList<>();
		EmployeePayrollService empService = new EmployeePayrollService(empList);
		Scanner consoleInputReader = new Scanner(System.in);
		empService.readEmployeePayrollData(consoleInputReader);
		empService.writeEmployeePayrollData(IOService.CONSOLE_IO);

	}

	public long countEntries(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		return 0;
	}

	public void printData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().printData();
	}

	public void readEmployeePayrollData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO)) {
			Scanner consoleInputReader = new Scanner(System.in);
			System.out.print("Enter Employee ID: ");
			int id = consoleInputReader.nextInt();
			System.out.print("Enter Employee Name: ");
			String name = consoleInputReader.next();
			System.out.print("Enter Employee Salary: ");
			double salary = consoleInputReader.nextDouble();
			consoleInputReader.close();
			empList.add(new EmployeePayrollData(id, name, salary));
		} else if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().readData();
		}
	}

}
