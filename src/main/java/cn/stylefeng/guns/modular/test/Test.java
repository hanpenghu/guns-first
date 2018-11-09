package cn.stylefeng.guns.modular.test;

import cn.stylefeng.guns.Utils.LogUtils;
import cn.stylefeng.guns.modular.system.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/10/30.
 */

@Controller
@RequestMapping("/test")
public class Test {

    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String test(){
        return "/test/test.html";
    }



    /**
     *传输参数到页面
     * */
    @RequestMapping("/test001")
    public ModelAndView test001(){
        Order order=new Order();
        order.setUserName("韩寒");
        ModelAndView modelAndView = new ModelAndView("/test/test001.html").addObject("order", order);
        LogUtils.logInfo(log,"modelAndView",modelAndView);
        return modelAndView;
    }

    /**
     *接受页面参数
     * */
    @RequestMapping("/test002")
    public ModelAndView test002(Order order, HttpServletRequest request){
        LogUtils.logInfo(log,"request.getContextPath()",request.getContextPath());
        LogUtils.logInfo(log,"order",order);
        return new ModelAndView("/test/test001.html").addObject("s","接受参数成功");
    }


    /**
     *接受页面参数
     * */
   /* @RequestMapping("/test002")
    public ModelAndView test002(Order order, HttpServletRequest request){
        LogUtils.logInfo(log,"request.getContextPath()",request.getContextPath());
        LogUtils.logInfo(log,"order",order);
        return new ModelAndView("/test/test002.html").addObject("s","接受参数成功");
    }*/

}
