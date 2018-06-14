// +----------------------------------------------------------------------
// | Project:   Mseven
// +----------------------------------------------------------------------
// | CreateTime: 09/05/2017 15:48 下午
// +----------------------------------------------------------------------
// | Author:     xab(xy@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.component;


import com.mao.cn.mseven.di.commons.ActivityScope;
import com.mao.cn.mseven.di.interactors.LoginWithVideoInteractor;
import com.mao.cn.mseven.di.modules.LoginWithVideoModule;
import com.mao.cn.mseven.ui.activity.LoginWithVideoActivity;
import com.mao.cn.mseven.ui.features.ILoginWithVideo;
import com.mao.cn.mseven.ui.presenter.LoginWithVideoPresenter;

import dagger.Component;

@ActivityScope

@Component(
        dependencies = AppComponent.class,
        modules = LoginWithVideoModule.class
)
public interface LoginWithVideoComponent {
void inject(LoginWithVideoActivity instance);

    ILoginWithVideo getViewInterface();

    LoginWithVideoPresenter getPresenter();

    LoginWithVideoInteractor getLoginWithVideoInteractor();

}
