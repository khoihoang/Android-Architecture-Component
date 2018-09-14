/*
 * Created by Hoang Hiep on 9/13/18 3:42 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/13/18 3:42 PM
 */

package com.design.dribble.models.users

import com.google.gson.annotations.SerializedName

class Team {
    @SerializedName("avatar_url")
    var avatarUrl: String? = null
    var bio: String? = null
    @SerializedName("buckets_count")
    var bucketsCount: Int = 0
    @SerializedName("buckets_url")
    var bucketsUrl: String? = null
    @SerializedName("created_at")
    var createdAt: String? = null
    @SerializedName("followers_count")
    var followersCount: Int = 0
    @SerializedName("followers_url")
    var followersUrl: String? = null
    @SerializedName("following_url")
    var followingUrl: String? = null
    @SerializedName("followings_count")
    var followingsCount: Int = 0
    @SerializedName("html_url")
    var htmlUrl: String? = null
    var id: Int = 0
    @SerializedName("likes_count")
    var likesCount: Int = 0
    @SerializedName("likes_url")
    var likesUrl: String? = null
    var links: Links? = null
    var location: String? = null
    @SerializedName("members_count")
    var membersCount: Int = 0
    @SerializedName("members_url")
    var membersUrl: String? = null
    var name: String? = null
    var pro: Boolean? = null
    @SerializedName("projects_count")
    var projectsCount: Int = 0
    @SerializedName("shots_count")
    var shotsCount: Int = 0
    @SerializedName("shots_url")
    var shotsUrl: String? = null
    @SerializedName("team_shots_url")
    var teamShotsUrl: String? = null
    var type: String? = null
    @SerializedName("updated_at")
    var updatedAt: String? = null
    var username: String? = null
}
