package cn.pku.timetracker.service;

import cn.pku.timetracker.entity.Result;

public  interface ITaskService {

    public Result getTaskByTaskSetId(String taskSetId);
}
