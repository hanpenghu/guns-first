package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Custom;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 汽车维修客户表 Mapper 接口
 * </p>
 *
 * @author han
 * @since 2018-12-17
 */
public interface CustomMapper extends BaseMapper<Custom> {

    List<Map<String, Object>> getPag(@Param("page") Page<Custom> page,
                                     @Param("orderByField")String orderByField,
                                     @Param("isAsc") boolean isAsc,@Param("condition")String condition);


    @Select({"select name from han_custom where id=#{customId}"})
    String getCustomNameWithId(@Param("customId")String customId);
}
