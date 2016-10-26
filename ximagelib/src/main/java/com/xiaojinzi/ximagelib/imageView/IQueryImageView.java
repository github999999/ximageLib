package com.xiaojinzi.ximagelib.imageView;

import android.content.Context;

import com.xiaojinzi.ximagelib.imageView.popup.bean.FolderBean;

import java.util.List;

/**
 * Created by cxj on 2016/9/27.
 */
public interface IQueryImageView {

    /**
     * 显示正在加载的对话框
     *
     * @param content 内容
     */
    void showDialog(String content);

    /**
     * 关闭对话框
     */
    void closeDialog();


    /**
     * 显示所有的图片
     *
     * @param images 图片本地路径集合
     */
    void disPlayAllImage(List<String> images);

    Context getContext();

    void disPlayFolderBeanList(List<FolderBean> folderBeanList);

    void disPlayAllImageInFolder(List<String> images);
}
