package com.piotrblachnio.reddit.exceptions;

import com.piotrblachnio.reddit.constants.Exception;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PostNotFoundException extends BaseException {
    private String message = "Post with the provided id not found";
    private Integer id = Exception.POST_NOT_FOUND;
    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;
}
