# ximageLib
自带适配功能,适应所有的屏幕,相当于等比例缩放<br/>
可以定制标题栏和状态栏的背景色<br/>
可以定制返回按钮的图标<br/>
可以定制标题栏的文本和颜色<br/>
可以定制确定按钮的文本和颜色和drawbale背景<br/>
可以定制照相机图标<br/>
可以通过配置开启一系列的功能,包括<br/>
照相<br/>
裁剪<br/>
预览<br/>
选择图片数量为1的时候的效果<br/>
多张图片选择的效果<br/>

使用方法,android studio直接使用gradle依赖即可,<br/>

compile 'com.xiaojinzi:ximagelib:1.0.2'

如何打开一个图片选择器

```
XImageLoader imageLoader = new XImageLoader() {
	@Override
	public void load(Context context, String localPath, ImageView iv) {
                Glide.with(context).load(localPath).into(iv);
	}
};

XSelectAct.open(this, new XImgSelConfig.Builder(imageLoader)
                .btnConfirmText("完成")
                .title("图片")
                .isPreview(true)
                .statusBarColor(ColorUtil.getColor(this, R.color.common_app_color))
                .titlebarBgColor(ColorUtil.getColor(this, R.color.common_app_color))
                .maxNum(1)
                .isPreview(false)
                .cropSize(1, 1, 800, 800)
                .isCamera(true)
                .isCrop(true)
                .build(), 123);
```
123是请求码,需要在activity的OnActivityresult方法中使用
```
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK && data != null) {
            ArrayList<String> images = data.getStringArrayListExtra("data");

            if (images != null && images.size() > 0) {
                localImagePath = images.get(0);
                disPlayImageToIcon();
            } else {
                T.showShort(context, "更换头像失败");
            }

        }
    }
```
只有这个方法能打开选择界面,单选就是maxNum(1),多选的时候maxNum(1+)即可
框架中有对多选和单选时候的不同处理

![image1](https://github.com/xiaojinzi123/ximageLib/blob/master/desc/image1.png) 
![image2](https://github.com/xiaojinzi123/ximageLib/blob/master/desc/image2.png) 
![image3](https://github.com/xiaojinzi123/ximageLib/blob/master/desc/image3.png) 
