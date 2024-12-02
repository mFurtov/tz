package com.example.tz.reader.conroller;

import com.example.tz.reader.dto.ReaderDtoRequest;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.reader.sevice.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/readers")
@Tag(name = "Reader Controller", description = "Управление читателями библиотеки")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @PostMapping
    @Operation(
            summary = "Добавить нового читателя",
            description = "Добавляет нового читателя в библиотеку."
    )
    public ReaderDtoResponse addReader(@RequestBody ReaderDtoRequest dto) {
        return readerService.addReader(dto);
    }

    @GetMapping
    @Operation(
            summary = "Получить всех читателей",
            description = "Возвращает список всех читателей библиотеки."
    )
    public List<ReaderDtoResponse> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить читателя по ID",
            description = "Возвращает данные читателя по указанному идентификатору."
    )
    public ReaderDtoResponse getReaderById(@PathVariable Long id) {
        return readerService.getReaderById(id);
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Обновить данные читателя",
            description = "Обновляет информацию о читателе по указанному идентификатору."
    )
    public ReaderDtoResponse updateReader(@PathVariable Long id, @RequestBody ReaderDtoRequest dto) {
        return readerService.updateReader(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить читателя",
            description = "Удаляет читателя из библиотеки по указанному идентификатору."
    )
    public void deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
    }
}
