package com.bitad.reverse.EncoDeco.web;

import com.bitad.reverse.EncoDeco.services.EncodingService;
import com.bitad.reverse.EncoDeco.utils.DataEncoder;
import com.bitad.reverse.EncoDeco.web.models.EncodeDataRequestModel;
import com.bitad.reverse.EncoDeco.web.models.EncodingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    private EncodingService encodingService;

    @Autowired
    public BaseController(EncodingService encodingService) {
        this.encodingService = encodingService;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test Endpoint";
    }

    //Example: curl -X POST -H "Content-Type:application/json" -d "{\"dataToEncode\":\"test\",\"encodingType\":\"base64\",\"iterations\":3}" http://127.0.0.1:8080/encode

    @PostMapping("/encode")
    public String encodeData(@RequestBody EncodeDataRequestModel encodeDataRequestModel) {
        if(encodeDataRequestModel.isValid()) {
            EncodingType selectedEncoding = EncodingType.valueOf(encodeDataRequestModel.getEncodingType());
            return encodingService.encodeData(encodeDataRequestModel.getDataToEncode(),
                    selectedEncoding, encodeDataRequestModel.getIterations());
        } else {
            return "Invalid data provided!";
        }
    }
}
