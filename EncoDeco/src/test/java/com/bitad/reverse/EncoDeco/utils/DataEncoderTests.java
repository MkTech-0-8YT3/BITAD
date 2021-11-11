package com.bitad.reverse.EncoDeco.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataEncoderTests {
    private static String TEST_VALUE = "test";
    private static String B64_TEST_VALUE = "dGVzdA==";
    private static String DOUBLE_B64_TEST_VALUE = "ZEdWemRBPT0=";
    private static String TRIPLE_B64_TEST_VALUE = "WkVkV2VtUkJQVDA9";
    private static String HEX_BYTES_TEST_VALUE = "\\0x74\\0x65\\0x73\\0x74";

    @Mock
    StringValidator stringValidatorMock;

    @BeforeEach
    void init() {
        Mockito.lenient().when(stringValidatorMock.isAscii(Mockito.anyString())).thenReturn(true);
    }

    @Test
    void properly_encode_with_base64() {
        DataEncoder objectUnderTest = new DataEncoderImpl(stringValidatorMock);
        String result = objectUnderTest.base64Encode(TEST_VALUE);
        Assertions.assertEquals(B64_TEST_VALUE, result);
    }

    @Test
    void double_base64_encoding_validation() {
        DataEncoder objectUnderTest = new DataEncoderImpl(stringValidatorMock);
        String result = objectUnderTest.base64Encode(TEST_VALUE, 2);
        Assertions.assertEquals(DOUBLE_B64_TEST_VALUE, result);
    }

    @Test
    void triple_base64_encoding_validation() {
        DataEncoder objectUnderTest = new DataEncoderImpl(stringValidatorMock);
        String result = objectUnderTest.base64Encode(TEST_VALUE, 3);
        Assertions.assertEquals(TRIPLE_B64_TEST_VALUE, result);
    }

    @Test
    void can_obtain_test_bytes_in_hex() {
        DataEncoder objectUnderTest = new DataEncoderImpl(stringValidatorMock);
        String result = objectUnderTest.getByteString(TEST_VALUE);
        Assertions.assertEquals(HEX_BYTES_TEST_VALUE, result);
    }
}
