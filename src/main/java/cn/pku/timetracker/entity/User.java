package cn.pku.timetracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity<User> implements Serializable {
    private static final long serialVersionUID = -1459660400121009230L;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nikname")
    private String nikname;

    /*
    记录登陆失败次数
     */
    @Column(name = "count")
    private Integer count;

    @Column(name = "last_Login_fail_time", columnDefinition = "int default 0")
    private LocalDateTime lastLoginFailTime;

}
