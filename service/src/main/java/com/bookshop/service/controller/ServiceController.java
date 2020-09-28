package com.bookshop.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bookshop.service.entity.Onetomore;
import com.bookshop.service.entity.User;
import com.bookshop.service.entity.shoptopTen;
import com.bookshop.service.service.ShopTopTenService;
import com.bookshop.service.service.UserService;
import com.bookshop.service.service.moretimeService;
import com.bookshop.service.service.onetomoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin("*")
@RequestMapping("/shop")
@RestController
public class ServiceController {
    @Autowired
    private ShopTopTenService shopten;
    @Autowired
    private moretimeService moretime;
    @Autowired
    private onetomoreService onetomore;
    @Autowired
    private UserService userService;
    @GetMapping("/ten")
    public HashMap<String, Object> shopTen(@Param("user_id") String user_id){
        HashMap<String,Object> HashMap = new HashMap<>();
        if (user_id==null){
            List<shoptopTen> shopTens = shopten.list(null);
            HashMap.put("data", shopTens);
        }else {
            QueryWrapper<Onetomore> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", user_id);
            List<Onetomore> onetomoreList = onetomore.list(wrapper);
            if (onetomoreList.size()>=5){
                List<Onetomore> onetomores = onetomoreList.subList(0, 5);
                HashMap.put("data", onetomores);
                return HashMap;
            }
            else {
                HashMap.put("data", onetomoreList);
                return HashMap;
            }
        }
        return HashMap;
    }
    @GetMapping("/moretime")
    public List<com.bookshop.service.entity.moretime> moretime(){
        QueryWrapper<com.bookshop.service.entity.moretime> wrapper = new QueryWrapper<>();
        wrapper.select("book_id","pro_title");
        List<com.bookshop.service.entity.moretime> list = moretime.list(wrapper);
        List<com.bookshop.service.entity.moretime> moretimeList = list.subList(0, 8);
        return moretimeList;
    }
    @PostMapping(value="/login")
    public HashMap<String, Object> login(@RequestBody User user){
        HashMap<String, Object> hashMap = new HashMap<>();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", user.getUserName());
        Map<String, Object> map = userService.getMap(wrapper);
        if (map==null){
            hashMap.put("code", 201);
            hashMap.put("data", "用户不存在");
            return hashMap;
        }
        if (user.getPassword().equals(map.get("password"))){
            hashMap.put("code", 200);
            hashMap.put("id", map.get("id"));
            return hashMap;
        }else {
            hashMap.put("code", 201);
            hashMap.put("data", "用户账号或密码错误");
            return hashMap;
        }
    }
}