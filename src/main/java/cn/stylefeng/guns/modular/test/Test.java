package cn.stylefeng.guns.modular.test;

import cn.stylefeng.guns.modular.system.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2018/10/30.
 */

@Controller
@RequestMapping("/test")
public class Test {


    @RequestMapping("")
    public String test(){
        return "/test/test.html";
    }


    @RequestMapping("/test001")
    public ModelAndView test001(){
        Order order=new Order();
        order.setUserName("韩寒");
        return new ModelAndView("/test/test001.html")
                .addObject("order",order);
    }

}
