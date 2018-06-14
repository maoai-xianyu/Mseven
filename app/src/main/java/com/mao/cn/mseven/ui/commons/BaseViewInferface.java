package com.mao.cn.mseven.ui.commons;

import com.mao.cn.mseven.common.CommViewInterface;
import com.mao.cn.mseven.converter.RetrofitError;

/**
 * Created by zhangkun on 2017/6/9.
 */

public interface BaseViewInferface extends CommViewInterface {


    void interError(RetrofitError error);

    void interError(Throwable throwable);
}
