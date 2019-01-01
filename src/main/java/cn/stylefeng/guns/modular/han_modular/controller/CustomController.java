package cn.stylefeng.guns.modular.han_modular.controller;

import cn.stylefeng.guns.core.common.constant.factory.PageFactory;
import cn.stylefeng.guns.core.common.page.PageInfoBT;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.modular.system.warpper.CustomWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.plugins.Page;
import hanhan.p;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Custom;
import cn.stylefeng.guns.modular.han_modular.service.ICustomService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * hanService控制器
 *

 */
@Controller
@RequestMapping("/custom")
public class CustomController extends BaseController {

    private String PREFIX = "/han_modular/custom/";

    @Autowired
    private ICustomService customService;

    /**
     * 跳转到hanService首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "custom.html";
    }

    /**
     * 跳转到添加hanService
     */
    @RequestMapping("/custom_add")
    public String customAdd() {
        return PREFIX + "custom_add.html";
    }

    /**
     * 跳转到修改hanService
     */
    @RequestMapping("/custom_update/{customId}")
    public String customUpdate(@PathVariable String customId, Model model) {
        Custom custom = customService.selectById(customId);
        model.addAttribute("item",custom);
        LogObjectHolder.me().set(custom);
        return PREFIX + "custom_edit.html";
    }

    /**
     * 获取hanService列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        if(p.notEmpty(condition)){
            condition=p.bfh+condition+p.bfh;
        }else{condition="";}

        Page<Custom> page = new PageFactory<Custom>().defaultPage();

        List<Map<String, Object>> result = customService.getPag(page,page.getOrderByField(),false, condition);

        page.setRecords(new CustomWarpper(result).wrap());
//        return customService.selectList(null);
        return new PageInfoBT<>(page);

    }

    /**
     * 新增hanService
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Custom custom) {
        custom.setCreateTime(new Date());
        custom.setCreateBy(ShiroKit.getUserSign());
        customService.insert(custom);
        return SUCCESS_TIP;
    }

    /**
     * 删除hanService
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String customId) {
        customService.deleteById(customId);
        return SUCCESS_TIP;
    }

    /**
     * 修改hanService
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Custom custom) {
        customService.updateById(custom);
        return SUCCESS_TIP;
    }

    /**
     * hanService详情
     */
    @RequestMapping(value = "/detail/{customId}")
    @ResponseBody
    public Object detail(@PathVariable("customId") String customId) {
        return customService.selectById(customId);
    }
}
