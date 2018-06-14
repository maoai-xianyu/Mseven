// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.component;

import com.mao.cn.mseven.di.commons.ActivityScope;
import com.mao.cn.mseven.di.interactors.RxjavaShowContentInteractor;
import com.mao.cn.mseven.di.modules.RxjavaShowContentModule;
import com.mao.cn.mseven.ui.activity.RxjavaShowContentActivity;
import com.mao.cn.mseven.ui.features.IRxjavaShowContent;
import com.mao.cn.mseven.ui.presenter.RxjavaShowContentPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = RxjavaShowContentModule.class
)
public interface RxjavaShowContentComponent {
    void inject(RxjavaShowContentActivity instance);

    IRxjavaShowContent getViewInterface();

    RxjavaShowContentPresenter getPresenter();

    RxjavaShowContentInteractor getRxjavaShowContentInteractor();

}
