package com.chen.loading;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chen.library.SpinKitView;
import com.chen.library.SpriteFactory;
import com.chen.library.Style;
import com.chen.library.sprite.Sprite;

/**
 * Created by chen.
 */
public class DetailActivity extends AppCompatActivity implements Colors {

    public static void start(Context context, int position) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(0);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Style.values().length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_pager, null);

                SpinKitView spinKitView = (SpinKitView) view.findViewById(R.id.spin_kit);
                TextView name = (TextView) view.findViewById(R.id.name);
                Style style = Style.values()[position];
                name.setText(style.name());
                Sprite drawable = SpriteFactory.create(style);
                spinKitView.setIndeterminateDrawable(drawable);
                container.addView(view);

                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int color = (int) ArgbEvaluator.getInstance().evaluate(positionOffset, colors[position % colors.length], colors[(position + 1) % colors.length]);
                getWindow().getDecorView().setBackgroundColor(color);
            }

            @Override
            public void onPageSelected(int position) {
                getWindow().getDecorView().setBackgroundColor(colors[position % colors.length]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(getIntent().getIntExtra("position", 0));

    }
}
