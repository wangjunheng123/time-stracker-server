package cn.pku.timetracker.rest;

import cn.pku.timetracker.entity.Const;
import cn.pku.timetracker.entity.Result;
import cn.pku.timetracker.entity.dto.LoginDTO;
import cn.pku.timetracker.service.IUserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public Result userLogin(@RequestBody LoginDTO loginDTO, HttpSession session){
        Result result = userService.Login(loginDTO);

        return result;
    }

}
