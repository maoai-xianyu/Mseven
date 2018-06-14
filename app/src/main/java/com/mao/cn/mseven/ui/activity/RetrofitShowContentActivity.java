// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/08/2017 16:39 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.mao.cn.mseven.R;
import com.mao.cn.mseven.di.component.AppComponent;
import com.mao.cn.mseven.di.component.DaggerRetrofitShowContentComponent;
import com.mao.cn.mseven.contants.ValueMaps;
import com.mao.cn.mseven.model.MovieDetail;
import com.mao.cn.mseven.di.modules.RetrofitShowContentModule;
import com.mao.cn.mseven.ui.adapter.MovieTopAdapter;
import com.mao.cn.mseven.ui.commons.BaseActivity;
import com.mao.cn.mseven.ui.features.IRetrofitShowContent;
import com.mao.cn.mseven.ui.presenter.RetrofitShowContentPresenter;
import com.mao.cn.mseven.utils.tools.ListU;
import com.mao.cn.mseven.utils.tools.LogU;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * DESC   :
 * AUTHOR : Xabad
 */
public class RetrofitShowContentActivity extends BaseActivity implements IRetrofitShowContent {

    @Inject
    RetrofitShowContentPresenter presenter;

    @BindView(R.id.ib_header_back)
    ImageButton ibHeaderBack;
    @BindView(R.id.tv_header_title)
    TextView tvHeaderTitle;
    @BindView(R.id.rvData)
    RecyclerView rvData;

    @Override
    public void getArgs(Bundle bundle) {

    }

    @Override
    public int setView() {
        return R.layout.aty_retrofit_show_content;
    }

    @Override
    public void initView() {
        ibHeaderBack.setVisibility(View.VISIBLE);
        presenter.getMovieTop(0, 10);

    }

    @Override
    public void setListener() {
        RxView.clicks(ibHeaderBack).throttleFirst(ValueMaps.ClickTime.BREAK_TIME_MILLISECOND, TimeUnit
                .MILLISECONDS).subscribe(aVoid -> {
            finish();
        }, throwable -> {
            LogU.e(throwable.getMessage());
        });
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerRetrofitShowContentComponent.builder()
                .appComponent(appComponent)
                .retrofitShowContentModule(new RetrofitShowContentModule(this))
                .build().inject(this);
    }

    @Override
    public void showTopMovie(List<MovieDetail> subjects, String title) {
        if (!checkActivityState()) return;
        tvHeaderTitle.setVisibility(View.VISIBLE);
        tvHeaderTitle.setText(title);
        if (ListU.notEmpty(subjects)) {
            LinearLayoutManager linearLayoutCourse = new LinearLayoutManager(context);
            linearLayoutCourse.setOrientation(LinearLayoutManager.VERTICAL);
            rvData.setLayoutManager(linearLayoutCourse);

            MovieTopAdapter movieTopAdapter = new MovieTopAdapter(this);
            movieTopAdapter.addMovieList(subjects);
            rvData.setAdapter(movieTopAdapter);
        }
    }
}
