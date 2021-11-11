package com.bitad.reverse.EncoDeco.utils;

import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
class StringValidatorImpl implements StringValidator {
    private static String US_ASCII = "US-ASCII";

    @Override
    public boolean isAscii(String inputData) {
        return Charset.forName(US_ASCII).newEncoder().canEncode(inputData);
    }
}
