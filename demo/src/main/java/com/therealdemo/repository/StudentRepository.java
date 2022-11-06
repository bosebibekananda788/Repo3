package com.therealdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.therealdemo.entity.Address;
import com.therealdemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

List<Student> findByFirstName(String firstname);



List <Student> findByFirstNameOrLastName(String firstname,String lastName);

List <Student> findByFirstNameIn(List <String> firstNames);

@Query ("From Student where firstName=:firstName or lastName=:lastName ")
List <Student> getByFirstNameOrLastName(String firstName,String lastName);

@Modifying
@Transactional
@Query ("Update Student set firstName=:firstName where id=:id")
Integer updateFirstName(Long id , String firstName);

@Modifying
@Transactional
@Query ("Delete Student  where firstName=:firstName")
Integer deleteFirstName( String firstName);


List <Student> findByAddressCity(String city);

@Query ("from Student where address.city=:city ")
List<Student> getByAddressCity(String city);
	
}
