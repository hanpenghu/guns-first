package cn.stylefeng.guns.modular.order.controller;

import cn.stylefeng.guns.core.common.constant.factory.PageFactory;
import cn.stylefeng.guns.core.common.page.PageInfoBT;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.order.service.IOrderService;
import cn.stylefeng.guns.modular.system.model.Order;
import cn.stylefeng.guns.modular.system.warpper.OrderWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 订单管理控制器
 *
 * @author fengshuonan
 * @Date 2018-10-30 16:02:47
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());

    private String PREFIX = "/order/order/";

    @Autowired
    private IOrderService orderService;

    /**
     * 跳转到订单管理首页
     */
    @RequestMapping("")
    public String index() {

        return PREFIX + "order.html";

    }

    /**
     * 跳转到添加订单管理
     */
    @RequestMapping("/order_add")
    public String orderAdd() {

        return PREFIX + "order_add.html";

    }

    /**
     * 跳转到修改订单管理
     */
    @RequestMapping("/order_update/{orderId}")
    public String orderUpdate(@PathVariable Integer orderId, Model model) {
        Order order = orderService.selectById(orderId);
        model.addAttribute("item",order);
        LogObjectHolder.me().set(order);
        return PREFIX + "order_edit.html";
    }

    /**
     * 获取订单管理列表
     */
   /* @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        List<Order> orders = orderService.selectList(null);

        LogUtils.logInfo(log,"orders.size()",orders.size());
        LogUtils.logInfo(log,"orders",orders);

        return orders;

    }*/

    /**
     *改成数据库分页
     * */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        Page<Order> page = new PageFactory<Order>().defaultPage();

        List<Map<String, Object>> result = orderService.
                getPag(page,page.getOrderByField(), page.isAsc());

        page.setRecords(new OrderWarpper(result).wrap());

        return new PageInfoBT<>(page);
    }

    /**
     * 新增订单管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Order order) {
        orderService.insert(order);
        return SUCCESS_TIP;
    }

    /**
     * 删除订单管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer orderId) {
        orderService.deleteById(orderId);
        return SUCCESS_TIP;
    }

    /**
     * 修改订单管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Order order) {
        orderService.updateById(order);
        return SUCCESS_TIP;
    }

    /**
     * 订单管理详情
     */
    @RequestMapping(value = "/detail/{orderId}")
    @ResponseBody
    public Object detail(@PathVariable("orderId") Integer orderId) {

        return orderService.selectById(orderId);

    }
}
