package com.ruSkidex.RestMethod.Gson.Reqest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RpcMessage {
    @SerializedName("messages")
    @Expose
    private List<Message> messages = null;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public static class Message {

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

        public void payload(@NotNull RpcOperatorDeliveryRequestListPayload.Payload i) {

        }
    }
    public static abstract class Payload {

        public abstract Integer getCompanyId();

        public abstract void setCompanyId(Integer companyId);

        public abstract Integer getPage();

        public abstract void setPage(Integer page);

        public abstract String getChar();

        public abstract void setChar(String char_);

        public abstract String getSort();

        public abstract void setSort(String sort);

        public abstract String getSortDirection();

        public abstract void setSortDirection(String sortDirection);
    }

}
