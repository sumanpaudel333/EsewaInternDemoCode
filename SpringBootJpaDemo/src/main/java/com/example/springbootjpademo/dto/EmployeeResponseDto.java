package com.example.springbootjpademo.dto;

import com.example.springbootjpademo.entity.Awards;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto implements Serializable {
    private String name;
    private AddressDto address;
    private AwardDto awardsList;
}
