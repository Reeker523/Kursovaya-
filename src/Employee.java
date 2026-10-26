import java.util.Objects;

public class Employee {
    private static int counter = 1;

    private final int id;
    private final String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("ФИО не может быть пустым");
        }

        this.id = counter++;
        this.fullName = fullName;
        setDepartment(department);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException(
                    "Номер отдела должен быть от 1 до 5"
            );
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        if (!Double.isFinite(salary) || salary < 0) {
            throw new IllegalArgumentException(
                    "Некорректное значение зарплаты"
            );
        }
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;
        return Double.compare(salary, other.salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    public void printShortInfo() {
        System.out.println(
                "ФИО: " + fullName + ", зарплата: " + salary
        );
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", ФИО: " + fullName
                + ", отдел: " + department
                + ", зарплата: " + salary;
    }
}
