package dzikirqu.smk.com.jogjaunity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dzikirqu.smk.com.jogjaunity.FragmentKuliner.Jajanan;
import dzikirqu.smk.com.jogjaunity.FragmentKuliner.Masakan;
import dzikirqu.smk.com.jogjaunity.FragmentKuliner.Minuman;

public class KulinerActivity extends AppCompatActivity {
    TabLayout tabKuliner;
    ViewPager vpKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);

        tabKuliner = (TabLayout) findViewById(R.id.tabKuliner);
        vpKuliner = (ViewPager) findViewById(R.id.vpKuliner);

        tabKuliner.setupWithViewPager(vpKuliner);
        SetupViewPager(vpKuliner);
        tabKuliner.setTabTextColors(
                ContextCompat.getColor(getApplicationContext(), R.color.colorWhite),
                ContextCompat.getColor(getApplicationContext(), R.color.colorWhite)
        );
    }

    private void SetupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Masakan(), "Masakan");
        adapter.addFragment(new Minuman(), "Minuman");
        adapter.addFragment(new Jajanan(), "Jajanan");
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> nameList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        //method menambahkan fragment
        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            nameList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return nameList.get(position);
        }
        //setting nama tabs


    }
}
