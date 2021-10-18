import java.io.*;
import java.util.*;

class Person {
	int age;
	String name;

	void sayHi() {
		System.out.println("Name : " + name + " Age : " + age);
	}
}

public class Main {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.age = 10;
		p1.name = "A";
		p1.sayHi();

		Person p2 = new Person();
		p2.age = 20;
		p2.name = "B";
		p2.sayHi();

		Person p3 = p1;
		p3.age = 30;
		p3.name = "C";
		p1.sayHi();
		p3.sayHi();

		Person[] arr = new Person[10];
		arr[0] = p1;
		arr[1] = p2;

		System.out.println("Before Swap");
		p1.sayHi();
		p2.sayHi();
		System.out.println("After Swap");
		// swap1(p1, p2);
		// swap2(p1, p2);
		swap3(p1, p2);
		p1.sayHi();
		p2.sayHi();

		// System.out.println(arr[0].name);
		// System.out.println("Before Swap");
		// arr[0].sayHi();
		// arr[1].sayHi();
		// System.out.println("After Swap");
		// swap(arr);
		// arr[0].sayHi();
		// arr[1].sayHi();
		// System.out.println(arr[0].name);
	}

	public static void swap(Person[] arr) {
		Person temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}

	public static void swap1(Person p1, Person p2) {
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

	public static void swap2(Person p1, Person p2) {
		int age = p1.age;
		p1.age = p2.age;
		p2.age = age;

		String name = p1.name;
		p1.name = p2.name;
		p2.name = name;
	}

	public static void swap3(Person p1, Person p2) {
		p1 = new Person();
		int age = p1.age;
		p1.age = p2.age;
		p2.age = age;

		p2 = new Person();
		String name = p1.name;
		p1.name = p2.name;
		p2.name = name;
	}

}