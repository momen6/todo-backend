package com.example.todobackend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TodoLogger {

    private static final Logger todoLogger = LoggerFactory.getLogger(TodoLogger.class);

    public static Logger LOGGER() {
        return todoLogger;
    }
}
