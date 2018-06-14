// +----------------------------------------------------------------------
// | Project:   Mseven
// +----------------------------------------------------------------------
// | CreateTime: 09/05/2017 15:48 下午
// +----------------------------------------------------------------------
// | Author:     xab(xy@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.modules;


import com.mao.cn.mseven.di.interactors.LoginWithVideoInteractor;
import com.mao.cn.mseven.ui.features.ILoginWithVideo;
import com.mao.cn.mseven.ui.presenter.LoginWithVideoPresenter;
import com.mao.cn.mseven.ui.presenterimp.LoginWithVideoPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginWithVideoModule {

    private ILoginWithVideo viewInterface;

    public LoginWithVideoModule(ILoginWithVideo viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Provides
    public ILoginWithVideo getViewInterface() {
        return viewInterface;
    }
    @Provides
    public LoginWithVideoPresenter getPresenter(ILoginWithVideo viewInterface, LoginWithVideoInteractor loginWithVideoInteractor){
        return new LoginWithVideoPresenterImp(viewInterface,loginWithVideoInteractor);
    }
}