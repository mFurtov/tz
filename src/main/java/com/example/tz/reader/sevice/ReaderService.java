package com.example.tz.reader.sevice;

import com.example.tz.reader.dto.ReaderDtoRequest;
import com.example.tz.reader.dto.ReaderDtoResponse;

import java.util.List;

public interface ReaderService {

    ReaderDtoResponse addReader(ReaderDtoRequest dto);

    List<ReaderDtoResponse> getAllReaders();

    ReaderDtoResponse getReaderById(Long id);

    ReaderDtoResponse updateReader(Long id, ReaderDtoRequest dto);

    void deleteReader(Long id);

    ReaderDtoResponse getTopReader();
    List<ReaderDtoResponse> getTopReaderDidntReturn();
}