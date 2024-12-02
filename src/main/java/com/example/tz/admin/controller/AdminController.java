package com.example.tz.admin.controller;

import com.example.tz.admin.service.AdminServiceImpl;
import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.transaction.dto.TransactionDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/library/admin")
@Tag(name = "Admin Controller", description = "Управление библиотекой для администратора")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/transaction")
    @Operation(
            summary = "Создать транзакцию",
            description = "Создает новую транзакцию для передачи книги от библиотеки читателю."
    )
    public TransactionDtoResponse makeTransaction(@RequestParam Long readerId, @RequestParam Long bookId) {
        return adminService.addTransaction(readerId, bookId);
    }

    @GetMapping("/top-author")
    @Operation(
            summary = "Получить популярных авторов",
            description = "Возвращает список авторов, книги которых были наиболее популярны в заданный период."
    )
    public List<AuthorDtoResponse> getPopularAuthor(@RequestParam String startDate, @RequestParam String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
        LocalDate endLocalDate = LocalDate.parse(endDate, formatter);

        return adminService.getPopularAuthor(startLocalDate, endLocalDate);
    }

    @GetMapping("/top-reader")
    @Operation(
            summary = "Получить самого активного читателя",
            description = "Возвращает читателя, который совершил наибольшее количество транзакций."
    )
    public ReaderDtoResponse getTopReader() {
        return adminService.getTopReader();
    }

    @GetMapping("/unreturned-books")
    @Operation(
            summary = "Получить читателей с не возвращёнными книгами",
            description = "Возвращает список читателей, которые не вернули книги в установленный срок."
    )
    private List<ReaderDtoResponse> getTopReaderDidntReturn() {
        return adminService.getTopReaderDidntReturn();
    }

    @PatchMapping("/close/{id}")
    @Operation(
            summary = "Закрыть транзакцию",
            description = "Закрывает указанную транзакцию по её идентификатору."
    )
    public TransactionDtoResponse closeTransaction(@PathVariable Long id) {
        return adminService.closeTransaction(id);
    }
}
