package com.rc.hackotlin.models

import java.util.Date
import java.util.ArrayList


/**
 * Created by akshay on 07/11/14.
 */

data class Post(val id: Long, val post: String, val by: String, val postedAt: Date) {
    object Maker {
        fun GetList(onSuccess: (posts: List<Post>) -> Unit) {
            val posts = ArrayList<Post>()
            for (a in 1..10) {
                posts.add(Post(a.toLong(), "Test", "Akshay", Date()))
            }
            onSuccess(posts)
        }
    }
}