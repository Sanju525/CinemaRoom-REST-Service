package com.sanjay.cinemaroom.exceptions;

public class ExceptionBody {
    private String error;

    public ExceptionBody() {
    }

    public ExceptionBody(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
