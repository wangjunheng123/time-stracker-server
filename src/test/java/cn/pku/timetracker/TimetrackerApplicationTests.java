package cn.pku.timetracker;

import cn.pku.timetracker.dao.TagDao;
import cn.pku.timetracker.dao.TaskDao;
import cn.pku.timetracker.dao.UserDao;
import cn.pku.timetracker.entity.Task;
import cn.pku.timetracker.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class TimetrackerApplicationTests {

    @Autowired
    private TagDao tagDao;
    @Autowired
    private UserDao userDao;

    @Transactional
    @Test
    void contextLoads() {
        String Id = tagDao.getReferenceById("1").getUserId();
        System.out.println(userDao.getReferenceById(Id).toString());
    }

}
