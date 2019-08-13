package com.ruSkidex.RestMethod.Gson.Reqest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RpcBrandsAndCompaniesByCharPayload {

    public static class Payload extends RpcMessage.Payload {

        @SerializedName("page")
        @Expose
        private Integer page;

        @SerializedName("char")
        @Expose
        private String char_;

        @Override
        public Integer getCompanyId() {
            return null;
        }

        @Override
        public void setCompanyId(Integer companyId) {

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
            return char_;
        }
        @Override
        public void setChar(String char_) {
            this.char_ = char_;
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
