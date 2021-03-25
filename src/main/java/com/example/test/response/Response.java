package com.example.test.response;

import java.beans.ConstructorProperties;
import lombok.Getter;

/**
 * Handles every response that is thrown by the server
 * @param <T>
 */
public class Response<T>
{
	@Getter private int statusCode;
	@Getter private String message;
	@Getter private T data;

    /**
     * Makes a constructor without data part
     * @param statusCode
     * @param message
     */
	@ConstructorProperties({"statusCode", "statusMessage"})
    public Response(int statusCode, String message) 
	{
        this.statusCode = statusCode;
        this.message 	= message;
    }

    /**
     * Makes a constructor with data part
     * @param statusCode
     * @param data
     * @param message
     */
	@ConstructorProperties({"statusCode", "data", "statusMessage"})
    public Response(int statusCode, T data, String message) 
	{
        this.statusCode 	= statusCode;
        this.data 			= data;
        this.message 		= message;
    }

}
