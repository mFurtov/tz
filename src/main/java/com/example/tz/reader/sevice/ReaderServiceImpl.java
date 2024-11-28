package com.example.tz.reader.sevice;

import com.example.tz.reader.dao.ReaderRepository;
import com.example.tz.reader.dto.ReaderDtoRequest;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.reader.mapper.ReaderMapper;
import com.example.tz.reader.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public ReaderDtoResponse addReader(ReaderDtoRequest dto) {

        return ReaderMapper.readerMappingToReaderDtoResponse(readerRepository.save(ReaderMapper.readerDtoRequestMappingToResponse(dto)));
    }

    public List<ReaderDtoResponse> getAllReaders() {
        return ReaderMapper.readerMappingToReaderDtoResponseList(readerRepository.findAll());
    }

    public ReaderDtoResponse getReaderById(Long id) {
        return ReaderMapper.readerMappingToReaderDtoResponse(readerRepository.getById(id));
    }

    public ReaderDtoResponse updateReader(Long id, ReaderDtoRequest dto) {
        Reader reader = readerRepository.getReferenceById(id);
        if (reader != null) {
            if (dto.getFirstName() != null && !dto.getFirstName().isBlank()) {
                reader.setFirstName(dto.getFirstName());
            }
            if (dto.getLastName() != null && !dto.getLastName().isBlank()) {
                reader.setLastName(dto.getLastName());
            }
            if (dto.getGender() != null) {
                reader.setGender(dto.getGender());
            }
            if (dto.getBirthDate() != null) {
                reader.setBirthDate(dto.getBirthDate());
            }
        }
        return ReaderMapper.readerMappingToReaderDtoResponse(readerRepository.save(reader));
    }

    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }
}
