package com.rc.hackotlin.adapters

import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import com.rc.hackotlin.models.Post
import android.content.Context
import android.widget.AbsListView
import android.widget.TextView
import android.view.LayoutInflater
import com.rc.hackotlin.R


/**
 * Created by akshay on 07/11/14.
 */


open class PostListAdapter(val context:Context,val listView: AbsListView): BaseAdapter(){

    private val logTag: String = "###PostListAdapter###"
    var postList = ArrayList<Post>()

    override fun getCount(): Int {
        return postList.size
    }

    override fun getItem(position: Int): Any? {
        if(position >= postList.size)
            return null
        return postList.get(position)
    }

    override fun getItemId(p0: Int): Long {
        if(p0 >= postList.size)
            return -1
        return postList.get(p0).id
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View? {
        var cachedItem: ItemCache?
        var contentView: View ? = view
        when (contentView) {
            null -> {
                contentView = LayoutInflater.from(context).inflate(R.layout.layout_post_item, parent, false)
                cachedItem = ItemCache(textView = contentView?.findViewById(R.id.post) as TextView)
                contentView?.setTag(cachedItem)
            }
            else -> {
                cachedItem = contentView?.getTag() as ItemCache
            }
        }
        val currentPost = getItem(position) as Post
        cachedItem?.textView?.setText(currentPost.post)
        return contentView
    }

    class ItemCache(val textView: TextView?)
}

