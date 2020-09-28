package com.bookshop.service.service.imip;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookshop.service.entity.User;
import com.bookshop.service.mapper.UserMapper;
import com.bookshop.service.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
