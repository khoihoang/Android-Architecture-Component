/*
 * Created by Hoang Hiep on 9/13/18 2:26 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/13/18 2:25 PM
 */

package com.design.dribble.models.users

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
        indices = [
        Index("id")],
        primaryKeys = ["id"]
)
class User {
    @SerializedName("avatar_url")
    var avatarUrl: String? = null
    @SerializedName("bio")
    var bio: String? = null
    @SerializedName("buckets_count")
    var bucketsCount: Int = 0
    @SerializedName("buckets_url")
    var bucketsUrl: String? = null
    @SerializedName("can_upload_shot")
    var canUploadShot = false
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
    @SerializedName("id")
    var id: Int = 0
    var isFollowedBySelf = false
    @SerializedName("pro")
    var isPro: Boolean = false
    @SerializedName("likes_count")
    var likesCount: Int = 0
    @SerializedName("likes_url")
    var likesUrl: String? = null
    @Ignore
    @SerializedName("links")
    var links: Links? = null
    @SerializedName("location")
    var location: String? = null
    @SerializedName("message")
    var message: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("projects_count")
    var projectsCount: Int = 0
    @SerializedName("shots_count")
    var shotsCount: Int = 0
    @SerializedName("shots_url")
    var shotsUrl: String? = null
    @SerializedName("teams_count")
    var teamsCount: Int = 0
    @SerializedName("teams_url")
    var teamsUrl: String? = null
    @SerializedName("type")
    var type: String? = null
    @SerializedName("updated_at")
    var updatedAt: String? = null
    @SerializedName("username")
    var username: String? = null
}
