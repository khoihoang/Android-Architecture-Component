/*
 * Created by Hoang Hiep on 9/13/18 2:25 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/13/18 2:25 PM
 */

package com.design.dribble.models.users

import com.google.gson.annotations.SerializedName

data class Links(
        @field:SerializedName("behance")
        var behance: String? = null,
        @field:SerializedName("codepen")
        var codepen: String? = null,
        @field:SerializedName("creative_market")
        var creativeMarket: String? = null,
        @field:SerializedName("facebook")
        var facebook: String? = null,
        @field:SerializedName("github")
        var github: String? = null,
        @field:SerializedName("instagram")
        var instagram: String? = null,
        @field:SerializedName("linkedin")
        var linkedin: String? = null,
        @field:SerializedName("medium")
        var medium: String? = null,
        @field:SerializedName("twitter")
        var twitter: String? = null,
        @field:SerializedName("vimeo")
        var vimeo: String? = null,
        @field:SerializedName("web")
        var web: String? = null
)
