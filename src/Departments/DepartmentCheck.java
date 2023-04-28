package Departments;

public class DepartmentCheck {
    public static void main(String[] args) {

        Department d1 = new Department("Mihoyo", 50, "Java");
        Department d2 = new Department("Kixeye", 45, "Kotlin");
        Department d3 = new Department("EA", 20, "Python");

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        System.out.println("Dep1 = Dep2 Check : " + d1.equals(d2));
        System.out.println("Dep2 = Dep3 Check : " + d2.equals(d3));
        // if any of these departments are the same, this will print True.
    }
}
