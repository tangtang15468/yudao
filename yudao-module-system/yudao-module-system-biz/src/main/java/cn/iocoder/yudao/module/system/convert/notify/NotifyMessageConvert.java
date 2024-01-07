package cn.iocoder.yudao.module.system.convert.notify;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.iocoder.yudao.module.system.controller.admin.notify.vo.message.NotifyMessageRespVO;
import cn.iocoder.yudao.module.system.convert.mail.MailAccountConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.mail.MailAccountDO;
import cn.iocoder.yudao.module.system.dal.dataobject.notify.NotifyMessageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

@Mapper
public interface NotifyMessageConvert {

    NotifyMessageConvert INSTANCE = Mappers.getMapper(NotifyMessageConvert.class);

    default NotifyMessageRespVO convertVo(NotifyMessageDO notifyMessageDO) {
        NotifyMessageRespVO notifyMessageRespVO = new NotifyMessageRespVO();
        BeanUtils.copyProperties(notifyMessageDO,notifyMessageDO);
        return notifyMessageRespVO;
    }
}
