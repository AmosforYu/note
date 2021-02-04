package com.yyb.common.dtos.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author Yamos
 * @description GlobalControllerAdvice 全局异常统一处理，其他模块依赖该模块实现异常统一处理两种方式：
 *  ①当前类不添加@ControllerAdvice注解，仅在该类中定义处理函数，其他模块依赖该模块并继承该类，在子类加上@ControllerAdvice注解即可
 *  ②当前类添加@ControllerAdvice注解，在其他模块通过在启动类上使用@Import(GlobalControllerAdvice.class)注解即可
 * @date 2020/12/14 0014 12:15
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerAdvice.class);

    /* 自定义异常::统一处理 */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleMyException(MyException e) {
        System.out.println("》》》1.自定义异常::统一处理《《《");
        LOGGER.info("》》》1.自定义异常::统一处理《《《");
        return new ResponseEntity<>(new ErrorResponse(e.getError(), e.getDesc()), HttpStatus.BAD_REQUEST);
    }

    /* 参数异常::统一处理 */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentConversionNotSupportedException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleParamException(Exception e) {
        System.out.println("》》》2.参数异常::统一处理《《《");
        LOGGER.info("》》》2.参数异常::统一处理《《《");
        return new ResponseEntity<>(new ErrorResponse(Error.PARAM_ERROR, e.getLocalizedMessage()),
                HttpStatus.BAD_REQUEST);
    }

    /* 请求方式异常::统一处理 */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleMethodException(Exception e) {
        System.out.println("》》》3.请求方式异常::统一处理《《《");
        LOGGER.info("》》》3.请求方式异常::统一处理《《《");
        return new ResponseEntity<>(new ErrorResponse(Error.METHOD_NOT_ALLOWED, e.getLocalizedMessage()),
                HttpStatus.METHOD_NOT_ALLOWED);
    }


}
