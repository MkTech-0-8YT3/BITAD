package com.bitad.reverse.EncoDeco.web;

import com.bitad.reverse.EncoDeco.utils.DataEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    private DataEncoder dataEncoder;

    @Autowired
    public BaseController(DataEncoder dataEncoder) {
        this.dataEncoder = dataEncoder;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test Endpoint";
    }

}
