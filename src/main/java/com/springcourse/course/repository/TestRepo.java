package com.springcourse.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springcourse.course.entity.TestEntity;

public interface TestRepo extends JpaRepository<TestEntity, Integer>{
    @Query(value = "SELECT t FROM TestEntity t")
    List<TestEntity> getAllUsers();
}
