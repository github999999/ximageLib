package com.xiaojinzi.ximagelib.listener;

import com.xiaojinzi.ximagelib.imageView.popup.bean.FolderBean;

import java.util.List;

/**
 * Created by cxj on 2016/9/27.
 */
public interface IQueryImageListener {

    /**
     * 展示所有图片
     *
     * @param images 图片的集合
     */
    void disPlayAllImage(List<String> images);

    /**
     * 供给用户选择的所有文件夹
     *
     * @param folders 目录的集合
     */
    void disPlayAllFolder(List<String> folders);


    /**
     * 展示某一个文件夹下的图片
     *
     * @param images 图片的集合
     */
    void disPlayImageInFolder(List<String> images);

    void disFolderBeanList(List<FolderBean> folderBeanList);
}
