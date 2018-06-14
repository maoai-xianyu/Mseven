// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.presenterimp;

import com.google.gson.JsonSyntaxException;
import com.mao.cn.mseven.R;
import com.mao.cn.mseven.di.interactors.RxjavaShowContentInteractor;
import com.mao.cn.mseven.model.Movie;
import com.mao.cn.mseven.ui.commons.BasePresenterImp;
import com.mao.cn.mseven.ui.features.IRxjavaShowContent;
import com.mao.cn.mseven.ui.presenter.RxjavaShowContentPresenter;
import com.mao.cn.mseven.utils.network.NetworkUtils;
import com.mao.cn.mseven.utils.tools.GsonU;
import com.mao.cn.mseven.utils.tools.ListU;
import com.mao.cn.mseven.utils.tools.StringU;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;


/**
 * DESC   :
 * AUTHOR : Xabad
 */
public class RxjavaShowContentPresenterImp extends BasePresenterImp implements RxjavaShowContentPresenter {
    RxjavaShowContentInteractor interactor;
    IRxjavaShowContent viewInterface;
    private  CompositeDisposable comDisposable;

    public RxjavaShowContentPresenterImp(IRxjavaShowContent viewInterface, RxjavaShowContentInteractor rxjavaShowContentInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = rxjavaShowContentInteractor;
        this.comDisposable = new CompositeDisposable();
    }

    @Override
    public void getMovieTop(int start, int count) {
        if (!NetworkUtils.isConnected(context)) {
            viewInterface.onTip(context.getString(R.string.no_connect_net));
            return;
        }
        viewInterface.showLoadingDialog("");
        Observable<String> observable = interactor.getMovieTop(start, count).onTerminateDetach().flatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull String s) throws Exception {
                return Observable.just(s);
            }
        }).compose(applyIoSchedulers());
        Disposable disposable = observable.subscribe(s -> {
            viewInterface.hideLoadingDialog();
            Movie convert = null;
            try {
                convert = GsonU.convert(s, Movie.class);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
            if (convert != null && StringU.isNotEmpty(convert.getTitle()) && ListU.notEmpty(convert.getSubjects())) {
                viewInterface.showTopMovie(convert.getSubjects(), convert.getTitle());
            } else {
                viewInterface.showTopMovie(null, "");
            }
        }, throwable -> {
            viewInterface.hideLoadingDialog();
            viewInterface.interError(throwable);
            viewInterface.showTopMovie(null, "");
        });

        if (comDisposable != null) {
            comDisposable.add(disposable);
        }
    }


    @Override
    public void onDestroySubscribe() {
        if (comDisposable != null) {
            comDisposable.dispose();
        }
    }
}
