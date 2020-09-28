package com.bookshop.service.service.imip;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookshop.service.entity.shoptopTen;
import com.bookshop.service.mapper.BookToptenMapper;
import com.bookshop.service.service.ShopTopTenService;
import org.springframework.stereotype.Service;

@Service
public class ShopTopTenServiceimpl extends ServiceImpl<BookToptenMapper, shoptopTen> implements ShopTopTenService {
}
