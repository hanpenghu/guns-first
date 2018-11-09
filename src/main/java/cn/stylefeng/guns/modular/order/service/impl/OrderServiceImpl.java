package cn.stylefeng.guns.modular.order.service.impl;

import cn.stylefeng.guns.modular.order.service.IOrderService;
import cn.stylefeng.guns.modular.system.dao.OrderMapper;
import cn.stylefeng.guns.modular.system.model.Order;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-10-30
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {


    @Override
    public List<Map<String, Object>> getPag(Page<Order> page, String orderByField, boolean asc) {
        return super.baseMapper.getPag(page,orderByField,asc);
    }
}
