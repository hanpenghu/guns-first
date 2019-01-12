package cn.stylefeng.guns.modular.han.service;

import cn.stylefeng.guns.modular.system.model.Fix;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 汽车维修项目表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-25
 */
public interface IFixService extends IService<Fix> {

    List<Map<String, Object>> getPag(Page<Fix> page, String orderByField, boolean b, String condition);



}
