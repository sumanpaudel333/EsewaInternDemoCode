package com.example.multipledatabaseconnectiontask.configdb.service;

import com.example.multipledatabaseconnectiontask.configdb.dto.FileRequestDto;
import com.example.multipledatabaseconnectiontask.configdb.dto.FileResponseDto;
import com.example.multipledatabaseconnectiontask.configdb.model.FileDetails;
import com.example.multipledatabaseconnectiontask.configdb.repo.FileDetailsRepository;
import com.example.multipledatabaseconnectiontask.configdb.statusenum.FileStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FileServiceImplTest {
    @Mock
    private FileDetailsRepository fileDetailsRepository;
    @InjectMocks
    private FileServiceImpl fileService;
    private FileDetails fileDetails;
    private FileRequestDto fileRequestDto;

    @BeforeEach
    public void setUp() {
        fileRequestDto = new FileRequestDto();
        fileRequestDto.setFile_path("product.csv");
        fileDetails = new FileDetails();
        fileDetails.setId(1);
        fileDetails.setFilepath(fileRequestDto.getFile_path());
        fileDetails.setStatus(FileStatusEnum.PENDING);
        fileDetails.setSuccess_count(0);
        fileDetails.setFailure_count(0);
    }

    @Test
    public void testSaveFiles_testingFileDetailsSave_true() {
        FileResponseDto fileResponseDto = fileService.saveFileDetails(fileRequestDto);
        //act
        Mockito.when(fileDetailsRepository.save(fileDetails)).thenReturn(fileDetails);
        FileDetails fileDetails1 = fileDetailsRepository.save(fileDetails);

        //assert
        Assertions.assertNotNull(fileResponseDto);
        Assertions.assertEquals(1, fileDetails1.getId());
    }

}
