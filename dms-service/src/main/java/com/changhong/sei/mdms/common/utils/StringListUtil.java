package com.changhong.sei.mdms.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现功能: 字符串数组工具类
 *
 * @author 王锦光 wangjg
 * @version 2020-03-25 16:17
 */
public class StringListUtil {
    /**
     * 将一个数组拆分成多个
     *
     * @param targ 个数
     */
    public static List<List<String>> getList(int targ, List<String> mList) {
        if (targ <= 0) {
            return new ArrayList<>();
        }
        List<List<String>> mEndList = new ArrayList<>();
        if (mList.size() % targ != 0) {
            for (int j = 0; j < mList.size() / targ + 1; j++) {
                if ((j * targ + targ) < mList.size()) {
                    //0-3,4-7,8-11    j=0,j+3=3   j=j*3+1
                    mEndList.add(mList.subList(j * targ, j * targ + targ));
                } else if ((j * targ + targ) > mList.size()) {
                    mEndList.add(mList.subList(j * targ, mList.size()));
                } else if (mList.size() < targ) {
                    mEndList.add(mList.subList(0, mList.size()));
                }
            }
        } else if (mList.size() % targ == 0) {
            for (int j = 0; j < mList.size() / targ; j++) {
                if ((j * targ + targ) <= mList.size()) {
                    //0-3,4-7,8-11    j=0,j+3=3   j=j*3+1
                    mEndList.add(mList.subList(j * targ, j * targ + targ));
                } else if ((j * targ + targ) > mList.size()) {
                    mEndList.add(mList.subList(j * targ, mList.size()));
                } else if (mList.size() < targ) {
                    mEndList.add(mList.subList(0, mList.size()));
                }
            }
        }
        return mEndList;
    }
}
