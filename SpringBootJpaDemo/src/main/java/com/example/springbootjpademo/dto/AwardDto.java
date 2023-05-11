package com.example.springbootjpademo.dto;

import com.example.springbootjpademo.entity.Awards;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AwardDto implements Serializable {
    private List<Awards> award_name;
}
