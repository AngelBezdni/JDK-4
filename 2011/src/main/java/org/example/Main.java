package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        // Добавление
        directory.addEmployee(new EmployeeDirectory.Employee(1001, "+7 900 123 4567", "Иван Иванов", 5));
        directory.addEmployee(new EmployeeDirectory.Employee(1002, "+7 900 987 6543", "Петр Петров", 10));
        directory.addEmployee(new EmployeeDirectory.Employee(1003, "+7 900 555 6666", "Сергей Сергеев", 8));
        directory.addEmployee(new EmployeeDirectory.Employee(1004, "+7 900 777 8888", "Анна Сидорова", 12));

        // По табельному
        EmployeeDirectory.Employee foundEmployee = directory.findByTabNumber(1002);
        System.out.println("Найденный сотрудник по табельному номеру:");
        System.out.println(foundEmployee);

        // По стажу
        List<EmployeeDirectory.Employee> experiencedEmployees = directory.findByExperience(10);
        System.out.println("\nСотрудники со стажем 10 лет:");
        experiencedEmployees.forEach(System.out::println);

        // Телефоны по имени
        List<String> phoneNumbers = directory.getPhoneNumbersByName("Иван Иванов");
        System.out.println("\nНомера телефонов Ивана Иванова:");
        phoneNumbers.forEach(System.out::println);
    }
}