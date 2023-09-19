package Server.indoor.controller;

import Server.indoor.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

@Slf4j
@RestController
@RequestMapping("/info")
public class MainController {

    @GetMapping("/test")
    public Student test() {
        return new Student("jang", 12);
    }

    @GetMapping("/matrix")
    public String mat() {
        Stack st = new Stack();

        return "1.0 0.0 0.0 0.0 2.0 0.0 0.0 0.0 3.0 0.0 0.0 0.0 4.0 0.0 0.0 0.0";
    }

}
