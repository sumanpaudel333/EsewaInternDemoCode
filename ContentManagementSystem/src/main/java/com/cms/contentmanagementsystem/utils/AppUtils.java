package com.cms.contentmanagementsystem.utils;

import com.cms.contentmanagementsystem.dto.FileContentDto;
import com.cms.contentmanagementsystem.entity.FileContent;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static FileContentDto convertEntityToDto(FileContent fileContent) {
        FileContentDto fileContentDto = new FileContentDto();
        BeanUtils.copyProperties(fileContent, fileContentDto);
        return fileContentDto;
    }

    public static FileContent convertDtoToEntity(FileContentDto fileContentDto) {
        FileContent fileContent = new FileContent();
        BeanUtils.copyProperties(fileContentDto, fileContent);
        return fileContent;
    }
}
