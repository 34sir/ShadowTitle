package com.example.chukc.shadowtitle;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends BaseActivity {
    ObservableScrollView scroll;
    Toolbar toolbar;
    private FragmentOne fragment1;
    private FragmentTwo fragment2;
    private ViewPager viewpager;
    private ArrayList<Fragment> fragmentArray;
    private TabFragmentPagerAdapter mFragmentPagerAdapter;
    private TextView tab1, tab2;// 页卡头标
    private List<View> listViews; // Tab页面列表
    private View view_tab1, view_tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.fragment_main);
	InitView();
	InitViewPager();
    }
    /**
     * 初始化头标
     */
    private void InitView() {
	tab1 = (TextView) findViewById(R.id.tab1);
	tab2 = (TextView) findViewById(R.id.tab2);
	view_tab1 = findViewById(R.id.view_tab1);
	view_tab2 = findViewById(R.id.view_tab2);

	listViews = new ArrayList<View>();
	listViews.add(tab1);
	listViews.add(tab2);
	tab1.setOnClickListener(new MyOnClickListener(0));
	tab2.setOnClickListener(new MyOnClickListener(1));
    }

    /**
     * 初始化ViewPager
     */
    private void InitViewPager() {
	fragment1 = new FragmentOne();
	fragment2 = new FragmentTwo();

	viewpager = (ViewPager) findViewById(R.id.viewpager);
	fragmentArray = new ArrayList<Fragment>();
	fragmentArray.add(fragment1);
	fragmentArray.add(fragment2);
	FragmentManager mFragmentManager = ((FragmentActivity) this).getSupportFragmentManager();
	mFragmentPagerAdapter = new TabFragmentPagerAdapter(mFragmentManager, fragmentArray);
	viewpager.setAdapter(mFragmentPagerAdapter);
	viewpager.setCurrentItem(0);
	viewpager.setOnPageChangeListener(new MyOnPageChangeListener());

    }

    /**
     * 头标点击监听
     */
    public class MyOnClickListener implements View.OnClickListener {
	int index = 0;

	public MyOnClickListener(int i) {
	    index = i;
	}

	@Override
	public void onClick(View v) {
	    viewpager.setCurrentItem(index);
	}
    };
    /**
     * 页卡切换监听
     */
    public class MyOnPageChangeListener implements OnPageChangeListener {

	@Override
	public void onPageSelected(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}
    }

    public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

  	private ArrayList<Fragment> mFragmentList = null;

  	public TabFragmentPagerAdapter(FragmentManager mFragmentManager, ArrayList<Fragment> fragmentList) {
  	    super(mFragmentManager);
  	    mFragmentList = fragmentList;
  	}

  	@Override
  	public int getCount() {
  	    return mFragmentList.size();
  	}

  	@Override
  	public Fragment getItem(int position) {

  	    Fragment fragment = null;
  	    if (position < mFragmentList.size()) {
  		fragment = mFragmentList.get(position);
  	    } else {
  		fragment = mFragmentList.get(0);
  	    }
  	    return fragment;

  	}
      }

}