package com.ruSkidex.RestMethod.Gson.Reqest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RpcDeliveryLandingProductsPayload extends RpcMessage.Payload{


    @Override
    public Integer getCompanyId() {
        return null;
    }

    @Override
    public void setCompanyId(Integer companyId) {

    }

    @Override
    public Integer getPage() {
        return null;
    }

    @Override
    public void setPage(Integer page) {

    }

    @Override
    public String getChar() {
        return null;
    }

    @Override
    public void setChar(String char_) {

    }

    @Override
    public String getSort() {
        return null;
    }

    @Override
    public void setSort(String sort) {

    }

    @Override
    public String getSortDirection() {
        return null;
    }

    @Override
    public void setSortDirection(String sortDirection) {

    }

    public static class Payload extends RpcMessage.Payload {

        @SerializedName("companyId")
        @Expose
        private Integer companyId;
        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("categoryId")
        @Expose
        private Integer categoryId;

        public Integer getCompanyId() {
            return companyId;
        }

        @Override


        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        @Override
        public String getChar() {
            return null;
        }

        @Override
        public void setChar(String char_) {

        }

        @Override
        public String getSort() {
            return null;
        }

        @Override
        public void setSort(String sort) {

        }

        @Override
        public String getSortDirection() {
            return null;
        }

        @Override
        public void setSortDirection(String sortDirection) {

        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

    }
}
