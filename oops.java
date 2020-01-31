import java.util.*;
class Person{
        String name;
        int age;
        Person(String name , int age){
            this.name=name;
            this.age=age;
            // System.out.println(this.name+"\t"+this.age);
        }
        Person(){
            System.out.println("default constructor calling...");
        }
        void display(){
            System.out.println(this.name+"\t"+this.age);
        }
    }
    class Student extends Person{
        int marks;
        Student(String name, int age , int marks){
            super(name,age);
            this.marks = marks;
        }
        @Override
        void display(){
            System.out.println(this.name+"\t"+this.age+"\t"+this.marks);
        }
    }
class main{   
    public static void main(String args[]){
        // Student s = new Student("Mayank",21,10);
        // s.display();
        // Person p = new Student("Mayank",21,10);
        // p.display();
    }
}