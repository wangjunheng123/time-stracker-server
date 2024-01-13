package cn.pku.timetracker.service;

import cn.pku.timetracker.entity.Result;
import cn.pku.timetracker.entity.dto.LoginDTO;


public interface IUserService {


    public Result Login(LoginDTO loginDTO);

}
