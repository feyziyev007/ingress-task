package az.ingress.ms10demo1.controller;

import az.ingress.ms10demo1.controller.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return new StudentDto(1l, "Tural", "Memmedov");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        System.out.println("update student with id " + id + " to " + studentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        System.out.println("deleting student with id " + id);
    }

    @GetMapping("/list")
    public List<StudentDto> getStudent() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++)
            list.add(new StudentDto(1l, "Tural", "Memmedov"));
        return list;
    }
}
