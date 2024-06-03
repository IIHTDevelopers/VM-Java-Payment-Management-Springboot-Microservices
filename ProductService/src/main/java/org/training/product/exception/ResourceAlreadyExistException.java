package org.training.product.exception;

public class ResourceAlreadyExistException extends GlobalException {

    public ResourceAlreadyExistException() {
        super("Resource already exist!!", GlobalErrorCode.CONFLICT);
    }

    public ResourceAlreadyExistException(String message) {
        super(message, GlobalErrorCode.CONFLICT);
    }

}
