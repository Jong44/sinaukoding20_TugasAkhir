package com.sinaukoding.Tanjung;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Response implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;

    String massage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer row;

    HttpStatus status;

    public Response(String massage, HttpStatus httpStatus){
        this.massage = massage;
        this.status = httpStatus;
    }

    public Response(Object object, String massage, HttpStatus httpStatus){
        this.data = object;
        this.massage = massage;
        this.status = httpStatus;
    }

    public Response(Object data, String massage, Integer row, HttpStatus httpStatus){
        this.data = data;
        this.massage = massage;
        this.row = row;
        this.status = httpStatus;
    }

}
