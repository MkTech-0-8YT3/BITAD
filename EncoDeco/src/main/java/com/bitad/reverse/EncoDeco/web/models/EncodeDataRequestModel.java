package com.bitad.reverse.EncoDeco.web.models;

import java.util.ArrayList;
import java.util.List;

public class EncodeDataRequestModel {
    private String dataToEncode;
    private String encodingType;
    private int iterations;

    public String getDataToEncode() {
        return dataToEncode;
    }

    public void setDataToEncode(String toEncode) {
        this.dataToEncode = toEncode;
    }

    public String getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public boolean isValid() {
        List<String> availableEncodingTypes = new ArrayList<>();
        for (EncodingType encodingType: EncodingType.values()) {
            availableEncodingTypes.add(encodingType.name());
        }
        return this.iterations >= 0 && availableEncodingTypes.contains(this.encodingType);
    }
}
