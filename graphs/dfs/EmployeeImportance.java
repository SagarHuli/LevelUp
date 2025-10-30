package graphs.dfs;

import java.util.List;

public class EmployeeImportance {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        return dfs(employees, id);
    }

    private int dfs(List<Employee> employees, int id) {
        Employee e = getEmployee(employees, id);
        int importance = e.importance;
        for(int i=0; i<e.subordinates.size();i++) {
            importance += dfs(employees, e.subordinates.get(i));
        }
        return importance;
    }

    private Employee getEmployee(List<Employee> employees, int id) {
        return employees.stream().filter(e -> e.id == id).findFirst().get();
    }
}
