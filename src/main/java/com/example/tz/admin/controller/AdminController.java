package com.example.tz.admin.controller;

import com.example.tz.admin.service.AdminServiceImpl;
import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.transaction.dto.TransactionDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/library/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/transaction")
    public TransactionDtoResponse makeTransaction(@RequestParam Long readerId, @RequestParam Long bookId) {
        return adminService.addTransaction(readerId, bookId);
    }

    @GetMapping("/top-author")
    public List<AuthorDtoResponse> getPopularAuthor(@RequestParam String startDate, @RequestParam String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
        LocalDate endLocalDate = LocalDate.parse(endDate, formatter);

        return adminService.getPopularAuthor(startLocalDate, endLocalDate);
    }

    @GetMapping("/top-reader")
    public ReaderDtoResponse getTopReader() {
        return adminService.getTopReader();
    }

    @GetMapping("/unreturned-books")
    private  List<ReaderDtoResponse> getTopReaderDidntReturn(){
        return adminService.getTopReaderDidntReturn();
    }

    @PatchMapping("/close/{id}")
    public TransactionDtoResponse closeTransaction(@PathVariable Long id) {
        return adminService.closeTransaction(id);
    }
}
