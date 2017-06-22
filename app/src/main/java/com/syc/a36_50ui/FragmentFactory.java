package com.syc.a36_50ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * 类描述:
 * 创建人:一一哥
 * 创建时间:16/10/17 14:38
 * 备注:
 */

public class FragmentFactory {

    //private List<Fragment>=new ArrayList();

    //SparseArray:该集合的索引默认就是整形值
    private static SparseArray<Fragment> fragments = new SparseArray<>();
    static final int INDEX_ARMY = 0;
    static final int INDEX_ENTERMAIN = 1;
    static final int INDEX_SOCIETY = 2;
    static final int INDEX_KEJI = 3;
    static final int INDEX_SPORT = 4;

    static Fragment createFragment(int index,String msg) {
        //从集合中找
        Fragment fragment = fragments.get(index);
        if (fragment == null) {
            switch (index) {
                case INDEX_ARMY:
                case INDEX_ENTERMAIN:
                case INDEX_SOCIETY:
                case INDEX_KEJI:
                case INDEX_SPORT:
                    fragment = ContentFragment.newInstance(msg);
                    //存到集合中
                    fragments.put(index, fragment);
                    break;
            }
        }

        return fragment;
    }

}
