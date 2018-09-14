/*
 * Created by Hoang Hiep on 9/13/18 2:12 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/13/18 2:12 PM
 */

package com.design.dribble.models;

import com.design.dribble.utils.GlobalVars;
import com.google.gson.annotations.SerializedName;

public class Attachment {
    private static final String TAG = "Attachment";
    @SerializedName("content_type")
    public String contentType;
    @SerializedName("id")
    private int id;
    @SerializedName("size")
    public int size;
    @SerializedName("thumbnail_url")
    public String thumbnailUrl;
    @SerializedName("url")
    public String url;
    @SerializedName("views_count")
    public int viewsCount;

    /*public Attachment(File file) {
        this.thumbnailUrl = file.getPath();
        this.url = this.thumbnailUrl;
        this.contentType = FileUtils.getTypeFromRealFile(file.getPath());
    }

    public Attachment(String str, String str2) {
        this.thumbnailUrl = str;
        this.url = str;
        this.contentType = str2;
    }

    public Integer getBackgroundColor() {
        Object obj;
        String extension = getExtension();
        int hashCode = extension.hashCode();
        if (hashCode != -900674644) {
            if (hashCode != 3108) {
                if (hashCode != 3112) {
                    if (hashCode != 96796) {
                        if (hashCode != 110834) {
                            if (hashCode == 111297) {
                                if (extension.equals("psd")) {
                                    obj = null;
                                    switch (obj) {
                                        case null:
                                            return Integer.valueOf(-15193972);
                                        case 1:
                                            return Integer.valueOf(-23011);
                                        case 2:
                                            return Integer.valueOf(-12436874);
                                        case 3:
                                            return Integer.valueOf(-1675503);
                                        case 4:
                                            return Integer.valueOf(-3324372);
                                        case 5:
                                            return Integer.valueOf(-7751319);
                                        default:
                                            return Integer.valueOf(-8618884);
                                    }
                                }
                            }
                        } else if (extension.equals("pdf")) {
                            obj = 4;
                            switch (obj) {
                                case null:
                                    return Integer.valueOf(-15193972);
                                case 1:
                                    return Integer.valueOf(-23011);
                                case 2:
                                    return Integer.valueOf(-12436874);
                                case 3:
                                    return Integer.valueOf(-1675503);
                                case 4:
                                    return Integer.valueOf(-3324372);
                                case 5:
                                    return Integer.valueOf(-7751319);
                                default:
                                    return Integer.valueOf(-8618884);
                            }
                        }
                    } else if (extension.equals("apk")) {
                        obj = 5;
                        switch (obj) {
                            case null:
                                return Integer.valueOf(-15193972);
                            case 1:
                                return Integer.valueOf(-23011);
                            case 2:
                                return Integer.valueOf(-12436874);
                            case 3:
                                return Integer.valueOf(-1675503);
                            case 4:
                                return Integer.valueOf(-3324372);
                            case 5:
                                return Integer.valueOf(-7751319);
                            default:
                                return Integer.valueOf(-8618884);
                        }
                    }
                } else if (extension.equals("ai")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            return Integer.valueOf(-15193972);
                        case 1:
                            return Integer.valueOf(-23011);
                        case 2:
                            return Integer.valueOf(-12436874);
                        case 3:
                            return Integer.valueOf(-1675503);
                        case 4:
                            return Integer.valueOf(-3324372);
                        case 5:
                            return Integer.valueOf(-7751319);
                        default:
                            return Integer.valueOf(-8618884);
                    }
                }
            } else if (extension.equals("ae")) {
                obj = 2;
                switch (obj) {
                    case null:
                        return Integer.valueOf(-15193972);
                    case 1:
                        return Integer.valueOf(-23011);
                    case 2:
                        return Integer.valueOf(-12436874);
                    case 3:
                        return Integer.valueOf(-1675503);
                    case 4:
                        return Integer.valueOf(-3324372);
                    case 5:
                        return Integer.valueOf(-7751319);
                    default:
                        return Integer.valueOf(-8618884);
                }
            }
        } else if (extension.equals("sketch")) {
            obj = 3;
            switch (obj) {
                case null:
                    return Integer.valueOf(-15193972);
                case 1:
                    return Integer.valueOf(-23011);
                case 2:
                    return Integer.valueOf(-12436874);
                case 3:
                    return Integer.valueOf(-1675503);
                case 4:
                    return Integer.valueOf(-3324372);
                case 5:
                    return Integer.valueOf(-7751319);
                default:
                    return Integer.valueOf(-8618884);
            }
        }
        obj = -1;
        switch (obj) {
            case null:
                return Integer.valueOf(-15193972);
            case 1:
                return Integer.valueOf(-23011);
            case 2:
                return Integer.valueOf(-12436874);
            case 3:
                return Integer.valueOf(-1675503);
            case 4:
                return Integer.valueOf(-3324372);
            case 5:
                return Integer.valueOf(-7751319);
            default:
                return Integer.valueOf(-8618884);
        }
    }*/

    public String getExtension() {
        return this.url.substring(this.url.lastIndexOf(46) + 1).toLowerCase();
    }

    public String getTitle() {
        return this.url.substring(this.url.lastIndexOf(47) + 1);
    }

    public boolean isImage() {
        return this.contentType != null && this.contentType.startsWith(GlobalVars.MIME_TYPE_IMAGE_PREFIX);
    }

    public boolean isAnimatedGif() {
        return this.url.endsWith(".gif");
    }
}
