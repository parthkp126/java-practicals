abstract class Employee {
    protected String name;
    protected String id;

    Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    private double fixedSalary;

    FullTime(String name, String id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
    }

    @Override
    double monthlySalary() {
        return fixedSalary;
    }
}

class PartTime extends Employee {
    private int hours;
    private double ratePerHour;

    PartTime(String name, String id, int hours, double ratePerHour) {
        super(name, id);
        this.hours = hours;
        this.ratePerHour = ratePerHour;
    }

    @Override
    double monthlySalary() {
        return hours * ratePerHour;
    }
}

class Intern extends Employee {
    private double stipend;

    Intern(String name, String id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    double monthlySalary() {
        return stipend;
    }
}