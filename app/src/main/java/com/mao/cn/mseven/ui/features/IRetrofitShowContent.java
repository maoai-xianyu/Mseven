// +----------------------------------------------------------------------
// | Project:   LearnMyDevelopProject
// +----------------------------------------------------------------------
// | CreateTime: 08/08/2017 16:39 下午
// +----------------------------------------------------------------------
// | Author:     xab(xab@xabad.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------
package com.mao.cn.mseven.ui.features;

import com.mao.cn.mseven.model.MovieDetail;
import com.mao.cn.mseven.ui.commons.BaseViewInferface;

import java.util.List;

/**
* DESC   :
* AUTHOR : Xabad
*/
public interface IRetrofitShowContent extends BaseViewInferface{
    void showTopMovie(List<MovieDetail> subjects, String title);
}
