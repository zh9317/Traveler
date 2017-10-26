package com.jinqihang.traveler.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**
 * 实现图片按下缩小，抬起放大的效果
 * Created by Administrator on 2017/10/9 0009.
 */

public class ClickImageView extends ImageView {

    private Animator animator1;
    private Animator animator2;
    private int mHeight;
    private int mWidth;
    private float mX, mY;
    private Handler handler = new Handler();

    private ClickListener listener;

    public ClickImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getHeight() - getPaddingTop() - getPaddingBottom();
        mWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        mX = getX();
        mY = getY();
    }

    private void init(){
        PropertyValuesHolder valuesHolder_1 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.9f);
        PropertyValuesHolder valuesHolder_2 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.9f);
        animator1 = ObjectAnimator.ofPropertyValuesHolder(this, valuesHolder_1, valuesHolder_2);
        animator1.setDuration(200);
        animator1.setInterpolator(new LinearInterpolator());

        PropertyValuesHolder valuesHolder_3 = PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1f);
        PropertyValuesHolder valuesHolder_4 = PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1f);
        animator2 = ObjectAnimator.ofPropertyValuesHolder(this, valuesHolder_3, valuesHolder_4);
        animator2.setDuration(200);
        animator2.setInterpolator(new LinearInterpolator());
    }

     public void setClickListener (ClickListener clickListener){
         this.listener = clickListener;
     }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        animator2.end();
                        animator1.start();
                    }
                });
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        animator1.end();
                        animator2.start();
                    }
                });
                if (listener != null){
                    listener.onClick();
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    protected boolean innerImageView(float x, float y){
        if (x >= mX && x <= mX + mWidth){
            if (y >= mY && y <= mY + mHeight){
                return true;
            }
        }
        return false;
    }

    /**
     * 点击事件处理回调
     * @author zhanghao
     */
    public interface ClickListener {
        public void onClick();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
