package Departments;

import java.util.Objects;

public class Department{
    private String name;
    private int totalEmployees;
    private String language;

    public Department(String name, int totalEmployees, String language){
        this.name = name;
        this.totalEmployees = totalEmployees;
        this.language = language;
    }
    public String getName() {
        return name;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Departments.Department{" + "\n" + " name: " + name
                + "\n" + " Amount of Employees: " + totalEmployees
                + "\n" + " Coding Language: " + language + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return totalEmployees == that.totalEmployees &&
                Objects.equals(name, that.name) &&
                Objects.equals(language, that.language);
    }
}
