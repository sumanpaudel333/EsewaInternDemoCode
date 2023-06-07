package com.hotelbooking.roomservice.controller;

import com.hotelbooking.roomservice.model.Room;
import com.hotelbooking.roomservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    @PostMapping("/add")
    public Room addNewRoom(@RequestBody Room room, @RequestParam("file") MultipartFile multipartFile){
    return roomService.addNewRoom(room,multipartFile);
    }
}
