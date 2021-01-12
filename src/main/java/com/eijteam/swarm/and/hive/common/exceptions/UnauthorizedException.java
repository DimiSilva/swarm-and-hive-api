package com.eijteam.swarm.and.hive.common.exceptions;

public class UnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnauthorizedException() {
        super ("Unauthorized");
    }
}
