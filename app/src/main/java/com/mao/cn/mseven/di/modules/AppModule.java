package com.mao.cn.mseven.di.modules;

import android.app.Application;

import com.mao.cn.mseven.MsevenApplication;
import com.mao.cn.mseven.utils.tools.PreferenceU;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final MsevenApplication app;

    public AppModule(MsevenApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return MsevenApplication.getInstance();
    }

    @Provides
    @Singleton
    PreferenceU providePreferenceU() {
        return PreferenceU.getInstance(MsevenApplication.context());
    }

}