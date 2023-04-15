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
    private final List<Employee> team;
    public ListEmployeeService(){
        this.team = new ArrayList<>();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (team.contains(emp)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (team.size() >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        team.add(emp);
        return emp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (team.contains(emp)) {
            team.remove(emp);
            return emp;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (team.contains(emp)) {
            return emp;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(team);
    }
}
