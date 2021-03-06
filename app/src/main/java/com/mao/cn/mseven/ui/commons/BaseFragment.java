package com.mao.cn.mseven.ui.commons;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.mao.cn.mseven.MsevenApplication;
import com.mao.cn.mseven.common.CommFragment;
import com.mao.cn.mseven.di.component.AppComponent;
import com.mao.cn.mseven.contants.ValueMaps;
import com.mao.cn.mseven.converter.RetrofitError;
import com.mao.cn.mseven.utils.tools.JsonU;
import com.mao.cn.mseven.utils.tools.LogU;
import com.mao.cn.mseven.utils.tools.StringU;
import com.mao.cn.mseven.wedget.dialog.LoadingDialog;

import java.lang.reflect.Field;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.adapter.rxjava.HttpException;

public abstract class BaseFragment extends CommFragment implements BaseViewInferface {


    protected LoadingDialog loadingDialog;

    @Override
    public void setting() {
        LogU.d("当前的fragment " + getClass().getName());
        setupComponent(MsevenApplication.getComponent());
    }


    protected abstract void getArgs(Bundle bundle);

    protected abstract int setView();

    protected abstract void setupComponent(AppComponent appComponent);

    //用于修改 java.lang.IllegalStateException: No host 异常
    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void interError(RetrofitError error) {
        int status = error.getCode();
        if (status == RetrofitError.ERROR_CONNECTION) {
            return;
        }
        switch (error.getCode()) {
            case ValueMaps.ResponeCode.TYPE_CODE_401:
                String content = JsonU.getString(error.getBody(), "error");
                if (activity instanceof BaseActivity) {
                    if (StringU.isEmpty(content)) {
                        ((BaseActivity) activity).accessError(error.getRequestUrl());
                    } else {
                        ((BaseActivity) activity).accessError(content, error.getRequestUrl());
                    }
                }
                break;
            case ValueMaps.ResponeCode.TYPE_CODE_404:
                break;
            case ValueMaps.ResponeCode.TYPE_CODE_500:
                break;
            case ValueMaps.ResponeCode.TYPE_CODE_501:
                break;
            case ValueMaps.ResponeCode.TYPE_CODE_502:
                break;
            case ValueMaps.ResponeCode.TYPE_CODE_503:
                break;
            default:
                break;
        }
    }

    @Override
    public void interError(Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            if (httpException.code() == ValueMaps.ResponeCode.TYPE_CODE_401) {
                ((BaseActivity) activity).accessError("");
            }
        }
    }

    @Override
    public void showLoadingDialog(final String str) {
        if (!checkActivityState()) return;
        activity.runOnUiThread(() -> {
            if (loadingDialog == null) {
                loadingDialog = new LoadingDialog(activity);
            }
            loadingDialog.show(str);
        });
    }

    @Override
    public void showLoadingDialog(int i) {
        if (!checkActivityState()) return;
        showLoadingDialog(getString(i));

    }

    @Override
    public void hideLoadingDialog() {
        if (!checkActivityState()) return;
        activity.runOnUiThread(() -> {
            if (loadingDialog != null && loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
        });
    }

    @Override
    public void onTip(final String tipInfo) {
        if (!checkActivityState()) return;
        activity.runOnUiThread(() -> Toast.makeText(context, tipInfo, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onTip(int i) {
        if (!checkActivityState()) return;
        onTip(getString(i));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    // 检测当前的activity 是否被销毁
    protected boolean checkActivityState() {
        return activity != null
                && !activity.isFinishing()
                && isAdded();
    }

    // 检测当前的activity fragment 是否被销毁
    protected boolean checkActivityAndFragmentState() {
        return activity != null
                && !activity.isFinishing()
                && isAdded()
                && (getParentFragment() != null && getParentFragment().getUserVisibleHint());
    }


    // 处理事件的方法
    protected <T> ObservableTransformer<T, T> timer() {
        return observable -> observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
