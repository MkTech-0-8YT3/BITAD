package com.bitad.reverse.EncoDeco.web;

import com.bitad.reverse.EncoDeco.services.EncodingService;
import com.bitad.reverse.EncoDeco.services.SecretManagementService;
import com.bitad.reverse.EncoDeco.web.models.EncodeDataRequestModel;
import com.bitad.reverse.EncoDeco.web.models.EncodingType;
import com.bitad.reverse.EncoDeco.web.models.SecretKeyRequestModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRestController {
    private EncodingService encodingService;
    private SecretManagementService secretManagementService;

    @Value("${secret.key}")
    private String secretKey;

    public BaseRestController(EncodingService encodingService, SecretManagementService secretManagementService) {
        this.encodingService = encodingService;
        this.secretManagementService = secretManagementService;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test Endpoint";
    }

    //Example: curl -X POST -H "Content-Type:application/json" -d "{\"dataToEncode\":\"test\",\"encodingType\":\"base64\",\"iterations\":3}" http://127.0.0.1:8080/encode

    @PostMapping("/encode")
    public String encodeData(@RequestBody EncodeDataRequestModel encodeDataRequestModel) {
        if (encodeDataRequestModel.isValid()) {
            EncodingType selectedEncoding = EncodingType.valueOf(encodeDataRequestModel.getEncodingType());
            return encodingService.encodeData(encodeDataRequestModel.getDataToEncode(),
                    selectedEncoding, encodeDataRequestModel.getIterations());
        } else {
            return "Invalid data provided!";
        }
    }

    @GetMapping("/flag")
    public String getFlag() {
        return secretManagementService.getEncodedFlag();
    }

    @PostMapping("/unlock")
    public String getClearFlag(@RequestBody SecretKeyRequestModel secretKeyRequestModel) {
        return secretKey.equals(secretKeyRequestModel.getKey()) ? secretManagementService.getFlag() : "Key not valid!";
    }
}
