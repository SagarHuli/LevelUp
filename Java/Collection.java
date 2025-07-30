package Java;

import java.util.*;

public class Collection {

    public static void main(String [] a) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1,"ab",34),
                new Employee(2,"berg",4),
                new Employee(4,"norm",43),
                new Employee(3,"quant",674),
                new Employee(5,"squat",101),
                new Employee(5,"squat",11)
        );

        Collections.sort(employeeList);
        employeeList.forEach(System.out::println);
        System.out.println("******");

        Comparator<Employee> NAME_COMPARATOR = Comparator.comparing(Employee::name)
                .thenComparing((o1, o2) -> o2.score() > o1.score() ? 1:-1);
        employeeList.stream().sorted(NAME_COMPARATOR).forEach(System.out::println);
    }

}

record Employee( int id, String name, int score) implements Comparable<Employee>{

    @Override
    public int compareTo(Employee i) {
        return Integer.compare(id, i.id);
    }
}