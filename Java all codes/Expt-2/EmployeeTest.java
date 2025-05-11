class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    Employee(String f, String l, double s) {
        firstName = f;
        lastName = l;
        if (s > 0) {
            monthlySalary = s;
        } else {
            monthlySalary = 0.0;
        }
    }

    void setFirstName(String f) { firstName = f; }
    void setLastName(String l) { lastName = l; }

    void setMonthlySalary(double s) {
        if (s > 0) {
            monthlySalary = s;
        } else {
            monthlySalary = 0.0;
        }
    }

    String getFirstName() { return firstName; }
    String getLastName() { return lastName; }
    double getMonthlySalary() { return monthlySalary; }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Doe", 3000);
        Employee e2 = new Employee("Jane", "Smith", 4000);

        System.out.println(e1.getFirstName() + " yearly salary: " + (e1.getMonthlySalary() * 12));
        System.out.println(e2.getFirstName() + " yearly salary: " + (e2.getMonthlySalary() * 12));

        e1.setMonthlySalary(e1.getMonthlySalary() * 1.1);
        e2.setMonthlySalary(e2.getMonthlySalary() * 1.1);

        System.out.println(e1.getFirstName() + " new yearly salary: " + (e1.getMonthlySalary() * 12));
        System.out.println(e2.getFirstName() + " new yearly salary: " + (e2.getMonthlySalary() * 12));
    }
}
