package com.k2m.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/logger")
public class LogController {

    @Autowired
    LogService logService;


    @ResponseBody
    @RequestMapping(path="/log", method=RequestMethod.POST)
    public ResponseEntity<String> log(@RequestBody String request) {
        System.out.println("success call");
        try {
            logService.logMessage(request);
            return ResponseEntity.ok("Success");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
