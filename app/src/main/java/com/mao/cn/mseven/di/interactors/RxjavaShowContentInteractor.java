// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 08/04/2017 16:53 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.di.interactors;

import com.mao.cn.mseven.http.HttpApi;
import com.mao.cn.mseven.http.RestApiAdapter;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * DESC   :
 * AUTHOR : Xabad
 */
public class RxjavaShowContentInteractor {

    @Inject
    public RxjavaShowContentInteractor() {

    }

    public Observable<String> getMovieTop(int start, int count) {
        HttpApi httpApi = RestApiAdapter.getStringInstance().create(HttpApi.class);
        return httpApi.getTodayMovie(start, count);
    }


}
