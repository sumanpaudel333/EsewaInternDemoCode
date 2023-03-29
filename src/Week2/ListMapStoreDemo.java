package Week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    private int id;
    private String name;
    private double Salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Salary=" + Salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }
}

public class ListMapStoreDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Suman", 9000));
        list.add(new Employee(2, "Saurav", 7000));
        list.add(new Employee(3, "Shreejal", 6000));
        list.add(new Employee(4, "Preet", 7500));
        list.add(new Employee(5, "Suman", 8500));
        list.add(new Employee(6, "Preet", 9500));
        // System.out.println(list);

        Map<String, List<Employee>> map = new HashMap<>();
        for (Employee e : list) {

            if (map.containsKey(e.getName())) {

                List<Employee> b = map.get(e.getName());
                b.add(e);
                map.put(e.getName(), b);
            } else {
                List<Employee> l = new ArrayList<>();
                l.add(e);
                map.put(e.getName(), l);
            }
        }
        System.out.println(map);
    }
}
