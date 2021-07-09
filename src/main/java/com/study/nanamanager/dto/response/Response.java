package com.study.nanamanager.dto.response;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Samuel
 * @param <Data>
 */

@Getter
@Setter
@AllArgsConstructor
public class Response<Data, Error> {
    
    private Data data;
    private Optional<Error> error;
    private String message;
    private HttpStatus status;
}
