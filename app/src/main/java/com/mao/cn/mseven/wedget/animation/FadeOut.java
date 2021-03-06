package com.mao.cn.mseven.wedget.animation;

import android.view.View;

import com.mao.cn.mseven.wedget.animation.animationeffects.BaseEffects;
import com.nineoldandroids.animation.ObjectAnimator;

public class FadeOut extends BaseEffects {

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view,"alpha",1,0).setDuration(mDuration)

        );
    }
}
