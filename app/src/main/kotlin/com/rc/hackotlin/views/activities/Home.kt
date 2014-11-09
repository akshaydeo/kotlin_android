/**
 * Created by akshay on 07/11/14.
 */

package com.rc.hackotlin.views.activities;

import android.support.v7.app.ActionBarActivity
import com.rc.hackotlin.R
import com.rc.hackotlin.views.fragments.PostListFragment

open class Home(): ActionBarActivity(){

    val logTag = "###Home###"

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val transaction = getSupportFragmentManager().beginTransaction()
        transaction.replace(R.id.posts_container, PostListFragment.Maker.Create())
        transaction.commit()
    }
}
