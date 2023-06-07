package com.hotelbooking.roomservice.service;

import com.hotelbooking.roomservice.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RoomService {
    Room addNewRoom(Room room, MultipartFile multipartFile);
    String bookRoom(Room room);
    String uploadImage(String path,MultipartFile multipartFile) throws IOException;
}
