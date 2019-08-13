package com.ruSkidex.RestMethod.Gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RpcOperatorDeliveryRequestListGson {


public class Company {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("imageRounded")
        @Expose
        private String imageRounded;

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

    }
public class OperatorDeliveryRequestList {

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


public class DeliveryRequest {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

    }
public class Item {

        @SerializedName("deliveryRequest")
        @Expose
        private DeliveryRequest deliveryRequest;
        @SerializedName("company")
        @Expose
        private Company company;

        public DeliveryRequest getDeliveryRequest() {
            return deliveryRequest;
        }

        public void setDeliveryRequest(DeliveryRequest deliveryRequest) {
            this.deliveryRequest = deliveryRequest;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
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
public class Payload {

        @SerializedName("items")
        @Expose
        private List<Item> items = null;
        @SerializedName("pagesCount")
        @Expose
        private Integer pagesCount;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public Integer getPagesCount() {
            return pagesCount;
        }

        public void setPagesCount(Integer pagesCount) {
            this.pagesCount = pagesCount;
        }

    }
}
