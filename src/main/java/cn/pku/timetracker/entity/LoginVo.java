package cn.pku.timetracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo implements Serializable {
    private static final long serialVersionUID = -2871290869851374421L;

    private String id;

    private String username;

    private String email;

    private String token;

    private String origin;
}
