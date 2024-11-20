package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDirectory {

    public static class Employee {
        private int tabNumber;
        private String phoneNumber;
        private String name;
        private int experience;

        public Employee(int tabNumber, String phoneNumber, String name, int experience) {
            this.tabNumber = tabNumber;
            this.phoneNumber = phoneNumber;
            this.name = name;
            this.experience = experience;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "tabNumber=" + tabNumber +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", name='" + name + '\'' +
                    ", experience=" + experience +
                    '}';
        }
    }

    private final Map<Integer, Employee> employeesByTabNumber = new HashMap<>();
    private final Map<String, List<Employee>> employeesByName = new HashMap<>();
    private final Map<Integer, List<Employee>> employeesByExperience = new HashMap<>();

    public Employee findByTabNumber(int tabNumber) {
        return employeesByTabNumber.get(tabNumber);
    }

    public List<Employee> findByExperience(int experience) {
        return employeesByExperience.getOrDefault(experience, new ArrayList<>());
    }

    public List<String> getPhoneNumbersByName(String name) {
        List<Employee> employees = employeesByName.get(name);
        if (employees == null || employees.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> phoneNumbers = new ArrayList<>();
        for (Employee employee : employees) {
            phoneNumbers.add(employee.phoneNumber);
        }
        return phoneNumbers;
    }

    public void addEmployee(Employee employee) {
        employeesByTabNumber.put(employee.tabNumber, employee);

        employeesByName.computeIfAbsent(employee.name, key -> new ArrayList<>()).add(employee);

        employeesByExperience.computeIfAbsent(employee.experience, key -> new ArrayList<>()).add(employee);
    }
}