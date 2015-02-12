package com.jackoder.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Jackoder on 2015/2/12.
 */
public class AnimImageView extends ImageView {

    boolean lastRunningState = false;
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
        if (animationDrawable != null && (lastRunningState || autoRun) && !animationDrawable.isRunning()) {
            animationDrawable.start();
        }
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            this.animationDrawable = (AnimationDrawable)drawable;
        }
    }

    @Override
    public void setVisibility(int visibility) {
        //if visiblity is VISIBLE, the AnimationDrawable will auto start the animation, so we control the state by ourself.
        if (visibility != View.VISIBLE) {
            lastRunningState = animationDrawable.isRunning();
        }
        super.setVisibility(visibility);
        if (visibility == View.VISIBLE) {
            if (!lastRunningState) {
                stopAnimation();
            }
        }
    }

    public void startAnimation() {
        startAnimation(false);
    }

    public void startAnimation(boolean reStart) {
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
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
    }

}
