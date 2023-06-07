package com.hotelbooking.roomservice.service;

import lombok.RequiredArgsConstructor;
import com.hotelbooking.roomservice.model.Room;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.hotelbooking.roomservice.repo.RoomRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;
    @Override
    public Room addNewRoom(Room room, MultipartFile multipartFile) {
        room.setRoomImage(multipartFile.getName());
        return roomRepository.save(room);
    }

    @Override
    public String uploadImage(String path,MultipartFile multipartFile) throws IOException {
        String fileName= multipartFile.getOriginalFilename();
        String filePath=path + File.separator +fileName;
        File file=new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        Files.copy(multipartFile.getInputStream(), Paths.get(filePath));
        return "Image Uploaded Successfully";
    }

    @Override
    public String bookRoom(Room room) {
        return null;
    }

}
