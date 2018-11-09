package cn.stylefeng.guns.modular.order.service;

import cn.stylefeng.guns.modular.system.model.Order;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2018-10-30
 */
public interface IOrderService extends IService<Order> {

    List<Map<String, Object>> getPag(Page<Order> page, String orderByField, boolean asc);
}
