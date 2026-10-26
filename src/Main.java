public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        Employee[] employees = {
                new Employee("Иванов Иван Иванович", 1, 100),
                new Employee("Петров Петр Петрович", 2, 200),
                new Employee("Сидоров Сидор Сидорович", 3, 300),
                new Employee("Смирнова Анна Ивановна", 1, 400),
                new Employee("Козлов Алексей Сергеевич", 4, 150),
                new Employee("Попова Мария Олеговна", 2, 250),
                new Employee("Васильев Дмитрий Андреевич", 5, 350),
                new Employee("Новикова Елена Павловна", 3, 120),
                new Employee("Федоров Максим Игоревич", 4, 320),
                new Employee("Морозова Ольга Сергеевна", 5, 450),
                new Employee("Волков Артем Николаевич", 1, 180)
        };

        // Добавление 11 сотрудников
        for (Employee employee : employees) {
            System.out.println("Добавление: " + book.addEmployee(employee));
        }

        System.out.println("\nВсе сотрудники:");
        book.printAllEmployees();

        System.out.printf(
                "%nСредняя зарплата: %.2f%n",
                book.getAverageSalary()
        );

        System.out.println("\nПропорциональный налог:");
        book.printTaxes("PROPORTIONAL");

        System.out.println("\nПрогрессивный налог:");
        book.printTaxes("PROGRESSIVE");

        System.out.println("\nИндексация отдела 1 на 10%:");
        book.indexSalaries(1, 10);
        book.printAllEmployees();

        System.out.println("\nПоиск в отделе 2:");
        book.findByDepartmentAndSalary(2, 150);

        System.out.println("\nПервые 3 сотрудника с зарплатой ниже 300:");
        book.printEmployeesBelowSalary(300, 3);

        System.out.println("\nПоиск по ID = 3:");
        Employee found = book.getEmployeeById(3);
        System.out.println(
                found != null ? found : "Сотрудник не найден"
        );

        System.out.println("\nПроверка по зарплате:");
        Employee test = new Employee("Тестовый сотрудник", 1, 200);
        System.out.println(book.containsEmployee(test));
    }
}
