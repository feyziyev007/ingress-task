package az.ingress.ms10demo1.controller;

import az.ingress.ms10demo1.controller.dto.StudentDto;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController(value = "ms10Controller")
@RequestMapping("/")
public class HelloController {

    //query params
    @GetMapping("/en2")
    public String sayHello2(@RequestParam("name") String studentName,
                            @RequestParam String lastName) {
        return "Hello, " + studentName + " " + lastName;
    }

    //object as query param
    @GetMapping("/en")
    public String sayHello(StudentDto studentDto) {
        return "Hello Spring " + studentDto;
    }

    //request headers
    @GetMapping("/az")
    public String sayHelloAz(
            @RequestHeader("course") String course,
            @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String lang) {
        return "Salam Dunya " + lang + "  "+course;
    }

    //path variable
    @GetMapping("/age/{age}/size/{size}")
    public String sayHelloAge(@PathVariable Long age,
                              @PathVariable Long size) {
        return "Salam Dunya " + age + " " + size;
    }

}
