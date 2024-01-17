package cn.pku.timetracker.service.impl;

import cn.pku.timetracker.Utils.ResultUtils;
import cn.pku.timetracker.Utils.TokenUtils;
import cn.pku.timetracker.dao.UserDao;
import cn.pku.timetracker.entity.LoginVo;
import cn.pku.timetracker.entity.Result;
import cn.pku.timetracker.entity.User;
import cn.pku.timetracker.entity.dto.LoginDTO;
import cn.pku.timetracker.entity.dto.RegisterDTO;
import cn.pku.timetracker.entity.enums.ResultCodeEnum;
import cn.pku.timetracker.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    ResultCodeEnum resultCodeEnum;

    @Override
    public Result register(RegisterDTO registerDTO) {
        if (registerDTO.getPassword() == null || registerDTO.getUsername() == null || registerDTO.getUsername() == "" || registerDTO.getPassword() == ""){
            return ResultUtils.buildFailResult(resultCodeEnum.Null_Value_Fail);
        }
        if (registerDTO.getEmail() == null){
            return ResultUtils.buildFailResult(resultCodeEnum.Email_Null_Value_Fail);
        }
        if (userDao.existsByUsername(registerDTO.getUsername())){
            return ResultUtils.buildFailResult(resultCodeEnum.Username_Value_Fail);
        }
        if (userDao.existsByEmail(registerDTO.getEmail())){
            return ResultUtils.buildFailResult(resultCodeEnum.Email_Value_Fail);
        }
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        user.setEmail(registerDTO.getEmail());
        user.setCount(0);
        userDao.save(user);
        return ResultUtils.buildSuccessResult(user);
    }

    @Override
    public Result Login(LoginDTO loginDTO) {
        if (loginDTO.getPassword() == null || loginDTO.getUsername() == null || loginDTO.getUsername() == "" || loginDTO.getPassword() == ""){
            return ResultUtils.buildFailResult(resultCodeEnum.Null_Value_Fail);
        }
        if (userDao.existsByUsername(loginDTO.getUsername())==false){
            return ResultUtils.buildFailResult(resultCodeEnum.Not_Exist_Fail);
        }
        User user = userDao.findByUsername(loginDTO.getUsername());
        if(user.getCount() == null){
            user.setCount(0);
        }
        // 判断是否需要锁定账户
        if (user.getCount() >= 5
                && Duration.between(user.getLastLoginFailTime(), LocalDateTime.now()).toMinutes() < 3) {
            return ResultUtils.buildFailResult(resultCodeEnum.Account_Locked_Fail);
        }

        // 检查密码是否正确
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            // 登录失败，记录失败次数和时间
            user.setCount(user.getCount() + 1);
            user.setLastLoginFailTime(LocalDateTime.now());
            userDao.save(user);
            // 其他登录失败处理逻辑
            return ResultUtils.buildFailResult(resultCodeEnum.Password_error_Fail);
        }

        // 登录成功，清除登录失败计数
        user.setCount(0);
        user.setLastLoginFailTime(null);
        userDao.save(user);
        //生成token，在user实体类里面加一个属性token, public String token ,通过user将token传递出去
        String token = TokenUtils.genToken(user.getId().toString(),user.getPassword());
        LoginVo LoginVO = new LoginVo(user.getId(), user.getUsername(),user.getEmail(), token, "");
        return ResultUtils.buildSuccessResult(LoginVO);
    }


}
