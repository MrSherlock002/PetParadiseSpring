package com.pet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// sending custom response for requested source
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Medicine Not Found")
public class MedicineNotFoundException extends Exception {

    public MedicineNotFoundException(String message) {
        super(message);
    }

}
