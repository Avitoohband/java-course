package app.core.com.company.exceptions;

public class CompanySystemException extends Exception{
    public CompanySystemException() {
    }

    public CompanySystemException(String message) {
        super(message);
    }

    public CompanySystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanySystemException(Throwable cause) {
        super(cause);
    }

    public CompanySystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
