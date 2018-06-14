// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/16/2017 15:27 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.component;

import com.mao.cn.mseven.di.commons.ActivityScope;
import com.mao.cn.mseven.di.interactors.RxjavaLearnRxBingdingInteractor;
import com.mao.cn.mseven.di.modules.RxjavaLearnRxBingdingModule;
import com.mao.cn.mseven.ui.activity.RxjavaLearnRxBingdingActivity;
import com.mao.cn.mseven.ui.features.IRxjavaLearnRxBingding;
import com.mao.cn.mseven.ui.presenter.RxjavaLearnRxBingdingPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = RxjavaLearnRxBingdingModule.class
)
public interface RxjavaLearnRxBingdingComponent {
    void inject(RxjavaLearnRxBingdingActivity instance);

    IRxjavaLearnRxBingding getViewInterface();

    RxjavaLearnRxBingdingPresenter getPresenter();

    RxjavaLearnRxBingdingInteractor getRxjavaLearnRxBingdingInteractor();

}
