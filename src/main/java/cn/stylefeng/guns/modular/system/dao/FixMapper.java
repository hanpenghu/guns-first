package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Custom;
import cn.stylefeng.guns.modular.system.model.Fix;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 汽车维修项目表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-25
 */
public interface FixMapper extends BaseMapper<Fix> {

    List<Map<String, Object>> getPag(@Param("page") Page<Fix> page,
                                     @Param("orderByField")String orderByField,
                                     @Param("isAsc") boolean isAsc,@Param("condition")String condition);

}
