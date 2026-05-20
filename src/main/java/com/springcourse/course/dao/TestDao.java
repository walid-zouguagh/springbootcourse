package com.springcourse.course.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.course.entity.TestEntity;
import com.springcourse.course.repository.TestRepo;

@Service
public class TestDao {

    @Autowired
    private TestRepo testRepo;

    public String getName() {
        return "my Name is Walid Zouguagh";
    }

    public List<TestEntity> getUsers() {
        return this.testRepo.findAll();
    }

    public Optional<TestEntity> getUserById(Integer userId) {
        return testRepo.findById(userId);
    }
}
