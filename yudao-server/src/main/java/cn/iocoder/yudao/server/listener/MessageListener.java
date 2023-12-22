package cn.iocoder.yudao.server.listener;


import cn.iocoder.yudao.server.model.IMSendResult;

public interface MessageListener<T> {

     void process(IMSendResult<T> result);

}
