package com.kgc.pinyougou.config;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.pinyougou.domain.Seller;
import com.kgc.pinyougou.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 谭海亮
 * @Date: 2020/5/3 21:26
 * @Description:安全认证类
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Reference(version = "1.0",interfaceClass = SellerService.class)
    private SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Seller seller = sellerService.findOne(username);

        //认证权限
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_LEVEL1"));

        if (seller != null){
            if (seller.getStatus().equals("1")){
                return new User(username,seller.getPassword(),grantedAuthorities);
            }else {
                return null;
            }
        }
        return null;
    }

}
