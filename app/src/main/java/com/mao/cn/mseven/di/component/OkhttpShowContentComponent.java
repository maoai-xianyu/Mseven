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
import com.mao.cn.mseven.di.interactors.OkhttpShowContentInteractor;
import com.mao.cn.mseven.di.modules.OkhttpShowContentModule;
import com.mao.cn.mseven.ui.activity.OkhttpShowContentActivity;
import com.mao.cn.mseven.ui.features.IOkhttpShowContent;
import com.mao.cn.mseven.ui.presenter.OkhttpShowContentPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = OkhttpShowContentModule.class
)
public interface OkhttpShowContentComponent {
    void inject(OkhttpShowContentActivity instance);

    IOkhttpShowContent getViewInterface();

    OkhttpShowContentPresenter getPresenter();

    OkhttpShowContentInteractor getOkhttpShowContentInteractor();

}
