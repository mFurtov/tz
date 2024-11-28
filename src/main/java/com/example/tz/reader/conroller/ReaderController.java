package com.example.tz.reader.conroller;

import com.example.tz.reader.dto.ReaderDtoRequest;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.reader.sevice.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/readers")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @PostMapping
    public ReaderDtoResponse addReader(@RequestBody ReaderDtoRequest dto) {
        return readerService.addReader(dto);
    }

    @GetMapping
    public List<ReaderDtoResponse> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping("/{id}")
    public ReaderDtoResponse getReaderById(@PathVariable Long id) {
        return readerService.getReaderById(id);
    }

    @PatchMapping("/{id}")
    public ReaderDtoResponse updateReader(@PathVariable Long id, @RequestBody ReaderDtoRequest dto) {
        return readerService.updateReader(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
    }
}
