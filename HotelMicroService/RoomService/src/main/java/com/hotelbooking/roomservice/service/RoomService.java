package com.hotelbooking.roomservice.service;

import com.hotelbooking.roomservice.model.Room;
import org.springframework.web.multipart.MultipartFile;

public interface RoomService {
    Room addNewRoom(Room room, MultipartFile multipartFile);
    String uploadImage(MultipartFile multipartFile);
}
