package com.bruno.bootstrap;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 16/4/20.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    static List fragments = new ArrayList();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments.isEmpty()) {
            getFragment();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(fragments);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return (Fragment) fragments.get(position);
    }

    private void getFragment() {
        fragments.add(new HomeFragment());
        fragments.add(new WebViewActivity());
        fragments.add(new MeFragment());
    }

    @Override
    public int getCount() {
        return 3;
    }
}
