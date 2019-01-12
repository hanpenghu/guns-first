package cn.stylefeng.guns.modular.han.controller;

import cn.stylefeng.guns.core.common.constant.factory.PageFactory;
import cn.stylefeng.guns.core.common.page.PageInfoBT;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.modular.system.dao.CustomMapper;
import cn.stylefeng.guns.modular.system.model.Custom;
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
import cn.stylefeng.guns.modular.system.model.Fix;
import cn.stylefeng.guns.modular.han.service.IFixService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * hanFixRecord控制器
 *
 * @author fengshuonan
 * @Date 2018-12-25 20:25:56
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
@RequestMapping("/fix")
public class FixController extends BaseController {

    @Autowired
    private CustomMapper customMapper;

    private String PREFIX = "/han/fix/";

    @Autowired
    private IFixService fixService;

    /**
     * 跳转到hanFixRecord首页
     */
    @RequestMapping("")
    public ModelAndView index(String id) {
        ModelAndView modelAndView = new ModelAndView(PREFIX+"/fix.html");
        modelAndView.addObject("condition",id);
        System.out.println("============/fix====11111111====   condition="+id+"    =============");
        return modelAndView;

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
    public String fixUpdate(@PathVariable String fixId, Model model) {
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
        System.out.println("=============condition=   "+condition+"    ================");
        if(p.notEmpty(condition)){if(condition.startsWith(",")){condition=condition.substring(1);}}
        if(p.notEmpty(condition)){
            condition=p.bfh+condition+p.bfh;
        }else{condition="";}

        Page<Fix> page = new PageFactory<Fix>().defaultPage();

        List<Map<String, Object>> result = fixService.getPag(page,page.getOrderByField(),false, condition);
        if(null!=result){
            for(Map<String, Object> map:result){
                String customId =(String) map.get("customId");
                String customName = customMapper.getCustomNameWithId(customId);
                map.put("customName",customName);
            }
        }
//        p.p(JSON.toJSONString(result, SerializerFeature.PrettyFormat));
        page.setRecords(new CustomWarpper(result).wrap());
//        return customService.selectList(null);
        return new PageInfoBT<>(page);
//        return fixService.selectList(null);
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
        p.p(JSON.toJSONString(fix,SerializerFeature.PrettyFormat));
        fixService.updateById(fix);
        return SUCCESS_TIP;
    }

    /**
     * hanFixRecord详情
     */
    @RequestMapping(value = "/detail/{fixId}")
    @ResponseBody
    public Object detail(@PathVariable("fixId") String fixId) {
        return fixService.selectById(fixId);
    }
}
