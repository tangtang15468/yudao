package cn.iocoder.yudao.server.dto;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.module.system.dal.dataobject.notify.NotifyTemplateDO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class NotifyMessageDto  {

    private Long noticeId;
    /**
     * 用户编号
     *
     * 关联 MemberUserDO 的 id 字段、或者 AdminUserDO 的 id 字段
     */
    private Long userId;


    /**
     * 模版内容
     *
     * 基于 {@link NotifyTemplateDO#getContent()} 格式化后的内容
     */
    private String templateContent;


}
