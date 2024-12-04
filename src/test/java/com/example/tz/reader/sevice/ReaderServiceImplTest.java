package com.example.tz.reader.sevice;

import com.example.tz.reader.dao.ReaderRepository;
import com.example.tz.reader.dto.ReaderDtoRequest;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.reader.mapper.ReaderMapper;
import com.example.tz.reader.model.Gender;
import com.example.tz.reader.model.Reader;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReaderServiceImplTest {
    @Mock
    private ReaderRepository readerRepository;
    @InjectMocks
    private ReaderServiceImpl readerService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testAddReader() {
        ReaderDtoRequest dtoRequest = new ReaderDtoRequest();
        dtoRequest.setFirstName("John");
        dtoRequest.setLastName("Doe");
        dtoRequest.setGender(Gender.Ж);
        dtoRequest.setBirthDate(LocalDate.of(1990, 1, 1));

        Reader reader = new Reader();
        reader.setFirstName("John");
        reader.setLastName("Doe");
        reader.setGender(Gender.Ж);
        reader.setBirthDate(LocalDate.of(1990, 1, 1));

        when(readerRepository.save(any(Reader.class))).thenReturn(reader);

        ReaderDtoResponse response = readerService.addReader(dtoRequest);

        assertNotNull(response);
        assertEquals("John", response.getFirstName());
        assertEquals("Doe", response.getLastName());
        verify(readerRepository, times(1)).save(any(Reader.class));
    }

    @Test
    void getAllReaders() {
    }

    @Test
    void getReaderById() {
    }

    @Test
    void testUpdateReader() {
        ReaderDtoRequest readerDtoRequest = new ReaderDtoRequest();
        readerDtoRequest.setFirstName("John");
        readerDtoRequest.setLastName("Doe");

        Reader oldReader = new Reader();
        oldReader.setFirstName("OldFirstName");
        oldReader.setLastName("OldLastName");
        oldReader.setGender(Gender.Ж);
        oldReader.setBirthDate(LocalDate.of(1990, 1, 1));

        Reader updateReader = new Reader();
        updateReader.setFirstName("John");
        updateReader.setLastName("Doe");
        updateReader.setGender(Gender.Ж);
        updateReader.setBirthDate(LocalDate.of(1990, 1, 1));

        when(readerRepository.getReferenceById(anyLong())).thenReturn(oldReader);
        when(readerRepository.save(any(Reader.class))).thenReturn(updateReader);

        ReaderDtoResponse response = readerService.updateReader(1l,readerDtoRequest);

        verify(readerRepository,times(1)).getReferenceById(1l);
        verify(readerRepository, times(1)).save(updateReader);

    }

    @Test
    void deleteReader() {
    }

    @Test
    void getTopReader() {
    }

    @Test
    void getTopReaderDidntReturn() {
    }
}