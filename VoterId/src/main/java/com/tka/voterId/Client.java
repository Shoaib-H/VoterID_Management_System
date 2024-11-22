package com.tka.voterId;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {
	public static void main(String[] args) {
		Configuration cif = new Configuration();
		cif.configure();
		cif.addAnnotatedClass(Person.class);
		cif.addAnnotatedClass(VotingCard.class);
		cif.addAnnotatedClass(Address.class);

		SessionFactory factory = cif.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Scanner sc = new Scanner(System.in);

//		Person p1 = new Person(3102, "Shoaib");
//		VotingCard v1 = new VotingCard("Sh123", "Latur");
//		Address a1 = new Address(413517, "Udgir");
//
//		Person p2 = new Person(6806, "Shoaib");
//		VotingCard v2 = new VotingCard("Sh123", "Latur");
//		Address a2 = new Address(411042, "Udgir");

//		List<Address> list = new ArrayList<Address>();
//		list.add(a1);
//		list.add(a2);
//
//		p2.setAddress(a2);
//		p2.setVoter_id(v2);
//
//		// Insert Data
//		session.save(p2);

		// Fetch Data
//		Person person = session.load(Person.class, 3102);
//		System.out.println(person);
		while (true) {
			
		
		System.out.println("Welcome to Voter_id Management Portal");
		System.out.println();

		System.out.println("1. Insert/Save a Person into Databse");
		System.out.println("2. Fetch Person using Aadhar_ID");
		System.out.println("3. Delete Person using Aadhar_ID");
		System.out.println("4. Get all Person Details");

		System.err.println("Enter Your Choice");

		int key = sc.nextInt();
		switch (key) {
		case 1:
			Person p1 = new Person();
			System.out.println("Enter Aadhar Number");
			p1.setAadhar_id(sc.nextInt());
			System.out.println("Enter name of Person");
			p1.setName(sc.next());

			VotingCard v1 = new VotingCard();
			System.out.println("Enter Voting ID");
			v1.setVoter_id(sc.next());
			System.out.println("Enter Constituency");
			v1.setConstituency(sc.next());

			Address a1 = new Address();
			System.out.println("Enter Pincode");
			a1.setPin_code(sc.nextInt());
			System.out.println("Enter City");
			a1.setCity(sc.next());

			p1.setAddress(a1);
			p1.setVoter_id(v1);
			session.save(p1);
			tx.commit();
			session.close();
			factory.close();
			break;

		case 2:
			System.out.println("Enetr Aadhar ID to fetch Details");
			Person person = session.get(Person.class, sc.nextInt());
			System.out.println(person);
			break;

		case 3:

			System.out.println("Enetr Aadhar ID to Delete Person");
			Person p2 = new Person();
			p2.setAadhar_id(sc.nextInt());
			session.delete(p2);
			tx.commit();
			break;

		case 4:
			System.out.println("Get All Person Details");
			Criteria criteria = session.createCriteria(Person.class);
			List list = criteria.list();
			for (Object object : list) {
				System.out.println(object);
			}

		default:
			break;
		}
		}
	}
}
