package homework.stream_optional;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    static List<Employee> findAll() {
        return findAll();
    }

    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee removeEmployee(String firstName, String lastName, int department, int salary);

    Employee findEmployee(String firstName, String lastName, int department, int salary);




}
