package com.techcom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.techcom.entity.Course;
import com.techcom.entity.user;
import com.techcom.service.serviceprovider;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Addcources {

    @Autowired
    private serviceprovider serviceservices;

    @PostMapping("user/addcourse")
    public String postMethodName(@RequestParam("email") String emString,
                                 @RequestParam("description") String discription,
                                 @RequestParam("title") String title,
                                 @RequestParam("price") int price,
                                 Model model) {

        user user = serviceservices.getuser(emString);
        System.out.println(discription + " " + title + " " + price);

        Course objCourse = new Course();
        objCourse.setDescription(discription);
        objCourse.setTitle(title);
        objCourse.setPrice(price);

        List<user> users = new ArrayList<>();
        users.add(user);

        objCourse.setUsers(users);
        objCourse.setLessons(null);

        List<Course> courses = user.getCourses();
        courses.add(objCourse);
        user.setCourses(courses);

        serviceservices.updateUser(user);
        Course objCourse2 = serviceservices.addcourse(objCourse);

        if (objCourse2 == null) {
            model.addAttribute("errorMessage", "Course creation failed. Please try again.");
            return "msg";
        }

        model.addAttribute("errorMessage", "Course created successfully!");
        return "msg";
    }
}
