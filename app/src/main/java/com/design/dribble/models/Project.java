/*
 * Created by Hoang Hiep on 9/13/18 2:21 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/13/18 2:21 PM
 */

package com.design.dribble.models;

import com.design.dribble.models.users.User;
import com.google.gson.annotations.SerializedName;

public class Project {
    @SerializedName("created_at")
    public String createdAt;
    @SerializedName("description")
    public String description;
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("shots_count")
    public int shotsCount;
    @SerializedName("updated_at")
    public String updatedAt;
    @SerializedName("user")
    public User user;
}
