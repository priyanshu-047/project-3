package com.techcom.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.techcom.entity.Course;
import com.techcom.entity.lessons;
import com.techcom.entity.user;
import com.techcom.repo.courserepo;
import com.techcom.repo.lessonrepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class Addlession {

    @Autowired
    private courserepo courseRepo;

    @Autowired
    private lessonrepo lessonRepo;

    @PostMapping("user/addlesson")
    public String addLesson(@RequestParam("content") MultipartFile file,
                            @RequestParam("title") String title,
                            @RequestParam("cource-id") int courcesId,
                            HttpSession session, Model model) throws IOException {

        Course course = courseRepo.findByid(courcesId);
        if (course == null) {
            model.addAttribute("errorMessage", "Course not found.");
            return "msg";
        }

        user user1 = (user) session.getAttribute("user");
        System.out.println("user1 : " + user1.getEmail());

        List<user> users = course.getUsers();
        user user2 = users.get(0); // Assuming first user is course owner

        System.out.println("user2 : " + user2.getEmail());

        if (!user1.getEmail().equals(user2.getEmail())) {
            model.addAttribute("errorMessage", "You are not authorized to access this cource.");
            return "msg";
        }

        List<lessons> ls = course.getLessons();
        lessons lesson = new lessons();
        lesson.setTitle(title);
        lesson.setCourse(course);

       
        String pathString = new ClassPathResource("static/uploads").getFile().getAbsolutePath();
        File destinationFile = new File(pathString + File.separator + file.getOriginalFilename());
        file.transferTo(destinationFile);

        lesson.setContent(file.getOriginalFilename());
        lessonRepo.save(lesson);
        ls.add(lesson);
        course.setLessons(ls);
        courseRepo.save(course);

        System.out.println("Course: " + course.getTitle());
        System.out.println("Lessons: " + course.getLessons());
        System.out.println("File saved to: " + destinationFile.getAbsolutePath());

        model.addAttribute("errorMessage", "Lesson uploaded successfully!");
        return "msg";
    }
}
