package com.hotelbooking.roomservice.service;

import lombok.RequiredArgsConstructor;
import com.hotelbooking.roomservice.model.Room;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.hotelbooking.roomservice.repo.RoomRepository;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;
    @Override
    public Room addNewRoom(Room room, MultipartFile multipartFile) {
        room.setRoomImage(multipartFile.getName());
        return roomRepository.save(room);
    }
    public String uploadImage(MultipartFile multipartFile){
        Room room=Room.builder()
                .roomId("klalalla")
                .roomStatus("Available")
                .roomName("Deluxe")
                .price("4000")
                .roomImage(multipartFile.getOriginalFilename())
                .build();
        return "Image Uploaded Successfully";
    }
}
