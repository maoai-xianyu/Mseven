// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 06/09/2017 11:36 上午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.component;

import com.mao.cn.mseven.di.commons.ActivityScope;
import com.mao.cn.mseven.di.interactors.LoadingInteractor;
import com.mao.cn.mseven.di.modules.LoadingModule;
import com.mao.cn.mseven.ui.activity.LoadingActivity;
import com.mao.cn.mseven.ui.features.ILoading;
import com.mao.cn.mseven.ui.presenter.LoadingPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = LoadingModule.class
)
public interface LoadingComponent {
    void inject(LoadingActivity instance);

    ILoading getViewInterface();

    LoadingPresenter getPresenter();

    LoadingInteractor getLoadingInteractor();

}
