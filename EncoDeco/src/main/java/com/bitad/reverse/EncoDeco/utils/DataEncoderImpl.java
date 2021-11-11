package com.bitad.reverse.EncoDeco.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
class DataEncoderImpl implements DataEncoder {
    private static String NOT_ASCII_ERROR = "Given data is not clear ASCII text!";

    private StringValidator stringValidator;

    @Autowired
    public DataEncoderImpl(StringValidator stringValidator) {
        this.stringValidator = stringValidator;
    }

    @Override
    public String base64Encode(String data) {
        byte[] inputBytes = data.getBytes();
        return Base64.getEncoder().encodeToString(inputBytes);
    }

    @Override
    public String base64Encode(String data, int iterations) {
        String result = base64Encode(data);
        for (int i = 1; i < iterations; i++) {
            result = base64Encode(result);
        }
        return result;
    }

    @Override
    public String getByteString(String data) {
        if (!stringValidator.isAscii(data)) {
            return NOT_ASCII_ERROR;
        }
        return stringToHexByteString(data);
    }

    private String stringToHexByteString(String inputData) {
        StringBuilder stringBuilder = new StringBuilder();
        byte[] inputBytes = inputData.getBytes();
        for (byte inputByte : inputBytes) {
            stringBuilder.append("\\0x").append(String.format("%02X", inputByte));
        }
        return stringBuilder.toString();
    }

}
