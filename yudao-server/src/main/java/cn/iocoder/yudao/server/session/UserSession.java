package cn.iocoder.yudao.server.session;

import cn.iocoder.yudao.server.model.IMSessionInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserSession extends IMSessionInfo {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    private Long userId;
}
