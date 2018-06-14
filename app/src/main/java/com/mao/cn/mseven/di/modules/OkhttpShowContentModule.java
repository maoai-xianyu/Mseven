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


import com.mao.cn.mseven.di.interactors.OkhttpShowContentInteractor;
import com.mao.cn.mseven.ui.features.IOkhttpShowContent;
import com.mao.cn.mseven.ui.presenter.OkhttpShowContentPresenter;
import com.mao.cn.mseven.ui.presenterimp.OkhttpShowContentPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module
public class OkhttpShowContentModule {

    private IOkhttpShowContent viewInterface;

    public OkhttpShowContentModule(IOkhttpShowContent viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Provides
    public IOkhttpShowContent getViewInterface() {
        return viewInterface;
    }
    @Provides
    public OkhttpShowContentPresenter getPresenter(IOkhttpShowContent viewInterface,OkhttpShowContentInteractor okhttpShowContentInteractor){
        return new OkhttpShowContentPresenterImp(viewInterface,okhttpShowContentInteractor);
    }
}