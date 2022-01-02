package controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderControllerTest{
    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp(){
        placeOrderController = new PlaceOrderController();
    }

    @AfterEach
    void tearDown(){
    }

    @ParameterizedTest
    @CsvSource({
		"0123456789,true",
		"01234,false",
		"abcd123,false",
		"123475679810,false"
	})
    void validatePhoneNumber(String phone, boolean expect){
        boolean isValid = placeOrderController.validatePhoneNumber(phone);

        assertEquals(expect, isValid);
    }

    @ParameterizedTest
    @CsvSource({
		"hanoi,true",
		"so hai ba truung ha noi,true",
		"hanoi@#$,false",
		",false",
	})
    void validateAddress(String address, boolean expect){
       boolean isValid = placeOrderController.validateAddress(address);
       assertEquals(expect, isValid);
    }

    @ParameterizedTest
    @CsvSource({
		"Hung Nguyen,true",
		"Hungnq,true",
		"Hai1234,false",
		",false",
		"Anhtran!#$$,false"
	})
    void validateName(String name, boolean expect){
        boolean isValid = placeOrderController.validateName(name);
        assertEquals(expect, isValid);
    }

}