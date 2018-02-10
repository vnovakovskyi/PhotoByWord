package com.example.vadim.photobyword.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Image {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("display_sizes")
    @Expose
    private List<DisplaySize> displaySizes = null;
    @SerializedName("license_model")
    @Expose
    private String licenseModel;
    @SerializedName("max_dimensions")
    @Expose
    private MaxDimensions maxDimensions;
    @SerializedName("title")
    @Expose
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DisplaySize> getDisplaySizes() {
        return displaySizes;
    }

    public void setDisplaySizes(List<DisplaySize> displaySizes) {
        this.displaySizes = displaySizes;
    }

    public String getLicenseModel() {
        return licenseModel;
    }

    public void setLicenseModel(String licenseModel) {
        this.licenseModel = licenseModel;
    }

    public MaxDimensions getMaxDimensions() {
        return maxDimensions;
    }

    public void setMaxDimensions(MaxDimensions maxDimensions) {
        this.maxDimensions = maxDimensions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
