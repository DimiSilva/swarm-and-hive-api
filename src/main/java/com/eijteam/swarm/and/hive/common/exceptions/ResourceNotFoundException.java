package com.eijteam.swarm.and.hive.common.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super ("Resource not found. Id " + id);
    }
}
