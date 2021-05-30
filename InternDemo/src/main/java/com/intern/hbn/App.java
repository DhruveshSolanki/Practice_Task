package com.intern.hbn;

import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		String msg="";
		Person p =null;
		Connect connect = new Connect();
		int flag = 1;
		int choice;
		Scanner sc = new Scanner(System.in);
		while (flag != 0) {
			System.out.println("1: Insert");
			System.out.println("2:Update");
			System.out.println("3:Display");
			System.out.println("4:Delete");
			System.out.println("5:Exit");
			System.out.println("Select your choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				p=new Person();
				System.out.println("Enter id:");
				p.setpId(sc.nextInt());
				System.out.println("Enter Name:");
				p.setpName(sc.next());
				msg=connect.insertData(p);
				System.out.println(msg);
				break;

			case 2:
				System.out.println("Enter id:");
				p.setpId(sc.nextInt());
				System.out.println("Enter New Name:");
				p.setpName(sc.next());
				msg= connect.updateData(p);
				System.out.println(msg);
				break;

			case 3:
				List<Person> list = connect.displayData();
				for (Person per : list) {
					System.out.println(per);
				}
				break;

			case 4:
				System.out.println("Enter Id");
				int id = sc.nextInt();
				msg=connect.deleteData(id);
				System.out.println(msg);
				break;

			case 5:
				flag = 0;
				System.out.println("Terminated...");
				break;

			default:
				System.out.println("Invalid Choice...");
				break;
			}
		}

	}
}
