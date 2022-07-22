package com.mk.web.action;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class DemoAction {

   @GetMapping("/web/{UUID}")
    public String sys(@PathVariable("UUID") String UUID, HttpServletResponse response){
       response.setHeader("Access-Control-Allow-Origin", "*");
       response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");


       return UUID;
   }

}
