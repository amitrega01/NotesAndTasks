package pl.insudev.notes;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import pl.insudev.notes.Adapters.MyViewPagerAdapter;
import pl.insudev.notes.Fragments.BottomMenuFragment;
import pl.insudev.notes.Fragments.TasksFragment;
import pl.insudev.notes.Fragments.TopMenuFragment;
import pl.insudev.notes.Models.Task;

public class MainActivity extends AppCompatActivity implements TopMenuFragment.MyActivityListener, BottomMenuFragment.MyListener {


    public static AppDBHelper appDBHelper;
    private TopMenuFragment topMenuFragment;
    private BottomMenuFragment bottomMenuFragment;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDBHelper = new AppDBHelper(this);


        bottomMenuFragment = (BottomMenuFragment) getSupportFragmentManager().findFragmentById(R.id.bottomFragment);
        bottomMenuFragment.setText(AppDBHelper.appDB.tasks.get(0).listTitle);

        topMenuFragment = (TopMenuFragment) getSupportFragmentManager().findFragmentById(R.id.topFragment);

        viewPager = findViewById(R.id.viewPager);
        SmartFragmentStatePagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) topMenuFragment.changeOption(true);
                else topMenuFragment.changeOption(false);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        TasksFragment tasksFragment = (TasksFragment) adapter.getRegisteredFragment(0);


    }


    @Override
    public void sendOption(boolean option) {
        if (option) viewPager.setCurrentItem(0, true);
        else viewPager.setCurrentItem(1, true);
    }


    @Override
    public void AddTask(Task task, String title) {
        appDBHelper.addItem(task, title);
    }
}
