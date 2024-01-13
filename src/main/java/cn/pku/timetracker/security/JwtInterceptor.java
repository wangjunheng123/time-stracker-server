package cn.pku.timetracker.security;

import cn.pku.timetracker.dao.UserDao;
import cn.pku.timetracker.entity.User;
import cn.pku.timetracker.entity.enums.ResultCodeEnum;
import cn.pku.timetracker.exception.ServiceException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private UserDao userDao;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = request.getHeader("token");
        if (token == null || token == "") {
            token = request.getParameter("token");
        }

        // 如果不是映射到方法直接通过 配合自定义注解使用
        if (handler instanceof HandlerMethod) {
            AuthAccess annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthAccess.class);
            if (annotation != null) {
                return true;
            }
        }

        if (token == null || token == "") {
            throw new ServiceException(401, "请登录");
        }
        String userId;

        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException(401, "请登录");
        }
        User user = userDao.findByUserId(userId);
        if (user == null) {
            throw new ServiceException(401, "请登录");
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(401, "请登录");
        }
        return true;
    }
}
