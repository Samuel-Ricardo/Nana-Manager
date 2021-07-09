package com.study.nanamanager.dto.response;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Samuel
 * @param <Data>
 */

//@Getter
//@Setter
//@AllArgsConstructor
public class Response<Data> {
    
    private Data data;
//    private Optional<ErrorType> error;
    private String message;
    private HttpStatus status;

    public Response(Data data, String message, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
