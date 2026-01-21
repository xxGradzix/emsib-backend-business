package com.emsib.emsib_backend_business.security.securitymodule.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthLogger {

    private static final Logger log =
            LoggerFactory.getLogger(SimpleAuthLogger.class);

    public void loginAttempt(String username) {
        log.info("LOGIN ATTEMPT | username={}", username);
    }

    public void loginSuccess(String username) {
        log.info("LOGIN SUCCESS | username={}", username);
    }

    public void loginFailure(String username) {
        log.warn("LOGIN FAILURE | username={}", username);
    }
}
