package cn.pku.timetracker.Utils;

import cn.pku.timetracker.entity.Result;
import cn.pku.timetracker.entity.enums.ResultCodeEnum;

public class ResultUtils {

    private ResultUtils() {

    }

    public static Result buildSuccessResult() {
        return buildSuccessResult("");
    }

    public static Result buildSuccessResult(Object data) {
        return buildResult(0, "success", data);
    }

    public static Result buildFailResult(int code, String message) {
        return buildResult(code, message, "");
    }

    public static Result buildFailResult(ResultCodeEnum resultCodeEnum) {
        return buildResult(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), "");
    }

    public static Result buildFailResult(ResultCodeEnum resultCodeEnum, Object data) {
        return buildResult(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), data);
    }

    public static Result buildResult(int code, String message, Object data) {
        Result result = new Result(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

}
