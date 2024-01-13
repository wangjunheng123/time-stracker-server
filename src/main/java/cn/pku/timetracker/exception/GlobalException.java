package cn.pku.timetracker.exception;

import cn.pku.timetracker.Utils.ResultUtils;
import cn.pku.timetracker.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    // 监听异常抛出
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result serviceException(ServiceException e){
        return ResultUtils.buildFailResult(e.getCode(),e.getMessage());
    }
}


