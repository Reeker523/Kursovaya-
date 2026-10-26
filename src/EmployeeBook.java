public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    // Добавление сотрудника
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }

        return false;
    }

    // Поиск по ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Вывод всех сотрудников
    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    // Средняя зарплата
    public double getAverageSalary() {
        double sum = 0;
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }
    // Расчёт налогов
    public void printTaxes(String type) {
        if (type == null) {
            System.out.println("Тип налога не указан");
            return;
        }

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            double salary = employee.getSalary();
            double rate;

            switch (type.toUpperCase()) {
                case "PROPORTIONAL":
                    rate = 0.13;
                    break;

                case "PROGRESSIVE":
                    if (salary <= 150) {
                        rate = 0.13;
                    } else if (salary <= 350) {
                        rate = 0.17;
                    } else {
                        rate = 0.21;
                    }
                    break;

                default:
                    System.out.println("Неизвестный тип налога: " + type);
                    return;
            }

            System.out.printf(
                    "%s: налог = %.2f%n",
                    employee.getFullName(),
                    salary * rate
            );
        }
    }

    // Индексация зарплат
    public void indexSalaries(int department, double percent) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Некорректный отдел");
        }

        if (!Double.isFinite(percent) || percent < 0) {
            throw new IllegalArgumentException(
                    "Процент индексации должен быть неотрицательным"
            );
        }

        for (Employee employee : employees) {
            if (employee == null
                    || employee.getDepartment() != department) {
                continue;
            }

            employee.setSalary(
                    employee.getSalary() * (1 + percent / 100)
            );
        }
    }

    // Первый сотрудник отдела с зарплатой выше заданной
    public void findByDepartmentAndSalary(
            int department, double salary) {

        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];

            if (employee == null) {
                continue;
            }

            if (employee.getDepartment() == department
                    && employee.getSalary() > salary) {
                System.out.print("Позиция в списке: " + (i + 1) + ". ");
                employee.printShortInfo();
                return;
            }
        }

        System.out.println("Подходящий сотрудник не найден");
    }

    // Первые employeeNumber сотрудников с зарплатой ниже wage
    public void printEmployeesBelowSalary(
            double wage, int employeeNumber) {

        if (employeeNumber <= 0) {
            return;
        }

        int i = 0;
        int printed = 0;

        while (i < employees.length) {
            Employee employee = employees[i];

            if (employee != null && employee.getSalary() < wage) {
                employee.printShortInfo();
                printed++;

                if (printed >= employeeNumber) {
                    break;
                }
            }

            i++;
        }
    }

    // Проверка наличия сотрудника по зарплате
    public boolean containsEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }

        for (Employee current : employees) {
            if (current != null && current.equals(employee)) {
                return true;
            }
        }

        return false;
    }
}
