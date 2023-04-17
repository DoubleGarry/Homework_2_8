package homework.stream_optional;

import homework.stream_optional.exception.EmployeeAlreadyAddedException;
import homework.stream_optional.exception.EmployeeNotFoundException;
import homework.stream_optional.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ListEmployeeService implements EmployeeService {
    private static final int CAPACITY = 10;
    private final List<Employee> team = new ArrayList<>();


    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        Employee emp = new Employee(firstName, lastName, department, salary);
        if (team.contains(emp)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (team.size() >= CAPACITY) {
            team.add(emp);
            return emp;
        }
        throw new EmployeeStorageIsFullException();
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, int salary) {
        Employee emp = new Employee(firstName, lastName, department, salary);
        if (!team.contains(emp)) {
            throw new EmployeeNotFoundException();
        }
        team.remove(emp);
        return emp;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department, int salary) {
        Employee emp = new Employee(firstName, lastName, department, salary);
        if (!team.contains(emp)) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    public List<Employee> findAll() {
        return new ArrayList<>(team);
    }
}
