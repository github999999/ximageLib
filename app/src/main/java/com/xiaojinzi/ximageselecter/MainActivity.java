package com.xiaojinzi.ximageselecter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaojinzi.ximagelib.config.XImgSelConfig;
import com.xiaojinzi.ximagelib.imageView.XSelectAct;
import com.xiaojinzi.ximagelib.utils.XImageLoader;

import java.util.ArrayList;

import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewHolder;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    private CommonRecyclerViewAdapter adapter;

    //要显示的数据
    private ArrayList<String> mImages = new ArrayList<String>();

    //显示图片的布局管理器
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);

        //创建适配器
        adapter = new CommonRecyclerViewAdapter<String>(this, mImages) {

            @Override
            public void convert(CommonRecyclerViewHolder h, String entity, int position) {
                Glide.with(context).load(entity).into((ImageView) h.getView(R.id.iv));
            }

            @Override
            public int getLayoutViewId(int viewType) {
                return com.xiaojinzi.ximagelib.R.layout.image_item;
            }
        };

        layoutManager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(layoutManager);

        //设置适配器
        rv.setAdapter(adapter);

    }

    public void test(View v) {

        XImageLoader imageLoader = new XImageLoader() {
            @Override
            public void load(Context context, String localPath, ImageView iv) {
                Glide.with(context).load(localPath).into(iv);
            }
        };

        XSelectAct.open(this, new XImgSelConfig.Builder(imageLoader)
                .btnConfirmText("完成")
                .title("图片")
                .btnConfirmBgDrawable(R.drawable.bg)
                .isPreview(true)
                .build(), 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK && data != null) {
            ArrayList<String> images = data.getStringArrayListExtra("data");

            mImages.clear();

//            adapter.notifyItemRangeRemoved(0, mImages.size());

            mImages.addAll(images);

//            adapter.notifyItemRangeInserted(0, images.size());
            adapter.notifyDataSetChanged();

            System.out.println("images = \n" + images);
        }
    }

}
