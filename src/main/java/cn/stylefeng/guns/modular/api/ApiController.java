/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.modular.api;

import cn.stylefeng.guns.Utils.LogUtils;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.core.util.JwtTokenUtil;
import cn.stylefeng.guns.modular.system.dao.UserMapper;
import cn.stylefeng.guns.modular.system.model.LoginModel;
import cn.stylefeng.guns.modular.system.model.Msg;
import cn.stylefeng.guns.modular.system.model.User;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ErrorResponseData;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 接口控制器提供
 *
 * @author stylefeng
 * @Date 2018/7/20 23:39
 */
@RestController
@RequestMapping("/gunsApi")
public class ApiController extends BaseController {

    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    /**
     * api登录接口，通过账号密码获取token
     */

    @RequestMapping(value = "/auth",method = RequestMethod.POST,produces ={"application/json;charset=utf-8"})
    public @ResponseBody  Object authMy(@RequestBody LoginModel loginModel) {

        LogUtils.logInfo(log,"loginModel",loginModel);
        String username=loginModel.getUsername();
        String password=loginModel.getPassword();
        //封装请求账号密码为shiro可验证的token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password.toCharArray());

        //获取数据库中的账号密码，准备比对
        User user = userMapper.getByAccount(username);

        String credentials = user.getPassword();

        //这个密码是加密过的
        //@@@@@@@@credentials: "ecfadcde9305f8891bcfe5a1e28c253e"@@@@@@@@@
        LogUtils.logInfo(log,"credentials",credentials);

        String salt = user.getSalt();

        //@@@@@@@@salt: "8pgby"@@@@@@@@@
        LogUtils.logInfo(log,"salt",salt);

        ByteSource credentialsSalt = new Md5Hash(salt);

        //credentials是加盐加密后的密码//credentialsSalt是哈希后的盐
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                new ShiroUser(), credentials, credentialsSalt, "");

        //校验用户账号密码
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(ShiroKit.hashAlgorithmName);
        md5CredentialsMatcher.setHashIterations(ShiroKit.hashIterations);

        boolean passwordTrueFlag =
                md5CredentialsMatcher.doCredentialsMatch(usernamePasswordToken, simpleAuthenticationInfo);

        if (passwordTrueFlag) {
            String token = JwtTokenUtil.generateToken(String.valueOf(user.getId()));
            LogUtils.logInfo(log,"token",token);
            return Msg.g().setStatus(1).setMsg("成功").setToken(token);
        } else {
            return Msg.g().setStatus(0).setMsg("失败！账号密码错误！");
        }
    }



    /**
     * 测试接口是否走鉴权
     */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Object test() {

        return SUCCESS_TIP;

    }













     /*@RequestMapping("/auth")
    public Object auth(@RequestParam("username") String username,
                       @RequestParam("password") String password) {

        //封装请求账号密码为shiro可验证的token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password.toCharArray());

        //获取数据库中的账号密码，准备比对
        User user = userMapper.getByAccount(username);

        String credentials = user.getPassword();
        String salt = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(salt);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                new ShiroUser(), credentials, credentialsSalt, "");

        //校验用户账号密码
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(ShiroKit.hashAlgorithmName);
        md5CredentialsMatcher.setHashIterations(ShiroKit.hashIterations);
        boolean passwordTrueFlag = md5CredentialsMatcher.doCredentialsMatch(
                usernamePasswordToken, simpleAuthenticationInfo);

        if (passwordTrueFlag) {
            String token = JwtTokenUtil.generateToken(String.valueOf(user.getId()));
            HashMap<String, Object> result = new HashMap<>();
            result.put("token", token);
            log.info("@@@@@@ token @@@@@@@@");
            log.info(token);
            log.info("@@@@@@@ token @@@@@@@");
            return result;
        } else {
            return new ErrorResponseData(500, "账号密码错误！");
        }
    }
*/

//    public static void main(String[]args){
//            System.out.println("12dsfs；拉上的看法".toCharArray());
//    }

}

