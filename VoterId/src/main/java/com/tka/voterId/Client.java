package com.tka.voterId;

import java.util.ArrayList;
import java.util.List;

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

		Person p1 = new Person(3102, "Shoaib");
		VotingCard v1 = new VotingCard("Sh123", "Latur");
		Address a1 = new Address(413517, "Udgir");

		Person p2 = new Person(6806, "Shoaib");
		VotingCard v2 = new VotingCard("Sh1234", "Latur");
		Address a2 = new Address(411042, "Udgir");

		List<Address> list = new ArrayList<Address>();
		list.add(a1);
		list.add(a2);

		p2.setAddress(list);
		p2.setVoter_id(v2);

		// Insert Data
		session.save(p2);

		// Fetch Data
		Person person = session.load(Person.class, 3102);
		System.out.println(person);
		tx.commit();
		session.close();
		factory.close();

	}
}
