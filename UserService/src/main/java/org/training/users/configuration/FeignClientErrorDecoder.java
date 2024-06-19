package org.training.users.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import org.apache.commons.io.IOUtils;
import org.training.users.exception.GlobalException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


public class FeignClientErrorDecoder implements ErrorDecoder {

    /**
     * Decodes the HTTP response and returns an exception if necessary.
     *
     * @param s        The string representation of the response body.
     * @param response The HTTP response object.
     * @return An exception object if necessary, or null if no exception is thrown.
     */
    @Override
    public Exception decode(String s, Response response) {

        GlobalException globalException = extractGlobalException(response);

        switch (response.status()) {
            case 400 -> {
                System.out.printf(globalException.getErrorCode() + " - " + globalException.getMessage());
                return globalException;
            }
            default -> {
                System.out.printf("general exception occurred");
                return new Exception("general exception occurred");
            }
        }
    }

    /**
     * Extracts a GlobalException object from a Response object
     *
     * @param response The Response object to extract the GlobalException from
     * @return The extracted GlobalException object, or null if extraction fails
     */
    private GlobalException extractGlobalException(Response response) {

        GlobalException globalException = null;
        Reader reader = null;

        try {
            reader = response.body().asReader(StandardCharsets.UTF_8);
            String result = IOUtils.toString(reader);
            System.out.printf(result);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            globalException = mapper.readValue(result, GlobalException.class);
            System.out.printf(globalException.toString());
        } catch (IOException e) {
            System.out.printf("IO Exception while reading the global exception", e);
        } finally {
            if (!Objects.isNull(reader)) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.printf("IO Exception while closing the global exception", e);
                }
            }
        }
        return globalException;
    }
}
