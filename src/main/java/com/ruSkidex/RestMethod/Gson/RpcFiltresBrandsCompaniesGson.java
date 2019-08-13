package com.ruSkidex.RestMethod.Gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RpcFiltresBrandsCompaniesGson {

public class Child {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("active")
        @Expose
        private Boolean active;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

    }
public class Filtres {

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
public class Message {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("payload")
        @Expose
        private List<Payload> payload = null;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Payload> getPayload() {
            return payload;
        }

        public void setPayload(List<Payload> payload) {
            this.payload = payload;
        }

    }
public class Payload {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("active")
        @Expose
        private Boolean active;
        @SerializedName("children")
        @Expose
        private List<Child> children = null;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public List<Child> getChildren() {
            return children;
        }

        public void setChildren(List<Child> children) {
            this.children = children;
        }

    }
}
