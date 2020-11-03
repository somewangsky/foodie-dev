package com.zxelec.controller;

import com.zxelec.service.UserService;
import com.zxelec.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author vimicro
 * @date 2020/11/3
 */
@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(
            @ApiParam(name = "username",value = "用户名",required = true)
            @RequestParam String username) {

        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        // 2. 查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }

        // 3. 请求成功，用户名没有重复
        return IMOOCJSONResult.ok();
    }
}
