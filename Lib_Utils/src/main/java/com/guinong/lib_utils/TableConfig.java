package com.guinong.lib_utils;

/**
 * @author wangyu
 * @time 2017/4/12 11:08
 * @desc 底部选项卡
 */
public class TableConfig {

    public int titleId;
    public Class<?> targetClass;
    public int tabImage;

    public TableConfig(int titleId, Class<?> targetClass, int tabImage) {
        this.titleId = titleId;
        this.targetClass = targetClass;
        this.tabImage = tabImage;
    }
}
