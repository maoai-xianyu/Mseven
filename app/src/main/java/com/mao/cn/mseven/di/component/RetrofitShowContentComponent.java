// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/08/2017 16:39 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.component;

import com.mao.cn.mseven.di.commons.ActivityScope;
import com.mao.cn.mseven.di.interactors.RetrofitShowContentInteractor;
import com.mao.cn.mseven.di.modules.RetrofitShowContentModule;
import com.mao.cn.mseven.ui.activity.RetrofitShowContentActivity;
import com.mao.cn.mseven.ui.features.IRetrofitShowContent;
import com.mao.cn.mseven.ui.presenter.RetrofitShowContentPresenter;

import dagger.Component;

@ActivityScope

@Component(
    dependencies = AppComponent.class,
    modules = RetrofitShowContentModule.class
)
public interface RetrofitShowContentComponent {
    void inject(RetrofitShowContentActivity instance);

    IRetrofitShowContent getViewInterface();

    RetrofitShowContentPresenter getPresenter();

    RetrofitShowContentInteractor getRetrofitShowContentInteractor();

}
