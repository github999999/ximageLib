package com.xiaojinzi.ximagelib.imageModel;

import android.content.Context;


import com.xiaojinzi.ximagelib.listener.IQueryImageListener;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by cxj on 2016/9/27.
 * 查询本地图片的数据处理层面,要求回掉接口中返回要展示的图片的集合
 * 1:所有的图片集合形式
 * 2:所有的图片目录集合形式
 * 2:某一个目录下的图片集合形式
 */
public interface IQueryImageModel {

    /**
     * 查询本地的图片,整理成集合
     *
     * @param context      上下文
     * @param selectImages 预选中的集合
     * @param listener     回调
     */
    void getAllImages(Context context, ArrayList<String> selectImages, IQueryImageListener listener);

    /**
     * 获取所有的图片文件夹
     *
     * @param listener 回调
     */
    void getAllFolders(IQueryImageListener listener);

    /**
     * 获取某一个目录下的图片集合
     *
     * @param folder   目录
     * @param listener 回调
     */
    void getImageInFolder(String folder, IQueryImageListener listener);

    /**
     * 获取文件目录选择所需要的数据
     *
     * @param listener 回调
     */
    void getFolderBeanList(IQueryImageListener listener);

    /**
     * 释放资源
     */
    void release();
}
