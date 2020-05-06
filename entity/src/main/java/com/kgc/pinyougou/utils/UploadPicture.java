package com.kgc.pinyougou.utils;

import com.kgc.pinyougou.domain.Seller;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @Auther: 谭海亮
 * @Date: 2020/5/1 21:18
 * @Description:
 */
public class UploadPicture implements Serializable {

    private Seller seller;

    private MultipartFile pfile;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public MultipartFile getPfile() {
        return pfile;
    }

    public void setPfile(MultipartFile pfile) {
        this.pfile = pfile;
    }
}
