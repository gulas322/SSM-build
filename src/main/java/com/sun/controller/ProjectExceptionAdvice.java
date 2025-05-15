package com.sun.controller;

import com.sun.exception.BusinessException;
import com.sun.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// 统一处理异常,代表这是处理rest风格的异常
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员，ex对象发给开发人员
        return new Result(ex.getCode(), "null",ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex) {
        // 业务层面的err就不用发给其他人了，只需要开发人员自己来做处理
        return new Result(ex.getCode(), "null",ex.getMessage());
    }



    // 下面这个是覆盖所有各种各样类型的异常的处理，所以不能删，
    // 上面的代码是专门针对system或者是业务上的异常做特殊的处理
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        // 这里是将所有的异常拦截，然后统一处理，最后返回统一的result格式给到前端
        // 注意返回的是Result类型
        System.out.println("统一异常处理");
        ex.printStackTrace();
        return new Result(Code.SYSTEM_UNKNOWN_ERR, "null","系统繁忙请稍后再试");
    }
}
