package cn.iocoder.yudao.server.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.server.config.JwtProperties;
import cn.iocoder.yudao.server.controller.LoginController;
import cn.iocoder.yudao.server.enums.ResultCode;
import cn.iocoder.yudao.server.exception.GlobalException;
import cn.iocoder.yudao.server.session.UserSession;
import cn.iocoder.yudao.server.util.JwtUtil;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@AllArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProperties jwtProperties;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod) || handler instanceof LoginController) {
            return true;
        }
//        //从 http 请求头中取出 token
        String token = request.getHeader("accessToken");
//        if (StrUtil.isEmpty(token)) {
//            log.error("未登陆，url:{}", request.getRequestURI());
//            throw new GlobalException(String.valueOf(ResultCode.NO_LOGIN));
//        }
        //验证 token
//        if (!JwtUtil.checkSign(token, jwtProperties.getAccessTokenSecret())) {
//            log.error("token已失效，url:{}", request.getRequestURI());
//            throw new GlobalException(ResultCode.INVALID_TOKEN);
//        }

        if (StringUtils.isNotEmpty(token)){
            // 存放session
            String strJson = JwtUtil.getInfo(token);
            UserSession userSession = JSON.parseObject(strJson, UserSession.class);
            request.setAttribute("session", userSession);
        }
        return true;
    }
}
