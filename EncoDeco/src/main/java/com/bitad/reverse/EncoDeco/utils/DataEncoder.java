package com.bitad.reverse.EncoDeco.utils;

public interface DataEncoder {
    String base64Encode(String data);

    String base64Encode(String data, int iterations);

    String getByteString(String data);
}
