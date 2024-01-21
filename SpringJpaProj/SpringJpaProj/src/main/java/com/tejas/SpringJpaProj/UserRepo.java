package com.tejas.SpringJpaProj;

//import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tejas.SpringJpaProj.entities.User;

public interface UserRepo extends CrudRepository<User, Integer> {
    
    // as it is interface we cannot provid methods implementation
    // Implementation is provided automatically
    // this work on JPQL java persistant query language
    // these are derived quey or custom finder methods

    // public List<User> findByName(String name);
    // public List<User> findByStatus(String name);
    // public List<User> findByNameOrCity(String name, String city);
    // public List<User> findByNameStartingWith(String prefix);
    // public List<User> findByNameEndingWith(String suffix);
    // public List<User> findByNameContaining(String words);
    // public List<User> findByNameLike(String likePattern);
    // public List<User> findByAgeLessThan(int age);
    // public List<User> findByAgeGreaterThanEqual(int age);
    // public List<User> findByAgeIn(Collection<Integer> ages);
    // public List<User> findByNameOrderBy(String name);

    
    // Writing query  (JPQL or SQL)
    
    //jpql
    @Query("SELECT U FROM User U")
    public List<User> getAllUser();

    @Query("select u from User u where u.name = :n")
    public List<User> getUserByName(@Param("n") String name);

    //sql

    @Query(value = "select * from User", nativeQuery = true)
    public List<User> getUsers();
}
