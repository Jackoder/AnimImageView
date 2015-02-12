package com.jackoder.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.nd.up91.ui.R;

/**
 * Created by Jackoder on 2015/2/12.
 */
public class AnimImageView extends ImageView {

    //setVisible会把AnimationDrawable停止，所以需要记住上一次用户是否手动触发了start
    boolean manualStart = false;
    boolean autoRun = true;
    AnimationDrawable animationDrawable;

    public AnimImageView(Context context) {
        super(context);
        if (getDrawable() != null && getDrawable() instanceof AnimationDrawable) {
            animationDrawable = (AnimationDrawable)getDrawable();
        }
    }

    public AnimImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AnimImageView);
        autoRun = a.getBoolean(R.styleable.AnimImageView_aiv_auto, true);
        if (getDrawable() != null && getDrawable() instanceof AnimationDrawable) {
            animationDrawable = (AnimationDrawable)getDrawable();
        }
    }

    public AnimImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AnimImageView);
        autoRun = a.getBoolean(R.styleable.AnimImageView_aiv_auto, true);
        if (getDrawable() != null && getDrawable() instanceof AnimationDrawable) {
            animationDrawable = (AnimationDrawable)getDrawable();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (animationDrawable != null && (manualStart || autoRun) && !animationDrawable.isRunning()) {
            animationDrawable.start();
        }
    }

    public void setAnimationDrawable(AnimationDrawable animationDrawable) {
        this.animationDrawable = animationDrawable;
        setImageDrawable(animationDrawable);
    }

    public void startAnimation() {
        startAnimation(false);
    }

    public void startAnimation(boolean reStart) {
        manualStart = true;
        if (animationDrawable != null) {
            if (animationDrawable.isRunning()) {
                if (reStart) {
                    animationDrawable.stop();
                    animationDrawable.start();
                }
            } else {
                animationDrawable.start();
            }
        }
    }

    public void stopAnimation() {
        manualStart = false;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
    }

}
