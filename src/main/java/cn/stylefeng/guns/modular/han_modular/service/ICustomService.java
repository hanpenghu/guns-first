package cn.stylefeng.guns.modular.han_modular.service;

import cn.stylefeng.guns.modular.system.model.Custom;
import cn.stylefeng.guns.modular.system.model.Order;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 汽车维修客户表 服务类
 * </p>
 *
 * @author han
 * @since 2018-12-17
 */
public interface ICustomService extends IService<Custom> {
    List<Map<String, Object>> getPag(Page<Custom> page, String orderByField, boolean asc,String condition);
}
