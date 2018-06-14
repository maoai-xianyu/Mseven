// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.modules;


import com.mao.cn.mseven.di.interactors.RxjavaShowContentInteractor;
import com.mao.cn.mseven.ui.features.IRxjavaShowContent;
import com.mao.cn.mseven.ui.presenter.RxjavaShowContentPresenter;
import com.mao.cn.mseven.ui.presenterimp.RxjavaShowContentPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module
public class RxjavaShowContentModule {

    private IRxjavaShowContent viewInterface;

    public RxjavaShowContentModule(IRxjavaShowContent viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Provides
    public IRxjavaShowContent getViewInterface() {
        return viewInterface;
    }
    @Provides
    public RxjavaShowContentPresenter getPresenter(IRxjavaShowContent viewInterface,RxjavaShowContentInteractor rxjavaShowContentInteractor){
        return new RxjavaShowContentPresenterImp(viewInterface,rxjavaShowContentInteractor);
    }
}