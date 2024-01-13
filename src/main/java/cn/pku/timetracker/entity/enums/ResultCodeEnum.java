package cn.pku.timetracker.entity.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    Null_Value_Fail(1,"账号密码不能为空"),
    Not_Exist_Fail(2,"账号不存在"),
    Password_error_Fail(3,"密码错误"),
    Account_Locked_Fail(4,"账号被锁定，稍后尝试"),
    No_Login_Fail(401, "请登录");

    private Boolean success;

    private Integer code;

    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    ResultCodeEnum(Integer code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }
}
