package br.com.michael.agendatelefonica.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacaoDto> handle(MethodArgumentNotValidException exception) {
        List<ErroValidacaoDto> errosValidacao = new ArrayList<>();
        List<FieldError> camposComErro = exception.getBindingResult().getFieldErrors();
        camposComErro.forEach(campoComErro -> {
            String mensagem = messageSource.getMessage(campoComErro, LocaleContextHolder.getLocale());
            ErroValidacaoDto erro = new ErroValidacaoDto(campoComErro.getField(), mensagem);
            errosValidacao.add(erro);
        });
        return errosValidacao;
    }

}
