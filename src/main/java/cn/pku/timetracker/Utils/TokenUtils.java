package cn.pku.timetracker.Utils;

import cn.pku.timetracker.dao.UserDao;
import cn.pku.timetracker.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Component
public class TokenUtils {

    private static UserDao staticUserDao;

    @Autowired
    UserDao userDao;

    @PostConstruct
    public void setUserService() {
        staticUserDao = userDao;
    }

    /**
     * 2、生成token
     *
     * @return
     */
    public static String genToken(String userId, String sign) {
        return JWT.create()
                .withAudience(userId)
                .withExpiresAt(Date.from(LocalDateTime.now().plusMonths(1).atZone(ZoneId.systemDefault()).toInstant()))
                .sign(Algorithm.HMAC256(sign));
    }

        /**
         * 3、获取当前登录的用户信息
         *只要当前请求有token我就可以通过token去拿到当前请求的用户的所有的信息（是从数据库里面查出来的 ）
         * @return user对象
         */
    public static Optional<User> getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (token == null || token == "") {
                String userId = JWT.decode(token).getAudience().get(0);
                return staticUserDao.findById(userId);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
