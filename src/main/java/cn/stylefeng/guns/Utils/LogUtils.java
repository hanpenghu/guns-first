package cn.stylefeng.guns.Utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2018/10/29.
 */
public class LogUtils {

    public static void logInfo(org.slf4j.Logger log,String logName,Object o){
        try {
            log.info("@@@@@@@@{}: {}@@@@@@@@@",logName, JSON.toJSONString(o));
        } catch (Exception e)  {
            log.info(e.getMessage(),e);
            e.printStackTrace();
            try {
                log.info("@@@@@@@@{}: {}@@@@@@@@@",logName,o.toString());
            } catch (Exception e1) {
                log.info(e.getMessage(),e);
                e1.printStackTrace();
            }
        }
    }

}
