package cn.stylefeng.guns.modular.han.controller;

import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Fix;
import cn.stylefeng.guns.modular.han.service.IFixService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * hanFixRecord控制器
 *
 * @author fengshuonan
 * @Date 2018-12-25 20:25:56
 */
@Controller
@RequestMapping("/fix")
public class FixController extends BaseController {

    private String PREFIX = "/han/fix/";

    @Autowired
    private IFixService fixService;

    /**
     * 跳转到hanFixRecord首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "fix.html";
    }

    /**
     * 跳转到添加hanFixRecord
     */
    @RequestMapping("/fix_add")
    public String fixAdd(String id,Model model) {
        System.out.println("==========fix_add==============="+id+"===============");
        model.addAttribute("customId",id);
        return PREFIX + "fix_add.html";

    }

    /**
     * 跳转到修改hanFixRecord
     */
    @RequestMapping("/fix_update/{fixId}")
    public String fixUpdate(@PathVariable Integer fixId, Model model) {
        Fix fix = fixService.selectById(fixId);
        model.addAttribute("item",fix);
        LogObjectHolder.me().set(fix);
        return PREFIX + "fix_edit.html";
    }

    /**
     * 获取hanFixRecord列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        return fixService.selectList(null);
    }

    /**
     * 新增hanFixRecord
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Fix fix) {
        fix.setId(UUID.randomUUID().toString().replace("-",""));
        fix.setCreateTime(new Date());
        fix.setCreateBy(ShiroKit.getUserSign());
        fixService.insert(fix);
        return SUCCESS_TIP;
    }

    /**
     * 删除hanFixRecord
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String fixId) {
        System.out.println("==========="+fixId+"=============");
        fixService.deleteById(fixId);
        return SUCCESS_TIP;
    }

    /**
     * 修改hanFixRecord
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Fix fix) {
        fixService.updateById(fix);
        return SUCCESS_TIP;
    }

    /**
     * hanFixRecord详情
     */
    @RequestMapping(value = "/detail/{fixId}")
    @ResponseBody
    public Object detail(@PathVariable("fixId") Integer fixId) {
        return fixService.selectById(fixId);
    }
}
