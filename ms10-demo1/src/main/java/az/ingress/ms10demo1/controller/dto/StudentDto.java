package az.ingress.ms10demo1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class StudentDto {

    private Long age;

    private String firstName;

    private String lastName;

    //This is @AllArgsConstructor
    //    public StudentDto(String firstName, String lastName) {
    //        this.firstName = firstName;
    //        this.lastName = lastName;
    //    }


}
