package cn.stylefeng.guns.Schedule;

import cn.stylefeng.guns.Utils.LogUtils;
import cn.stylefeng.guns.modular.system.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/31.
 */
@Component
public class Test001 {

    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderMapper orderMapper;

    @Scheduled(initialDelay = 15000,fixedDelay =Long.MAX_VALUE)
    public void f(){
//        LogUtils.logInfo(log,"test001",orderMapper.test001());
    }

}
