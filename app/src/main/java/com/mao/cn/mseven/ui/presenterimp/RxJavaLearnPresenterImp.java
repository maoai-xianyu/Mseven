// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/08/2017 18:35 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.presenterimp;

import com.mao.cn.mseven.di.interactors.RxJavaLearnInteractor;
import com.mao.cn.mseven.ui.commons.BasePresenterImp;
import com.mao.cn.mseven.ui.features.IRxJavaLearn;
import com.mao.cn.mseven.ui.presenter.RxJavaLearnPresenter;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class RxJavaLearnPresenterImp extends BasePresenterImp implements RxJavaLearnPresenter {
    RxJavaLearnInteractor interactor;
    IRxJavaLearn viewInterface;
    public RxJavaLearnPresenterImp(IRxJavaLearn viewInterface,RxJavaLearnInteractor rxJavaLearnInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = rxJavaLearnInteractor;
    }
}
