package com.eijteam.swarm.and.hive.modules.user.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super ("User not found ");
    }
}
