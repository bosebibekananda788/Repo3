package com.therealdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.therealdemo.entity.Address;
import com.therealdemo.entity.Student;
import com.therealdemo.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {


	
}
