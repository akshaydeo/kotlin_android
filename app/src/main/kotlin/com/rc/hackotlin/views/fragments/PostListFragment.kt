package com.rc.hackotlin.views.fragments

import android.support.v4.app.DialogFragment
import android.widget.ListView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import com.rc.hackotlin.R
import com.rc.hackotlin.adapters.PostListAdapter
import android.widget.AbsListView
import com.rc.hackotlin.models.Post
import android.os.Handler
import android.util.Log

/**
 * Created by akshay on 07/11/14.
 */

open class PostListFragment() : DialogFragment() {
    val logTag = "###PostListFragment###"
    var postList: ListView? = null
    var baseView: View? = null
    var postsAdapter: PostListAdapter? = null
    var handler: Handler? = null

    object Maker {
        fun Create(): PostListFragment {
            return PostListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        baseView = inflater?.inflate(R.layout.fragment_post_list, container, false)
        postList = baseView?.findViewById(R.id.post_list) as ListView
        postsAdapter = PostListAdapter(getActivity(), postList as AbsListView)
        postList.setAdapter(postsAdapter)
        handler = Handler()
        return baseView
    }

    override fun onResume() {
        super<DialogFragment>.onResume()
        Post.Maker.GetList {
            Log.d(logTag,"Testing get list =>" + it.get(0).post)
            postsAdapter?.postList?.addAll(it)
            handler?.post {
                this.postsAdapter?.notifyDataSetChanged()
            }
        }
    }
}
