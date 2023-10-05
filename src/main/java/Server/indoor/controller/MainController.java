package Server.indoor.controller;

import Server.indoor.domain.Student;
import Server.indoor.dto.ARObjectInfo;
import Server.indoor.dto.SpaceInfo;
import Server.indoor.repository.MyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/info")
public class MainController {

    private final MyRepository myRepository;

    @GetMapping("/download")
    public ResponseEntity<Resource> fileDownload(@RequestParam String file_name) throws IOException {
        Path filePath = Paths.get("/Users/jangjunseog/Downloads/"+ file_name + ".usdz");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(filePath.toString()));
        String fileName = file_name + ".usdz";
        log.info("Success download input excel file : " + filePath);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .cacheControl(CacheControl.noCache())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .body(resource);
    }
}
