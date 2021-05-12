package com.teknodate.tablayoutviewpagerfragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {
    private String[] tabTitle = new String[]{"Üç Zaman","Tek Zaman"};
    Context context;
    public SimpleFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context; }
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            UcZaman ucZaman = new UcZaman();
            return ucZaman;
        }else{
            TekZaman tekZaman = new TekZaman();
            return tekZaman; } }
    @Override
    public int getCount() {
        return tabTitle.length;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }}
