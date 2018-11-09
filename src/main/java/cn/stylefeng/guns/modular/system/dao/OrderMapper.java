package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Order;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-10-30
 */
public interface OrderMapper extends BaseMapper<Order> {

    @Select({"select user_name from biz_order limit 0,1"})
    String test001();


    List<Map<String, Object>> getPag(@Param("page") Page<Order> page,
                                     @Param("orderByField")String orderByField,
                                     @Param("isAsc") boolean isAsc);


}
