package com.mao.cn.mseven.di.component;

import com.mao.cn.mseven.MsevenApplication;
import com.mao.cn.mseven.di.modules.AppModule;
import com.mao.cn.mseven.di.modules.DomainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        DomainModule.class
})
public interface AppComponent {
    void inject(MsevenApplication instance);
}