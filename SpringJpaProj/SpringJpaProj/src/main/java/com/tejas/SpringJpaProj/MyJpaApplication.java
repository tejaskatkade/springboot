package com.tejas.SpringJpaProj;


import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.Query;

import com.tejas.SpringJpaProj.entities.User;

@SpringBootApplication
@ComponentScan(basePackages = "com.tejas.SpringJpaProj")
public class MyJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MyJpaApplication.class, args);
		
		UserRepo userRepo = context.getBean(UserRepo.class);
		
		// User user1 = new User();
		
		// user1.setName("Ms dhoni");
		// user1.setCity("Delhi");
		// user1.setStatus("Java Devloper");
		
		// User user2 = new User();

		// user2.setName("Rohit sharma");
		// user2.setCity("Mumbai");
		// user2.setStatus("Android Devloper");
		
		// User user3 = new User();

		// user3.setName("Virat Kohli");
		// user3.setCity("Pune");
		// user3.setStatus("Python Devloper");

		// User resUser1 = userRepo.save(user1);
		// User resUser2 = userRepo.save(user2);
		// User resUser3 = userRepo.save(user3);
		// save()  => saves your entity

		// System.out.println(resUser1);
		// System.out.println(resUser2);

		// List<User> userList = List.of(user1,user2,user3);

		// // saveAll()  => saves all your entities
		// Iterable<User> itr = userRepo.saveAll(userList);

		// itr.forEach(i->{
		// 	System.out.println(i);
		// });


		// // how to get data
		// // findAll()  - return Iterable
		// // findById(id)  -return Optional class type data

		// Optional<User> optional = userRepo.findById(1); 
		// User user = optional.get();
		// System.out.println(user);

		// //Update user
		// user.setName("Narendra Modi");
		// User resuser = userRepo.save(user);
		// System.out.println(resuser);

		// Iterable<User> itr = userRepo.findAll();

		// itr.forEach(i->{
		// 	System.out.println(i);
		// });

		// //Deleting the user entity

		// userRepo.deleteById(4);
		// System.out.println("User entity deleted");

		// Iterable<User> itr1 = userRepo.findAll();

		// itr1.forEach(i->{
		// 	System.out.println(i);
		// });

		// //userRepo.deleteAll(itr);;

		// //Derived methods

		// System.out.println("Rohit sharma");

		// List<User> users = userRepo.findByName("rohit sharma");

		// for (User user : users) {
		// 	System.out.println(user);
		// }


		// System.out.println("________________________________");
		// System.out.println("Java Devloper");

		// List<User> user1 = userRepo.findByStatus("java devloper");

		// for (User user : user1) {
		// 	System.out.println(user);
		// }

		// System.out.println("___________________________________");
		// System.out.println("city = Mumbai OR name = Narendra Modi");

		// List<User> user2 = userRepo.findByNameOrCity("Narendra Modi","Mumbai");

		// for (User user: user2) {
		// 	System.out.println(user);
		// }


		List<User> users =userRepo.getAllUser();

		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println("_____________________________________________________");
		List<User> users1 =userRepo.getUserByName("Narendra Modi");

		for (User user : users1) {
			System.out.println(user);
		}

		System.out.println("_____________________________________________________");
		List<User> users2 =userRepo.getUsers();

		for (User user : users2) {
			System.out.println(user);
		}


		
		
		
		




		
	}

}
