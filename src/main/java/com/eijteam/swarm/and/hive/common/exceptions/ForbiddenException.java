package com.eijteam.swarm.and.hive.common.exceptions;

public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ForbiddenException() {
        super ("Forbidden");
    }
}
