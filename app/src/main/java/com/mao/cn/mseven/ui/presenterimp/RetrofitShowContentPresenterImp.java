// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/08/2017 16:39 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.presenterimp;

import com.google.gson.JsonSyntaxException;
import com.mao.cn.mseven.R;
import com.mao.cn.mseven.callBack.StringCallback;
import com.mao.cn.mseven.converter.RetrofitError;
import com.mao.cn.mseven.di.interactors.RetrofitShowContentInteractor;
import com.mao.cn.mseven.model.Movie;
import com.mao.cn.mseven.ui.commons.BasePresenterImp;
import com.mao.cn.mseven.ui.features.IRetrofitShowContent;
import com.mao.cn.mseven.ui.presenter.RetrofitShowContentPresenter;
import com.mao.cn.mseven.utils.network.NetworkUtils;
import com.mao.cn.mseven.utils.tools.GsonU;
import com.mao.cn.mseven.utils.tools.ListU;
import com.mao.cn.mseven.utils.tools.LogU;
import com.mao.cn.mseven.utils.tools.StringU;

/**
* DESC   :
* AUTHOR : Xabad
*/
public class RetrofitShowContentPresenterImp extends BasePresenterImp implements RetrofitShowContentPresenter {
    RetrofitShowContentInteractor interactor;
    IRetrofitShowContent viewInterface;
    public RetrofitShowContentPresenterImp(IRetrofitShowContent viewInterface,RetrofitShowContentInteractor retrofitShowContentInteractor) {
        super();
        this.viewInterface = viewInterface;
        this.interactor = retrofitShowContentInteractor;
    }


    @Override
    public void getMovieTop(int start, int count) {
        if (!NetworkUtils.isConnected(context)) {
            viewInterface.onTip(context.getString(R.string.no_connect_net));
            return;
        }
        viewInterface.showLoadingDialog("");
        interactor.getMovieTop(start, count, new StringCallback() {
            @Override
            public void success(String response) {
                viewInterface.hideLoadingDialog();
                LogU.i(response);
                Movie convert = null;
                try {
                    convert = GsonU.convert(response, Movie.class);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                if (convert != null && StringU.isNotEmpty(convert.getTitle()) && ListU.notEmpty(convert.getSubjects())) {
                    viewInterface.showTopMovie(convert.getSubjects(), convert.getTitle());
                } else {
                    viewInterface.showTopMovie(null, "");
                }
            }

            @Override
            public void failure(RetrofitError var1) {
                viewInterface.hideLoadingDialog();
                viewInterface.interError(var1);
                viewInterface.showTopMovie(null, "");
            }
        });

    }
}
