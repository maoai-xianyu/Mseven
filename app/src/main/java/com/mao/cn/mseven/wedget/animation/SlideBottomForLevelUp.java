package com.mao.cn.mseven.wedget.animation;

import android.view.View;

import com.mao.cn.mseven.wedget.animation.animationeffects.BaseEffects;
import com.nineoldandroids.animation.ObjectAnimator;

public class SlideBottomForLevelUp extends BaseEffects {

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "translationY", 500, 0).setDuration(mDuration)

        );
    }
}
