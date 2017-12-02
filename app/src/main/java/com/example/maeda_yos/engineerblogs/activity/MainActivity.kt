package com.example.maeda_yos.engineerblogs.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.maeda_yos.engineerblogs.R
import com.example.maeda_yos.engineerblogs.fragment.BlogFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // xmlからTabLayoutの取得
        val tabLayout = findViewById<View>(R.id.tabs) as SmartTabLayout
        // xmlからViewPagerを取得
        val viewPager = findViewById<View>(R.id.pager) as ViewPager

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add(R.string.recruit_mp, BlogFragment::class.java, BlogFragment.arguments(R.string.recruit_mp))
                .add(R.string.eureka, BlogFragment::class.java, BlogFragment.arguments(R.string.eureka))
                .create()
        )

        viewPager.adapter = adapter
        tabLayout.setViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

}
