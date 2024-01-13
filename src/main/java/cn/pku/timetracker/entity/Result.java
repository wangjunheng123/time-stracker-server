package cn.pku.timetracker.entity;
import lombok.Data;

@Data
public class Result {
    public Result(){};
    public Result(int code){
        this.code = code;
    }

    private int code;

    private String message;

    private Object data;

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
