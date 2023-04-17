package homework.stream_optional;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    public DepartmentService(EmployeeService employeeService) {
    }

    public void changeDepartment(Employee employee, int newDepartment) {
        EmployeeService.findAll().stream()
                .filter(value -> Objects.equals(employee, value))
                .findFirst()
                .ifPresent(value -> value.setDepartment(newDepartment));
    }

    public Map<Integer, List<Employee>> findEmployeesDepartment() {
        return EmployeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public double averageSalaryByDepartment(int department) {
        return EmployeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .average().orElse(0);
    }

    public Employee findMinSalaryInDepartment(int department) {
        return EmployeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee findMaxSalaryInDepartment(int department) {
        return EmployeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> findAllEmployeesByDepartment(int department) {
        return EmployeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    public void indexSalaryByDepartment(int index, int department) {
        EmployeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .forEach(employee -> employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100));
    }

    public int totalSalaryByDepartment(int department) {
        return EmployeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }
}