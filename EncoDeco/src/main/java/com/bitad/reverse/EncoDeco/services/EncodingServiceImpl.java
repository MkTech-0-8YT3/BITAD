package com.bitad.reverse.EncoDeco.services;

import com.bitad.reverse.EncoDeco.utils.DataEncoder;
import com.bitad.reverse.EncoDeco.web.models.EncodingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncodingServiceImpl implements EncodingService {
    private DataEncoder dataEncoder;

    @Autowired
    public EncodingServiceImpl(DataEncoder dataEncoder) {
        this.dataEncoder = dataEncoder;
    }

    @Override
    public String encodeData(String inputData, EncodingType encodingType, int iterations) {
        if(encodingType == EncodingType.ascii_hex) {
            return dataEncoder.getByteString(inputData);
        } else {
            return iterations == 0 ? inputData : dataEncoder.base64Encode(inputData, iterations);
        }
    }
}
