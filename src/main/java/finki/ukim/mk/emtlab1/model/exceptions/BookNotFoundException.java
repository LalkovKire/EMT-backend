package finki.ukim.mk.emtlab1.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super(String.format("The book with id: %d was not found",id));
    }
}
