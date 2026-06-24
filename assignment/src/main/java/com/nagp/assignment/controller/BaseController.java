package com.nagp.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BaseController {

  @GetMapping("/")
  public Map<String, String> root() {
    return Map.of(
        "status", "UP",
        "application", "assignment"
    );
  }

}
