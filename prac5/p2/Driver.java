public class Driver {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTime("Riya", "E101", 50000),
            new PartTime("Aman", "E102", 80, 300),
            new Intern("Neha", "E103", 12000)
        };

        double total = 0;

        for (Employee employee : employees) {
            double salary = employee.monthlySalary();
            System.out.println(employee.name + " (" + employee.id
                    + "): " + salary);

            if (employee instanceof Intern) {
                System.out.println("  This employee is an intern.");
            }

            total += salary;
        }

        System.out.println("Total payroll: " + total);
    }
}