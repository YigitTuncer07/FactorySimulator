import java.util.Arrays;

public class Factory {

    private String name;
    private Employee[] employees;
    private Storage storage;
    private Payroll[] payrolls;
    private double itemPrice;

    public Factory(String name, int capacity, double itemPrice) {
    	Storage storage = new Storage(capacity);
    	
    	this.storage = storage;
        this.name = name;
        this.itemPrice = itemPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setPayrolls(Payroll[] payrolls) {
        this.payrolls = payrolls;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getName() {
        return name;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Storage getStorage() {
        return storage;
    }

    public Payroll[] getPayrolls() {
        return payrolls;
    }

    public double getItemPrice() {
        return itemPrice;
    }
    public double getRevenue(){
        Item[] arr = storage.getItems();
        if (arr == null) {
        	return 0;
        } else {
        	double revenue = arr.length * itemPrice;
            return revenue;
        }
    }
    public double getPaidSalaries(){
    	double totalSalaries = 0;
    	for (int i = 0; i < employees.length; i++) {
    		totalSalaries = totalSalaries + employees[i].getPayroll().calculateSalary();
    	}
    	return totalSalaries;
    }
    public void removeEmployee(int id) {
    	if (employees == null) {
    		System.out.println("There are no employees!");
    	} else if (!checkForEmployee(id)) {
    		System.out.println("Employee does not exist!");
    	} else if (employees.length == 1) {
    		employees = null;
    	} else {
//    		Employee[] placeholder = new Employee[employees.length - 1];
    		int employeeIndex = id - 1; 
//    		for (int i = 0, j = 0; i < employees.length; i++) {
//    			if (i != employeeIndex) {
//    				placeholder[j++] = employees[i];
//    			}
//    		}
//    		employees = placeholder;
    		for (int i = employeeIndex; i < employees.length - 1; i++) {
    			employees[i] = employees[i + 1];
    		}
    	}
    }
    public void addEmployee(Employee newEmployee){
    	if (employees == null) {
    		Employee[] employees = new Employee[1];
    		employees[0] = newEmployee;
    		this.employees = employees;
        	Item[] items = newEmployee.startShift();
        	for (int i = 0; i < items.length; i++) {
        		storage.addItem(items[i]);
        	}
    	} else {
        	employees = resizeEmployeeArray(employees);
        	employees[employees.length - 1] = newEmployee;
        	
        	Item[] items = newEmployee.startShift();
        	for (int i = 0; i < items.length; i++) {
        		storage.addItem(items[i]);
        	}
    	}
    	
    }
    public Employee[] resizeEmployeeArray(Employee[] employees) {
    	return Arrays.copyOf(employees, employees.length + 1);

    }
    public boolean checkForEmployee(int id) {
    	for (int i = 0; i < employees.length; i++) {
    		if (employees[i].getId() == id) {
    			return true;
    		}
    	}
		return false;
    }
    public void addPayroll(Payroll payroll) {
    	if (payrolls == null) {
    		Payroll[] payrolls = new Payroll[1];
    		payrolls[0] = payroll;
    	}
    }
    public Payroll[] resizePayrollArray(Payroll[] item) {
    	return Arrays.copyOf(item, item.length - 1);
    }
    public int employeeIndexFinder(Employee[] employees, int id) {
    	for (int i = 0; i < employees.length; i++) {
    		if (employees[i].getId() == id) {
    			return i;
    		}
    	}
    	return -1;
    }
    
}
