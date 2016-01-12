package com.example.cameron.shutterdroid.com.example.cameron.shutterdroid.shutterstock;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cameron on 7/16/15.
 */
public class Image {
    @SerializedName("id")
    private String mId;
    @SerializedName("description")
    private String mDescription;

    @SerializedName("assets")
    private imageAssets mAssets;

    public String getLargeThumbnail() {
        return mAssets.mLargeThumb.mUrl;
    }

    private class imageAssets {
        @SerializedName("thumbnail")
        Thumbnail mPreview;

        @SerializedName("small_thumb")
        Thumbnail mSmallThumb;

        @SerializedName("large_thumb")
        Thumbnail mLargeThumb;
    }

    private class Thumbnail {
        @SerializedName("url")
        String mUrl;
    }
}
