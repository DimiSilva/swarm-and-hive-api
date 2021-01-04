package com.eijteam.swarm.and.hive.modules.user.exceptions;

public class AlreadyRegisteredUserException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AlreadyRegisteredUserException() {
        super ("User already registered ");
    }
}
