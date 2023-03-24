package com.leopard.producer.config;

import com.leopard.utils.constant.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常处理配置
 *
 * @author EternalRay
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandleConf {


    /**
     * 系统异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object systemException(Exception e) {
        log.info(" e -> {}" , e);
        return Response.error("11111111", "222222222");
    }
}
