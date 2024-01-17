package cn.pku.timetracker;

import cn.pku.timetracker.dao.TaskSetDao;
import cn.pku.timetracker.dao.UserDao;
import cn.pku.timetracker.entity.Result;
import cn.pku.timetracker.entity.User;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
import cn.pku.timetracker.entity.dto.LoginDTO;
import cn.pku.timetracker.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TimetrackerApplicationTests {

//    @Autowired
//    private TaskSetDao taskSetDao;
    @Autowired
    private UserDao userDao;

    @Autowired
    private IUserService userService;
//    @Autowired
//    private TagDao tagDao;

    @Transactional
    @Rollback(false)
    @Test
    void contextLoads() {
        User user = new User();
        user.setEmail("123@qq.com");
        user.setUsername("cedric");
        user.setPassword("wjhwjh");
        userDao.save(user);
        System.out.println(user);
    }

    @Test
    public void Login(){
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("cedric");
        loginDTO.setPassword("wjhwjh");
        Result result = userService.Login(loginDTO);

        System.out.println(result);
    }

}
