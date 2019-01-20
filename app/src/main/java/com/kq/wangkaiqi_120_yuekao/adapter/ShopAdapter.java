package com.kq.wangkaiqi_120_yuekao.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kq.wangkaiqi_120_yuekao.R;
import com.kq.wangkaiqi_120_yuekao.bean.ShopBean;

import java.util.List;

/**
 * author:王凯琦
 * Date:2019/1/20
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private Context mContext;
    private List<ShopBean.Data> list;

    public ShopAdapter(Context mContext, List<ShopBean.Data> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.shop_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        String images = list.get(i).getImages();
        String[] split = images.split("\\|");
        for (int j = 0; j < split.length; j++) {
            viewHolder.ShopImage.setImageURI(Uri.parse(split[j]));
        }
        viewHolder.ShopName.setText(list.get(i).getTitle());
        viewHolder.ShopPrice.setText("¥" + list.get(i).getPrice() + "");
        viewHolder.ShopPingLun.setText(list.get(i).getSalenum() + "条评论   " + "98%好评" + "");

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickL.Click(list.get(i).getPid());
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TranslateAnimation animator=new TranslateAnimation(0,100,0,0);
               animator.setDuration(3000);
               viewHolder.itemView.setAnimation(animator);
               animator.setFillAfter(false);
               animator.startNow();
                /* Animator translationX = new ObjectAnimator().ofFloat(viewHolder.itemView,"translationX",0,1000f);
                ObjectAnimator translationY = new ObjectAnimator().ofFloat(viewHolder.itemView,"translationY",0,0);

                AnimatorSet animatorSet = new AnimatorSet();  //组合动画
                animatorSet.playTogether(translationX,translationY); //设置动画
                animatorSet.setDuration(1);  //设置动画时间
                animatorSet.start(); //启动*/
                list.remove(i);
                notifyDataSetChanged();


                //onClickLong.LongClick();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView ShopImage;
        private TextView ShopName, ShopPingLun, ShopPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ShopImage = itemView.findViewById(R.id.ShopImage);
            ShopName = itemView.findViewById(R.id.ShopName);
            ShopPingLun = itemView.findViewById(R.id.ShopPingLun);
            ShopPrice = itemView.findViewById(R.id.ShopPrice);
        }
    }

    private OnClickL onClickL;

    public interface OnClickL{
        void Click(int id);
    }

    public void setOnClickL(OnClickL onClickL){
        this.onClickL=onClickL;
    }


    private OnClickLong onClickLong;

    public interface OnClickLong{
        void LongClick();
    }

    public void setOnClickLong(OnClickLong onClickLong){
        this.onClickLong=onClickLong;
    }
}
