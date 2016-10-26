package com.xiaojinzi.ximagelib;


import com.xiaojinzi.ximagelib.config.XImgSelConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxj on 2016/9/27.
 */
public class XImage {

    private static XImgSelConfig config;

    /**
     * 注入配置类
     *
     * @param config 配置文件
     */
    public static void setConfig(XImgSelConfig config) {
        XImage.config = config;
    }

    /**
     * 获取配置类
     *
     * @return noDesc
     */
    public static XImgSelConfig getConfig() {
        return config;
    }

}
