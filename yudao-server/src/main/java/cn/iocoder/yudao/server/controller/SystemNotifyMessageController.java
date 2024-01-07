package cn.iocoder.yudao.server.controller;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.notify.vo.message.NotifyMessageRespVO;
import cn.iocoder.yudao.module.system.convert.notify.NotifyMessageConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.notice.NoticeDO;
import cn.iocoder.yudao.module.system.dal.dataobject.notify.NotifyMessageDO;
import cn.iocoder.yudao.module.system.service.notice.NoticeService;
import cn.iocoder.yudao.module.system.service.notify.NotifyMessageService;
import cn.iocoder.yudao.server.dto.NotifyMessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/im/v1/notify")
@RequiredArgsConstructor
public class SystemNotifyMessageController {



    private final NotifyMessageService notifyMessageService;

    private final NoticeService  noticeService;


    @GetMapping("/saveNotifyMess")
    @Operation(summary = "保存信息")
    public CommonResult<NotifyMessageRespVO> saveNotifyMess(@RequestBody NotifyMessageDto notifyMessageDto) {
        NoticeDO notice = noticeService.getNotice(notifyMessageDto.getNoticeId());
        Long notifyMessage = notifyMessageService.createNotifyMessage(notifyMessageDto.getUserId(),2,null,notifyMessageDto.getTemplateContent(),null);
        return success(null);
    }


    @GetMapping("/queryNotifyMessage")
    @Operation(summary = "根据用户id查询用户消息")
    public CommonResult<NotifyMessageRespVO> queryNotifyMessage(@RequestParam Long userId) {
        return success(NotifyMessageConvert.INSTANCE.convertVo(notifyMessageService.getMessageByUserId(userId)));
    }

}
