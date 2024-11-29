package com.example.tz.admin.controller;

import com.example.tz.admin.service.AdminServiceImpl;
import com.example.tz.author.dto.AuthorDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/library/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;
@GetMapping("/top-author")
public List<AuthorDtoResponse> getPopularAuthor(@RequestParam String startDate, @RequestParam String endDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
    LocalDate endLocalDate = LocalDate.parse(endDate, formatter);

    return adminService.getPopularAuthor(startLocalDate, endLocalDate);
}
}
