// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/16/2017 15:27 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.presenterimp;

import com.mao.cn.mseven.di.interactors.RxjavaLearnRxBingdingInteractor;
import com.mao.cn.mseven.ui.commons.BasePresenterImp;
import com.mao.cn.mseven.ui.features.IRxjavaLearnRxBingding;
import com.mao.cn.mseven.ui.presenter.RxjavaLearnRxBingdingPresenter;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class RxjavaLearnRxBingdingPresenterImp extends BasePresenterImp implements RxjavaLearnRxBingdingPresenter {
    RxjavaLearnRxBingdingInteractor interactor;
    IRxjavaLearnRxBingding viewInterface;
    public RxjavaLearnRxBingdingPresenterImp(IRxjavaLearnRxBingding viewInterface,RxjavaLearnRxBingdingInteractor rxjavaLearnRxBingdingInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = rxjavaLearnRxBingdingInteractor;
    }
}
