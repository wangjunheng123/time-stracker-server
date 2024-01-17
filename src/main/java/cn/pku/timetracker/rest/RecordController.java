package cn.pku.timetracker.rest;

import cn.pku.timetracker.entity.Result;
import cn.pku.timetracker.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    @Autowired
    private ITaskService taskService;

    private Result getTaskByTaskSetId(String TaskSet){

    }
}
