// +----------------------------------------------------------------------
// | Project:   Mseven
// +----------------------------------------------------------------------
// | CreateTime: 09/05/2017 15:48 下午
// +----------------------------------------------------------------------
// | Author:     xab(xy@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.presenterimp;

import com.mao.cn.mseven.di.interactors.LoginWithVideoInteractor;
import com.mao.cn.mseven.ui.commons.BasePresenterImp;
import com.mao.cn.mseven.ui.features.ILoginWithVideo;
import com.mao.cn.mseven.ui.presenter.LoginWithVideoPresenter;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class LoginWithVideoPresenterImp extends BasePresenterImp implements LoginWithVideoPresenter {
    LoginWithVideoInteractor interactor;
    ILoginWithVideo viewInterface;
    public LoginWithVideoPresenterImp(ILoginWithVideo viewInterface,LoginWithVideoInteractor loginWithVideoInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = loginWithVideoInteractor;
    }
}
