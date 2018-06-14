// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 06/09/2017 11:36 上午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.presenterimp;

import com.mao.cn.mseven.di.interactors.LoadingInteractor;
import com.mao.cn.mseven.ui.commons.BasePresenterImp;
import com.mao.cn.mseven.ui.features.ILoading;
import com.mao.cn.mseven.ui.presenter.LoadingPresenter;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class LoadingPresenterImp extends BasePresenterImp implements LoadingPresenter {
    LoadingInteractor interactor;
    ILoading viewInterface;
    public LoadingPresenterImp(ILoading viewInterface,LoadingInteractor loadingInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = loadingInteractor;
    }
}
