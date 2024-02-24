// package com.exam.app.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// @Configuration
// public class AppConfig {
    
//     //spring security uses UserDetailsService to work. It uses loadUserByUsername to fetch User 
//     @Bean
//     public UserDetailsService userDetailsService(){
//         UserDetails user1 =  User.builder().username("tejas").password(passwordEncoder().encode("1234")).roles("Admin").build();
//         UserDetails user2 =  User.builder().username("ram").password(passwordEncoder().encode("1234")).roles("Admin").build();
//         return new InMemoryUserDetailsManager(user1,user2);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder(){
//         return new BCryptPasswordEncoder();
//     }

// }
