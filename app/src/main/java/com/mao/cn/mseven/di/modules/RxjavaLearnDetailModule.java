// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/09/2017 19:56 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.modules;


import com.mao.cn.mseven.di.interactors.RxjavaLearnDetailInteractor;
import com.mao.cn.mseven.ui.features.IRxjavaLearnDetail;
import com.mao.cn.mseven.ui.presenter.RxjavaLearnDetailPresenter;
import com.mao.cn.mseven.ui.presenterimp.RxjavaLearnDetailPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module
public class RxjavaLearnDetailModule {

    private IRxjavaLearnDetail viewInterface;

    public RxjavaLearnDetailModule(IRxjavaLearnDetail viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Provides
    public IRxjavaLearnDetail getViewInterface() {
        return viewInterface;
    }
    @Provides
    public RxjavaLearnDetailPresenter getPresenter(IRxjavaLearnDetail viewInterface, RxjavaLearnDetailInteractor rxjavaLearnDetailInteractor){
        return new RxjavaLearnDetailPresenterImp(viewInterface,rxjavaLearnDetailInteractor);
    }
}