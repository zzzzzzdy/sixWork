package activitytest.exmaple.com.chongyouapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this,"您到了第"+tab.getPosition()+"页面",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initData() {
        for(int i=0; i<10; i++)
        {
            tabs.add("热门");
            tabs.add("动态");
            tabs.add("资讯");
            for(int j = 0;j<3;j++)
            {
                            TabFragment simpleFragment = new TabFragment();
            int[] imageIds = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
            simpleFragment.setData(imageIds[j%3],tabs.get(j));
            fragments.add(simpleFragment);

            }

        }


    }
//    private void initViews() {
//        mTabLayout = findViewById(R.id.tab_layout);
//        mViewPager = findViewById(R.id.view_pager);
//        List<String> titles = new ArrayList<>();
//        List<SimpleFragment> fragmentList = new ArrayList<>();
//
//        for (int i = 0; i < 3; i++) {
//            //生成30个title 和 fragment
//            titles.add("第"+(i+1)+"个");
//            SimpleFragment simpleFragment = new SimpleFragment();
//            int[] imageIds = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
//            simpleFragment.setData(imageIds[i%4],"我是第"+(i+1)+"个Fragment");
//            fragmentList.add(simpleFragment);
//        }
//
//
//        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
//        mViewPager.setAdapter(adapter);
//        mTabLayout.setupWithViewPager(mViewPager);
//    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tayLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        //关联ViewPager和TabLayout
        tabLayout.setupWithViewPager(viewPager);
    }

    class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //显示标签上的文字
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }
    }
}
