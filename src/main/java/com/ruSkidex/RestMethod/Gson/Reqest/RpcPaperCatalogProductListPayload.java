package com.ruSkidex.RestMethod.Gson.Reqest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RpcPaperCatalogProductListPayload {

    public static class Payload extends RpcMessage.Payload {

        @SerializedName("companyId")
        @Expose
        private Integer companyId;
        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("sort")
        @Expose
        private String sort;
        @SerializedName("sortDirection")
        @Expose
        private String sortDirection;
        @Override
        public Integer getCompanyId() {
            return companyId;
        }
        @Override
        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }
        @Override
        public Integer getPage() {
            return page;
        }
        @Override
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
            return sort;
        }
        @Override
        public void setSort(String sort) {
            this.sort = sort;
        }
        @Override
        public String getSortDirection() {
            return sortDirection;
        }
        @Override
        public void setSortDirection(String sortDirection) {
            this.sortDirection = sortDirection;
        }

    }

}



