package cn.pku.timetracker.service;

import cn.pku.timetracker.entity.Result;

public  interface IRecordService {

    public Result getTaskByTaskSetId(String taskSetId);
}
