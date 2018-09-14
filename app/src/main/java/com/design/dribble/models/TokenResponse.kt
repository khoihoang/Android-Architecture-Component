/*
 * Created by Hoang Hiep on 9/12/18 8:46 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 8:45 PM
 */

package com.design.dribble.models

import com.google.gson.annotations.SerializedName

data class TokenResponse(

        @field:SerializedName("access_token")
        val accessToken: String? = null,

        @field:SerializedName("scope")
        val scope: String? = null,

        @field:SerializedName("created_at")
        val createdAt: Int? = null,

        @field:SerializedName("token_type")
        val tokenType: String? = null
)