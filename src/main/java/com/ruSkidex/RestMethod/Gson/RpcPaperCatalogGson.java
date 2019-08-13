package com.ruSkidex.RestMethod.Gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RpcPaperCatalogGson {


    public class Catalog {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("beginsAt")
        @Expose
        private Object beginsAt;
        @SerializedName("endsAt")
        @Expose
        private Object endsAt;
        @SerializedName("maxDiscount")
        @Expose
        private Integer maxDiscount;
        @SerializedName("productCount")
        @Expose
        private String productCount;
        @SerializedName("shopCount")
        @Expose
        private Integer shopCount;
        @SerializedName("pdfUrl")
        @Expose
        private Object pdfUrl;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("categoryIds")
        @Expose
        private List<Integer> categoryIds = null;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("company")
        @Expose
        private Company company;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getBeginsAt() {
            return beginsAt;
        }

        public void setBeginsAt(Object beginsAt) {
            this.beginsAt = beginsAt;
        }

        public Object getEndsAt() {
            return endsAt;
        }

        public void setEndsAt(Object endsAt) {
            this.endsAt = endsAt;
        }

        public Integer getMaxDiscount() {
            return maxDiscount;
        }

        public void setMaxDiscount(Integer maxDiscount) {
            this.maxDiscount = maxDiscount;
        }

        public String getProductCount() {
            return productCount;
        }

        public void setProductCount(String productCount) {
            this.productCount = productCount;
        }

        public Integer getShopCount() {
            return shopCount;
        }

        public void setShopCount(Integer shopCount) {
            this.shopCount = shopCount;
        }

        public Object getPdfUrl() {
            return pdfUrl;
        }

        public void setPdfUrl(Object pdfUrl) {
            this.pdfUrl = pdfUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Integer> getCategoryIds() {
            return categoryIds;
        }

        public void setCategoryIds(List<Integer> categoryIds) {
            this.categoryIds = categoryIds;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

    }
public class Category {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
public class Company {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("imageRounded")
        @Expose
        private String imageRounded;
        @SerializedName("title")
        @Expose
        private String title;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImageRounded() {
            return imageRounded;
        }

        public void setImageRounded(String imageRounded) {
            this.imageRounded = imageRounded;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
public class Message {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("payload")
        @Expose
        private Payload payload;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Payload getPayload() {
            return payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }

    }
public class MethodPaperCatalogs {

        @SerializedName("messages")
        @Expose
        private List<Message> messages = null;

        public List<Message> getMessages() {
            return messages;
        }

        public void setMessages(List<Message> messages) {
            this.messages = messages;
        }

    }
public class Payload {

        @SerializedName("catalogs")
        @Expose
        private List<Catalog> catalogs = null;
        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;

        public List<Catalog> getCatalogs() {
            return catalogs;
        }

        public void setCatalogs(List<Catalog> catalogs) {
            this.catalogs = catalogs;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

    }

}
