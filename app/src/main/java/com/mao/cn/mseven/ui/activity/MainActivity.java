// +----------------------------------------------------------------------
// | Project:   MvpProject
// +----------------------------------------------------------------------
// | CreateTime: 06/09/2017 11:17 上午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.mao.cn.mseven.R;
import com.mao.cn.mseven.di.component.AppComponent;
import com.mao.cn.mseven.di.component.DaggerMainComponent;
import com.mao.cn.mseven.contants.ValueMaps;
import com.mao.cn.mseven.di.modules.MainModule;
import com.mao.cn.mseven.ui.commons.BaseActivity;
import com.mao.cn.mseven.ui.features.IMain;
import com.mao.cn.mseven.ui.presenter.MainPresenter;
import com.mao.cn.mseven.utils.tools.LogU;
import com.mao.cn.mseven.utils.tools.StringU;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * DESC   :
 * AUTHOR : Xabad
 */
public class MainActivity extends BaseActivity implements IMain {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.tv_header_title)
    TextView tvHeaderTitle;
    @BindView(R.id.btn_desc_net)
    Button btnDescNet;
    @BindView(R.id.btn_desc_rxjava)
    Button btnDescRxjava;
    @BindView(R.id.btn_desc_image)
    Button btnDescImage;


    @Override
    public void getArgs(Bundle bundle) {

    }

    @Override
    public int setView() {
        return R.layout.aty_main;
    }

    @Override
    public void initView() {
        tvHeaderTitle.setText(getString(R.string.header));
        tvHeaderTitle.setVisibility(View.VISIBLE);
        requestPermission();
    }

    @Override
    public void setListener() {

        RxView.clicks(btnDescNet).throttleFirst(ValueMaps.ClickTime.BREAK_TIME_MILLISECOND, TimeUnit
                .MILLISECONDS).subscribe(aVoid -> {
            startActivity(NetWorkRequestActivity.class);
        }, throwable -> {
            LogU.e(throwable.getMessage());
        });


        RxView.clicks(btnDescRxjava).throttleFirst(ValueMaps.ClickTime.BREAK_TIME_MILLISECOND, TimeUnit
                .MILLISECONDS).subscribe(aVoid -> {
            startActivity(RxJavaLearnActivity.class);
        }, throwable -> {
            LogU.e(throwable.getMessage());
        });

        RxView.clicks(btnDescImage).throttleFirst(ValueMaps.ClickTime.BREAK_TIME_MILLISECOND, TimeUnit
                .MILLISECONDS).subscribe(aVoid -> {
            startActivity(RetrofitShowContentActivity.class);
        }, throwable -> {
            LogU.e(throwable.getMessage());
        });
    }


    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build().inject(this);
    }

    /**
     * 获取需要操作日历的权限
     */
    private void requestPermission() {

        new RxPermissions(MainActivity.this)
                .requestEach(Manifest.permission.WRITE_CALENDAR,
                        Manifest.permission.READ_CALENDAR,
                        Manifest.permission.RECORD_AUDIO)
                .subscribe(permission -> {
                    if (permission.granted) {

                    } else {
                        if (StringU.equals(permission.name, Manifest.permission.RECORD_AUDIO)) {
                            onTip("未授予录音权限,将会影响语音朗读");
                        }
                    }

                }, throwable -> LogU.e("异常"));
    }
}
