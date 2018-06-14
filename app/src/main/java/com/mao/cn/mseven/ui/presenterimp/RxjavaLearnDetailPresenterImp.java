// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/09/2017 19:56 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.presenterimp;

import com.mao.cn.mseven.di.interactors.RxjavaLearnDetailInteractor;
import com.mao.cn.mseven.ui.commons.BasePresenterImp;
import com.mao.cn.mseven.ui.features.IRxjavaLearnDetail;
import com.mao.cn.mseven.ui.presenter.RxjavaLearnDetailPresenter;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class RxjavaLearnDetailPresenterImp extends BasePresenterImp implements RxjavaLearnDetailPresenter {
    RxjavaLearnDetailInteractor interactor;
    IRxjavaLearnDetail viewInterface;
    public RxjavaLearnDetailPresenterImp(IRxjavaLearnDetail viewInterface,RxjavaLearnDetailInteractor rxjavaLearnDetailInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = rxjavaLearnDetailInteractor;
    }
}
