package com.mao.cn.mseven.di.modules;

import android.app.Application;

import com.mao.cn.mseven.domain.AnalyticsManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {
    @Provides
    @Singleton
    public AnalyticsManager provideAnalyticsManager(Application app) {
        return new AnalyticsManager(app);
    }
}