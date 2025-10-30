package graphs.bfs;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Queue<Integer> queue = new LinkedList<>();
        int importance = 0;
        queue.offer(id);
        while(!queue.isEmpty()) {
            Employee e = getEmployee(employees, queue.poll());
            importance += e.importance;
            for(int i=0; i< e.subordinates.size();i++) {
                queue.offer(e.subordinates.get(i));
            }
        }
        return importance;
    }

    private static Employee getEmployee(List<Employee> employees, int id) {
        return employees.stream().filter(e -> e.id == id).findFirst().get();
    }
}
