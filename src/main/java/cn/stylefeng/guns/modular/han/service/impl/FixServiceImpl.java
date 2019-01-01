package cn.stylefeng.guns.modular.han.service.impl;

import cn.stylefeng.guns.modular.system.model.Fix;
import cn.stylefeng.guns.modular.system.dao.FixMapper;
import cn.stylefeng.guns.modular.han.service.IFixService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 汽车维修项目表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-25
 */
@Service
public class FixServiceImpl extends ServiceImpl<FixMapper, Fix> implements IFixService {

}
