package com.expert_coder.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
