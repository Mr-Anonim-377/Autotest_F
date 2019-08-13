package com.ruSkidex.RestMethod.Gson.Reqest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RpcDeliveryLandingCategoriesSnippetsPayload {



public static  class Payload  extends RpcMessage.Payload{

        @SerializedName("companyId")
        @Expose
        private Integer companyId;

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
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

}
}
