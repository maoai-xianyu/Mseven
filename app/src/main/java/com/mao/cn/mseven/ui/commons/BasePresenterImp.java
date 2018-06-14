package com.mao.cn.mseven.ui.commons;

import android.content.Context;

import com.mao.cn.mseven.MsevenApplication;
import com.mao.cn.mseven.utils.tools.PreferenceU;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


// +----------------------------------------------------------------------
// | CreateTime: 15/8/12 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.xueyong.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public abstract class BasePresenterImp implements BasePresenter {
    protected Context context;
    protected PreferenceU preferenceU;

    public BasePresenterImp() {
        this.context = MsevenApplication.context();
        this.preferenceU = PreferenceU.getInstance(MsevenApplication.context());

    }

    protected <T> ObservableTransformer<T, T> applyIoSchedulers() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
