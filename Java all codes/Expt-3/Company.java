class Employee {
    String name, address, jobTitle;
    double salary;

    Employee(String n, String a, String j, double s) {
        name = n;
        address = a;
        jobTitle = j;
        salary = s;
    }

    void calculateBonus() {
        System.out.println("Bonus: " + (salary * 0.1));
    }

    void generateReport() {
        System.out.println(name + " - " + jobTitle);
    }

    void manageProject() {
        System.out.println(jobTitle + " managing project.");
    }
}

class Manager extends Employee {
    Manager(String n, String a, double s) {
        super(n, a, "Manager", s);
    }
}

class Developer extends Employee {
    Developer(String n, String a, double s) {
        super(n, a, "Developer", s);
    }
}

class Programmer extends Employee {
    Programmer(String n, String a, double s) {
        super(n, a, "Programmer", s);
    }
}

public class Company {
    public static void main(String[] args) {
        Manager m = new Manager("Alice", "City A", 80000);
        Developer d = new Developer("Bob", "City B", 60000);
        Programmer p = new Programmer("Charlie", "City C", 50000);

        m.calculateBonus(); m.generateReport(); m.manageProject();
        d.calculateBonus(); d.generateReport(); d.manageProject();
        p.calculateBonus(); p.generateReport(); p.manageProject();
    }
}

