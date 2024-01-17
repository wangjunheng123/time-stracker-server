package cn.pku.timetracker.rest;

import cn.pku.timetracker.entity.Result;
import cn.pku.timetracker.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RecordController {

    @Autowired
    private IRecordService recordService;


}
