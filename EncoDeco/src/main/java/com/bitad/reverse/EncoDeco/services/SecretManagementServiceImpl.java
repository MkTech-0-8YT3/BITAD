package com.bitad.reverse.EncoDeco.services;

import com.bitad.reverse.EncoDeco.web.models.EncodingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class SecretManagementServiceImpl implements SecretManagementService {
    private static String FLAG = "CTF{B1T4D_J4VA_R3V3R$ER}";
    private static int RAND_BOUND = 50;

    private EncodingService encodingService;

    @Autowired
    public SecretManagementServiceImpl(EncodingService encodingService) {
        this.encodingService = encodingService;
    }

    @Override
    public String getFlag() {
        return FLAG;
    }

    @Override
    public String getEncodedFlag() {
        SecureRandom secureRandom = new SecureRandom();
        int iterations = secureRandom.nextInt(RAND_BOUND);
        while (iterations < 20) {
            iterations = secureRandom.nextInt(RAND_BOUND);
        }
        return encodingService.encodeData(FLAG, EncodingType.base64, iterations);
    }
}
