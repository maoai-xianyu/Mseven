// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/09/2017 19:56 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.component;

import com.mao.cn.mseven.di.commons.ActivityScope;
import com.mao.cn.mseven.di.interactors.RxjavaLearnDetailInteractor;
import com.mao.cn.mseven.di.modules.RxjavaLearnDetailModule;
import com.mao.cn.mseven.ui.activity.RxJavaLearnDetailActivity;
import com.mao.cn.mseven.ui.features.IRxjavaLearnDetail;
import com.mao.cn.mseven.ui.presenter.RxjavaLearnDetailPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = RxjavaLearnDetailModule.class
)
public interface RxjavaLearnDetailComponent {
    void inject(RxJavaLearnDetailActivity instance);

    IRxjavaLearnDetail getViewInterface();

    RxjavaLearnDetailPresenter getPresenter();

    RxjavaLearnDetailInteractor getRxjavaLearnDetailInteractor();

}
