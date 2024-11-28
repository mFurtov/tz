package com.example.tz.reader.mapper;

import com.example.tz.reader.dto.ReaderDtoRequest;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.reader.model.Reader;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ReaderMapper {

    public Reader readerDtoRequestMappingToResponse(ReaderDtoRequest dto) {
        return new Reader(dto.getFirstName(), dto.getLastName(), dto.getGender(), dto.getBirthDate());
    }

    public ReaderDtoResponse readerMappingToReaderDtoResponse(Reader reader) {
        return new ReaderDtoResponse(reader.getId(), reader.getFirstName(), reader.getLastName(), reader.getGender(), reader.getBirthDate());
    }

    public List<ReaderDtoResponse> readerMappingToReaderDtoResponseList(List<Reader> reader) {
        List<ReaderDtoResponse> readerDtoResponses = new ArrayList<>();
        for (Reader r : reader) {
            readerDtoResponses.add(readerMappingToReaderDtoResponse(r));
        }
        return readerDtoResponses;
    }

}
