/*
 * Created by Hoang Hiep on 9/13/18 2:11 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/13/18 2:11 PM
 */

package com.design.dribble.models.shot

import com.design.dribble.models.Attachment
import com.design.dribble.models.Project
import com.design.dribble.models.users.Team
import com.design.dribble.models.users.User
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class Shot {
    @SerializedName("animated")
    var animated: Boolean = false
    @SerializedName("attachments")
    var attachments: List<Attachment> = ArrayList()
    @SerializedName("attachments_count")
    var attachmentsCount: Int = 0
    @SerializedName("buckets_count")
    var bucketsCount: Int = 0
    @SerializedName("comments_closed")
    var commentsClosed: Boolean = false
    @SerializedName("comments_count")
    var commentsCount: Int = 0
    @SerializedName("created_at")
    var createdAt: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("height")
    var height: Int = 0
    @SerializedName("html_url")
    var htmlUrl: String? = null
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("images")
    var images: Images? = null
    @SerializedName("likes_count")
    var likesCount: Int = 0
    @SerializedName("low_profile")
    var lowProfile: Boolean = false
    @SerializedName("projects")
    var projects: List<Project>? = null
    @SerializedName("rebounds_count")
    var reboundsCount: Int = 0
    @SerializedName("tags")
    var tags: List<String> = ArrayList()
    @SerializedName("team")
    var team: Team? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("updated_at")
    var updatedAt: String? = null
    @SerializedName("user")
    var user: User? = null
    @SerializedName("views_count")
    var viewsCount: Int = 0
    @SerializedName("width")
    var width: Int = 0

    companion object {
        private val TAG = "Shot"
    }
}
