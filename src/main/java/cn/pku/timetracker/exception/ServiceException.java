package cn.pku.timetracker.exception;

import cn.pku.timetracker.entity.enums.ResultCodeEnum;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException{

    private int code;

    public ServiceException(String msg){
        super(msg);
        this.code = 500;
    }

    public ServiceException(int code,String msg){
        super(msg);
        this.code = code;
    }

}
