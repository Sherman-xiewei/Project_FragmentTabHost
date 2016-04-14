package inventec.icc.project_fragmenttabhost;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import inventec.icc.project_fragmenttabhost.bean.Tab;
import inventec.icc.project_fragmenttabhost.fragment.HomeFragment;
import inventec.icc.project_fragmenttabhost.fragment.ListFragment;
import inventec.icc.project_fragmenttabhost.fragment.InfoFragment;
import inventec.icc.project_fragmenttabhost.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater mLayoutInflater;
    private List<Tab> mTabs = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabs.add(new Tab(R.string.home, R.drawable.mainpage_bg, HomeFragment.class));
        mTabs.add(new Tab(R.string.list, R.drawable.mainpage_class_bg, ListFragment.class));
        mTabs.add(new Tab(R.string.info, R.drawable.mainpage_info_bg, InfoFragment.class));
        mTabs.add(new Tab(R.string.me,R.drawable.mainpage_my_bg, MeFragment.class));

        mLayoutInflater = LayoutInflater.from(this);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(getTabItemView(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }

        //去掉分割线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        //默认选择第一个
        mTabHost.setCurrentTab(0);
    }

    private View getTabItemView(Tab tab) {
        View view = mLayoutInflater.inflate(R.layout.tab_item_view, null);
        ImageView img = (ImageView) view.findViewById(R.id.imageview);
        TextView text = (TextView) view.findViewById(R.id.textview);
        img.setBackgroundResource(tab.getIco());
        text.setText(tab.getTitle());
        return view;
    }

}
