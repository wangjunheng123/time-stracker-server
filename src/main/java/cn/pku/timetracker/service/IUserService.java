package cn.pku.timetracker.service;

import cn.pku.timetracker.entity.Result;
import cn.pku.timetracker.entity.dto.LoginDTO;
import cn.pku.timetracker.entity.dto.RegisterDTO;


public interface IUserService {
    public Result register(RegisterDTO registerDTO);

    public Result Login(LoginDTO loginDTO);

}
