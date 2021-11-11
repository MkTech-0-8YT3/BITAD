package com.bitad.reverse.EncoDeco.services;

import com.bitad.reverse.EncoDeco.web.models.EncodingType;

public interface EncodingService {
    String encodeData(String inputData, EncodingType encodingType, int iterations);
}
