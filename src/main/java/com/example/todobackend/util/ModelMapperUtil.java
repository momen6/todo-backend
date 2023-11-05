package com.example.todobackend.util;

import org.modelmapper.ModelMapper;


/**
 * @author Momen Magdy
 * this is a singleton class allowing only a single instance of ModelMapper
 * to be created and accessed
 */
public class ModelMapperUtil {

    /**
     * the single instance of ModelMapper
     */
    private static final ModelMapper modelMapper = new ModelMapper();

    /**
     * Retrieves the shared instance of ModelMapper
     * @return instance of ModelMapper
     */
    public static ModelMapper MAPPER(){
        return modelMapper;
    }
}
