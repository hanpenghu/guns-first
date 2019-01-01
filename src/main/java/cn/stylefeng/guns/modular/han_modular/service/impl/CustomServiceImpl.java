package cn.stylefeng.guns.modular.han_modular.service.impl;

import cn.stylefeng.guns.modular.system.model.Custom;
import cn.stylefeng.guns.modular.system.dao.CustomMapper;
import cn.stylefeng.guns.modular.han_modular.service.ICustomService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 汽车维修客户表 服务实现类
 * </p>
 *
 * @author han
 * @since 2018-12-17
 */
@Service
public class CustomServiceImpl extends ServiceImpl<CustomMapper, Custom> implements ICustomService {
    @Override
    public List<Map<String, Object>> getPag(Page<Custom> page, String orderByField, boolean asc,String condition) {
        return super.baseMapper.getPag(page,orderByField,asc,condition);
    }


}
