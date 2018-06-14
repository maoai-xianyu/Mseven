package com.mao.cn.mseven.wedget.animation.animationeffects;


import com.mao.cn.mseven.wedget.animation.FadeIn;
import com.mao.cn.mseven.wedget.animation.FadeOut;
import com.mao.cn.mseven.wedget.animation.FlipH;
import com.mao.cn.mseven.wedget.animation.FlipV;
import com.mao.cn.mseven.wedget.animation.NewsPaper;
import com.mao.cn.mseven.wedget.animation.ShakeY;
import com.mao.cn.mseven.wedget.animation.SideFall;
import com.mao.cn.mseven.wedget.animation.SlideLeft;
import com.mao.cn.mseven.wedget.animation.SlideRight;
import com.mao.cn.mseven.wedget.animation.SlideTop;

/**
 * Created by lee on 2014/7/30.
 */
//TODO
public enum Effectstype {

    Fadein(FadeIn.class),
    Fadeout(FadeOut.class),
    Slideleft(SlideLeft.class),
    Slidetop(SlideTop.class),
    SlideCenter(com.mao.cn.mseven.wedget.animation.SlideCenter.class),
    SlideBottomIn(com.mao.cn.mseven.wedget.animation.SlideBottomIn.class),
    SlideBottomOut(com.mao.cn.mseven.wedget.animation.SlideBottomOut.class),
    SlideBottomForLevelUp(com.mao.cn.mseven.wedget.animation.SlideBottomForLevelUp.class),
    Slideright(SlideRight.class),
    Fall(com.mao.cn.mseven.wedget.animation.Fall.class),
    Newspager(NewsPaper.class),
    Fliph(FlipH.class),
    Flipv(FlipV.class),
    RotateBottom(com.mao.cn.mseven.wedget.animation.RotateBottom.class),
    RotateLeft(com.mao.cn.mseven.wedget.animation.RotateLeft.class),
    Slit(com.mao.cn.mseven.wedget.animation.Slit.class),
    Shake(com.mao.cn.mseven.wedget.animation.Shake.class),
    ShakeUpAndDown(ShakeY.class),
    Sidefill(SideFall.class),
    RotateH(com.mao.cn.mseven.wedget.animation.RotateH.class),
    SlideBottomForCoinNum(com.mao.cn.mseven.wedget.animation.SlideBottomForCoinNum.class),
    ScaleBig(com.mao.cn.mseven.wedget.animation.ScaleBig.class),
    ImageViewScaleXY(com.mao.cn.mseven.wedget.animation.ImageViewScaleXY.class);

    private Class<? extends BaseEffects> effectsClazz;

    private Effectstype(Class<? extends BaseEffects> mclass) {
        effectsClazz = mclass;
    }

    public BaseEffects getAnimator() {
        BaseEffects bEffects = null;
        try {
            bEffects = effectsClazz.newInstance();
        } catch (ClassCastException e) {
            throw new Error("Can not init animatorClazz instance");
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            throw new Error("Can not init animatorClazz instance");
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new Error("Can not init animatorClazz instance");
        }
        return bEffects;
    }
}
