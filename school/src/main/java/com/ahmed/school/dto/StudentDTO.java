package com.ahmed.school.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private String firstname;
    private String lastname;
    private String email;
}