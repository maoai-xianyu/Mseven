// +----------------------------------------------------------------------
// | Project:   Mseven
// +----------------------------------------------------------------------
// | CreateTime: 09/05/2017 15:48 下午
// +----------------------------------------------------------------------
// | Author:     xab(xy@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.mao.cn.mseven.R;
import com.mao.cn.mseven.contants.KeyMaps;
import com.mao.cn.mseven.di.component.AppComponent;
import com.mao.cn.mseven.di.component.DaggerLoginWithVideoComponent;
import com.mao.cn.mseven.di.modules.LoginWithVideoModule;
import com.mao.cn.mseven.ui.commons.BaseActivity;
import com.mao.cn.mseven.ui.features.ILoginWithVideo;
import com.mao.cn.mseven.ui.presenter.LoginWithVideoPresenter;
import com.mao.cn.mseven.utils.tools.LogU;
import com.mao.cn.mseven.utils.tools.PreferenceU;
import com.mao.cn.mseven.wedget.videoview.MeasureUtil;
import com.mao.cn.mseven.wedget.videoview.SystemVideoView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * DESC   :
 * AUTHOR : Xabad
 */
public class LoginWithVideoActivity extends BaseActivity implements ILoginWithVideo {

    @Inject
    LoginWithVideoPresenter presenter;

    @BindView(R.id.svv)
    SystemVideoView videoView;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_find_pwd)
    TextView tvFindPwd;
    @BindView(R.id.btn_enter)
    Button btnEnter;
    @BindView(R.id.tv_jump)
    TextView tvJump;

    @Override
    public void getArgs(Bundle bundle) {

    }

    @Override
    public int setView() {
        return R.layout.aty_login_with_video;
    }

    @Override
    public void initView() {
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.welcome_video);

        videoView.setDisplayAspectRatio(MeasureUtil.ASPECT_RATIO_PAVED_PARENT);
        videoView.setOnCorveHideListener(new SystemVideoView.OnCorveHideListener() {
            @Override
            public void requestHide() {
                //loginActivityBinding.corver.setVisibility(View.GONE);
            }
        });
        videoView.setVideoURI(videoUri);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.seekTo(0);
                videoView.start();
            }
        });

        /*videoView.setVideoURI(videoUri);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.setVideoURI(videoUri);
                videoView.start();
            }
        });*/

    }

    @Override
    public void setListener() {

        RxView.clicks(btnEnter).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(aVoid -> {
            PreferenceU.getInstance(this).saveBoolean(KeyMaps.UserConfig.USER_LOGIN, true);
            startActivity(MainActivity.class, true);
        }, throwable -> LogU.e(throwable.getMessage()));

        RxView.clicks(tvJump).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(aVoid -> {
            startActivity(MainActivity.class, true);
        }, throwable -> LogU.e(throwable.getMessage()));


    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerLoginWithVideoComponent.builder()
                .appComponent(appComponent)
                .loginWithVideoModule(new LoginWithVideoModule(this))
                .build().inject(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        videoView.start();
    }

}
