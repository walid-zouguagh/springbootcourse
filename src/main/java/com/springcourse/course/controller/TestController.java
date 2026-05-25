package com.springcourse.course.controller;

import com.springcourse.course.dao.TestDao;
import com.springcourse.course.entity.TestEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestDao testDao;

    @GetMapping("test")
    public String getName() {
        return this.testDao.getName();
    }

    @GetMapping(path = "/get-users")
    public List<TestEntity> getUsers() {
        return this.testDao.getUsers();
    }

    @GetMapping(path = "/test-optional")
    public void testOptional() {
        Integer x = null;
        Optional<Integer> opt = Optional.ofNullable(x);
        if (opt.isPresent()) {
            System.out.println("is present");
        } else {
            System.out.println("is Not present");
        }

        x = opt.orElse(10);
        System.out.println(x);

        opt.ifPresent(i -> {
            System.out.println(i);
        });

        opt.orElseThrow(() -> new ExpressionException("value not valid!!!"));
    }

    // @GetMapping(path = "/find-user") // localhost:8080/find-user?id=10
    // public Optional<TestEntity> getUserById(@RequestParam(name = "id") Integer
    // userId) {
    // return this.testDao.getUserById(userId);
    // }

    @GetMapping(path = "/find-user") // localhost:8080/find-user?id=10
    public String getUserById(@RequestParam(name = "id") Integer userId) {
        // return this.testDao.getUserById(userId);
        Optional<TestEntity> user = testDao.getUserById(userId);
        if (user.isPresent()) {
            return "UserName : " + user.get().getUsername() + ", Full name is : " +
                    user.get().getFullName();
        } else {
            return "user id not exists";
        }
    }

    @GetMapping(path = "/delete-user") // localhost:8080/delete-user?id=10
    public String deleteUserById(@RequestParam(name = "id") Integer userId) {
        return this.testDao.deleteUserById(userId);
    }

    @PostMapping(path = "/save-user")
    public TestEntity saveUser(@RequestBody TestEntity testEntity) {
        return this.testDao.saveUser(testEntity);
    }

    @PostMapping(path = "/update-user")
    public TestEntity updateUser(@RequestBody TestEntity testEntity) {
        return this.testDao.updateUser(testEntity);
    }

    @GetMapping(path = "get-all-users")
    public List<TestEntity> getAllUsers() {
        return this.testDao.getAllUsers();
    }

}
