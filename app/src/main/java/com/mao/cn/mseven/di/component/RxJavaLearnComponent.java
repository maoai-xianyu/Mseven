// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/08/2017 18:35 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.component;

import com.mao.cn.mseven.di.commons.ActivityScope;
import com.mao.cn.mseven.di.interactors.RxJavaLearnInteractor;
import com.mao.cn.mseven.di.modules.RxJavaLearnModule;
import com.mao.cn.mseven.ui.activity.RxJavaLearnActivity;
import com.mao.cn.mseven.ui.features.IRxJavaLearn;
import com.mao.cn.mseven.ui.presenter.RxJavaLearnPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = RxJavaLearnModule.class
)
public interface RxJavaLearnComponent {
    void inject(RxJavaLearnActivity instance);

    IRxJavaLearn getViewInterface();

    RxJavaLearnPresenter getPresenter();

    RxJavaLearnInteractor getRxJavaLearnInteractor();

}
