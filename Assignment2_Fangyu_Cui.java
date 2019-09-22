package Assignment2;

/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO
    	double sumSalaries = 0.0;
    	for(int i = 0; i < employees.length; i++) {
    		if(employees[i].getSalary() > 5000) {
    			sumSalaries = sumSalaries + employees[i].getSalary();
    		}
    	}
        return sumSalaries;
    }

    
    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        // @TODO
    	int i = employee.getId() % 3;
    	int j = employee.getId() % 5;
    	if(i == 0 && j!= 0) {
    		System.out.println("Fizz");
    	} else if(i != 0 && j == 0) {
    		System.out.println("Buzz");
    	} else if(i == 0 && j ==0) {
    		System.out.println("FizzBuzz");
    	}
    }

    
    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        // @TODO
    	double tax = 0.0;
    	double i = employee.getSalary();
    	if(i <= 2500) {
    		tax = i * 0.1;
    	} else if(i > 2500 && i <= 5000) {
    		tax = i * 0.25;
    	} else if(i > 5000) {
    		tax = i * 0.35;
    	}
        return tax;
    }
    
    
    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO
    	double temp1 = firstEmployee.getSalary();
    	double temp2 = secondEmployee.getSalary();
    	firstEmployee.setSalary(temp2);
    	secondEmployee.setSalary(temp1);
    }

    
    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
    	int num = 0;
    	for(int i = 0; i < employees.length; i++) {
    		if(employees[i].getAge() > 50) {
    			num = num + 1;
    		}
    	}
        return num;
    }

    
    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        // @TODO
    	String name = employee.getFirstName();
    	String reverseName = "";
    	for(int i = 0; i < name.length(); i++) {
    		reverseName = name.charAt(i) + reverseName;
    	}
    	employee.setFirstName(reverseName);
    }

    
    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        // @TODO
    	String name = employee.getFirstName();
    	String result = "false";
    	char[] firstName = name.toCharArray();
    	for(int i = 0; i < firstName.length; i++) {
    		if(Character.isDigit(firstName[i]) == true) {
    		result = "true";
    		break;
    		}
    	}
    	System.out.println(result);
    }

    
     /*
        Write a method to raise an employee's salary to three times of his/her original salary.
        Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
        DO NOT change the input in this method.
        Try to add a new method in Employee class: public void raiseSalary(double byPercent) 
        Call this new method.
     */
    public void tripleSalary(Employee employee) {
        // @TODO
    	employee.raiseSalary(3);
    }
    
    public void raiseSalary(double byPercent) {
    	double i = salary;
    	i = i * byPercent;
    	setSalary(i);
    }
    
    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        // @TODO
        for(int i = 0; i < employeesStr.length; i++) {
        	employees[i] = new Employee(0, null, 0, 0);
        	String[] datas = employeesStr[i].split(",");
        	int id = Integer.valueOf(datas[0]);
        	String firstName = datas[1];
        	int age = Integer.valueOf(datas[2]);
        	double salary = Double.valueOf(datas[3]);
        	employees[i].setId(id);
        	employees[i].setFirstName(firstName);
        	employees[i].setAge(age);
        	employees[i].setSalary(salary);		
        }
        return employees;
    }
}
