package com.study.nanamanager.dto.response;

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
public class Response<Data> {
    
    private Data data;
    private String message;
    private HttpStatus status;
}
