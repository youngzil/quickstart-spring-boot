package org.quickstart.spring.boot.netty.action.controller;

import org.quickstart.spring.boot.netty.action.common.constant.Constants;
import org.quickstart.spring.boot.netty.action.common.enums.StatusEnum;
import org.quickstart.spring.boot.netty.action.common.pojo.CustomProtocol;
import org.quickstart.spring.boot.netty.action.common.res.BaseResponse;
import org.quickstart.spring.boot.netty.action.server.HeartBeatServer;
import org.quickstart.spring.boot.netty.action.vo.req.SendMsgReqVO;
import org.quickstart.spring.boot.netty.action.vo.res.SendMsgResVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 22/05/2018 14:46
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private HeartBeatServer heartbeatClient ;


    /**
     * 统计 service
     */
    @Autowired
    private CounterService counterService;

    /**
     * 向服务端发消息
     * @param sendMsgReqVO
     * @return
     */
    @ApiOperation("服务端发送消息")
    @RequestMapping("sendMsg")
    @ResponseBody
    public BaseResponse<SendMsgResVO> sendMsg(@RequestBody SendMsgReqVO sendMsgReqVO){
        BaseResponse<SendMsgResVO> res = new BaseResponse();
        heartbeatClient.sendMsg(new CustomProtocol(sendMsgReqVO.getId(),sendMsgReqVO.getMsg())) ;

        counterService.increment(Constants.COUNTER_SERVER_PUSH_COUNT);

        SendMsgResVO sendMsgResVO = new SendMsgResVO() ;
        sendMsgResVO.setMsg("OK") ;
        res.setCode(StatusEnum.SUCCESS.getCode()) ;
        res.setMessage(StatusEnum.SUCCESS.getMessage()) ;
        res.setDataBody(sendMsgResVO) ;
        return res ;
    }
}
