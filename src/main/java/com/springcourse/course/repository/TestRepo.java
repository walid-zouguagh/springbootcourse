package com.springcourse.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcourse.course.entity.TestEntity;

public interface TestRepo extends JpaRepository<TestEntity, Integer>{

}
