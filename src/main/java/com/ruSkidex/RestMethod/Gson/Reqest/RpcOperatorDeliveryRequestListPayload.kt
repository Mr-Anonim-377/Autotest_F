package com.ruSkidex.RestMethod.Gson.Reqest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RpcOperatorDeliveryRequestListPayload {


    class Payload : RpcMessage.Payload() {
        override fun getCompanyId(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        @SerializedName("page")
        @Expose
        private var page: Int? = 0



        override fun setCompanyId(companyId: Int?) {

        }

        override fun getPage(): Int? {
            return page
        }


        override fun getChar(): String? {
            return null
        }

        override fun setChar(char_: String) {

        }

        override fun getSort(): String? {
            return null
        }

        override fun setSort(sort: String) {

        }

        override fun getSortDirection(): String? {
            return null
        }

        override fun setSortDirection(sortDirection: String) {

        }

        override fun setPage(page: Int?) {
            this.page = page
        }

    }
}
