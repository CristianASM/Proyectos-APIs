package com.api.exceptions.Dto;

import com.api.exceptions.Model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @AllArgsConstructor @NoArgsConstructor
public class UserDTO{
    private long id;
    private String name;
    private String lastName;
    private Gender gender;

}
