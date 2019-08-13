

package com.ruSkidex.RestMethod.Gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SearchOnMapGson {








    public class AdditionalData {

        @SerializedName("products")
        @Expose
        private Integer products;
        @SerializedName("productPages")
        @Expose
        private Integer productPages;
        @SerializedName("addresses")
        @Expose
        private Integer addresses;
        @SerializedName("addressPages")
        @Expose
        private Integer addressPages;
        @SerializedName("pagesCount")
        @Expose
        private Integer pagesCount;

        public Integer getProducts() {
            return products;
        }

        public void setProducts(Integer products) {
            this.products = products;
        }

        public Integer getProductPages() {
            return productPages;
        }

        public void setProductPages(Integer productPages) {
            this.productPages = productPages;
        }

        public Integer getAddresses() {
            return addresses;
        }

        public void setAddresses(Integer addresses) {
            this.addresses = addresses;
        }

        public Integer getAddressPages() {
            return addressPages;
        }

        public void setAddressPages(Integer addressPages) {
            this.addressPages = addressPages;
        }

        public Integer getPagesCount() {
            return pagesCount;
        }

        public void setPagesCount(Integer pagesCount) {
            this.pagesCount = pagesCount;
        }

    }


    public class Address {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("company")
        @Expose
        private Company company;
        @SerializedName("address")
        @Expose
        private Address_ address;
        @SerializedName("timetable")
        @Expose
        private Object timetable;
        @SerializedName("url")
        @Expose
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        public Address_ getAddress() {
            return address;
        }

        public void setAddress(Address_ address) {
            this.address = address;
        }

        public Object getTimetable() {
            return timetable;
        }

        public void setTimetable(Object timetable) {
            this.timetable = timetable;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public class Address_ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("cityId")
        @Expose
        private Integer cityId;
        @SerializedName("address")
        @Expose
        private String address;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }


    public class Address__ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("cityId")
        @Expose
        private Integer cityId;
        @SerializedName("address")
        @Expose
        private String address;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }


    public class City {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("fiasId")
        @Expose
        private Integer fiasId;
        @SerializedName("pinId")
        @Expose
        private Integer pinId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("fullTitle")
        @Expose
        private String fullTitle;
        @SerializedName("parentTitle")
        @Expose
        private Object parentTitle;
        @SerializedName("parentKind")
        @Expose
        private Object parentKind;
        @SerializedName("alias")
        @Expose
        private String alias;
        @SerializedName("createdAt")
        @Expose
        private Integer createdAt;
        @SerializedName("updatedAt")
        @Expose
        private Integer updatedAt;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("coords")
        @Expose
        private Coords coords;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getFiasId() {
            return fiasId;
        }

        public void setFiasId(Integer fiasId) {
            this.fiasId = fiasId;
        }

        public Integer getPinId() {
            return pinId;
        }

        public void setPinId(Integer pinId) {
            this.pinId = pinId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFullTitle() {
            return fullTitle;
        }

        public void setFullTitle(String fullTitle) {
            this.fullTitle = fullTitle;
        }

        public Object getParentTitle() {
            return parentTitle;
        }

        public void setParentTitle(Object parentTitle) {
            this.parentTitle = parentTitle;
        }

        public Object getParentKind() {
            return parentKind;
        }

        public void setParentKind(Object parentKind) {
            this.parentKind = parentKind;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public Integer getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Integer createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Integer updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public Coords getCoords() {
            return coords;
        }

        public void setCoords(Coords coords) {
            this.coords = coords;
        }

    }


    public class Company {

        @SerializedName("shopId")
        @Expose
        private Integer shopId;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("managerId")
        @Expose
        private Integer managerId;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("imageRounded")
        @Expose
        private String imageRounded;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("createdAt")
        @Expose
        private Integer createdAt;
        @SerializedName("updatedAt")
        @Expose
        private Integer updatedAt;
        @SerializedName("url")
        @Expose
        private String url;

        public Integer getShopId() {
            return shopId;
        }

        public void setShopId(Integer shopId) {
            this.shopId = shopId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getManagerId() {
            return managerId;
        }

        public void setManagerId(Integer managerId) {
            this.managerId = managerId;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Integer createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Integer updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public class Company_ {

        @SerializedName("id")
        @Expose
        private Integer id;
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


    public class Coords {

        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;
        @SerializedName("zoom")
        @Expose
        private Integer zoom;

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Integer getZoom() {
            return zoom;
        }

        public void setZoom(Integer zoom) {
            this.zoom = zoom;
        }

    }


    public class Coords_ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;
        @SerializedName("zoom")
        @Expose
        private Object zoom;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Object getZoom() {
            return zoom;
        }

        public void setZoom(Object zoom) {
            this.zoom = zoom;
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

    public class AddressProduct {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("cityId")
        @Expose
        private Integer cityId;
        @SerializedName("address")
        @Expose
        private String address;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }
    public class CompanyProduct {

        @SerializedName("shopId")
        @Expose
        private Integer shopId;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("managerId")
        @Expose
        private Integer managerId;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("imageRounded")
        @Expose
        private String imageRounded;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("createdAt")
        @Expose
        private Integer createdAt;
        @SerializedName("updatedAt")
        @Expose
        private Integer updatedAt;
        @SerializedName("url")
        @Expose
        private String url;

        public Integer getShopId() {
            return shopId;
        }

        public void setShopId(Integer shopId) {
            this.shopId = shopId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getManagerId() {
            return managerId;
        }

        public void setManagerId(Integer managerId) {
            this.managerId = managerId;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Integer createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Integer updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
    public class Product {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("company")
        @Expose
        private CompanyProduct company;
        @SerializedName("address")
        @Expose
        private AddressProduct address;
        @SerializedName("product")
        @Expose
        private Product_ product;
        @SerializedName("timetable")
        @Expose
        private Object timetable;
        @SerializedName("url")
        @Expose
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public CompanyProduct getCompany() {
            return company;
        }

        public void setCompany(CompanyProduct company) {
            this.company = company;
        }

        public AddressProduct getAddress() {
            return address;
        }

        public void setAddress(AddressProduct address) {
            this.address = address;
        }

        public Product_ getProduct() {
            return product;
        }

        public void setProduct(Product_ product) {
            this.product = product;
        }

        public Object getTimetable() {
            return timetable;
        }

        public void setTimetable(Object timetable) {
            this.timetable = timetable;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
    public class Product_ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("productCardId")
        @Expose
        private Integer productCardId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("oldPrice")
        @Expose
        private Integer oldPrice;
        @SerializedName("discount")
        @Expose
        private Integer discount;
        @SerializedName("salesBoxPrice")
        @Expose
        private Object salesBoxPrice;
        @SerializedName("salesBoxDiscount")
        @Expose
        private Object salesBoxDiscount;
        @SerializedName("period")
        @Expose
        private Object period;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getProductCardId() {
            return productCardId;
        }

        public void setProductCardId(Integer productCardId) {
            this.productCardId = productCardId;
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

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Integer oldPrice) {
            this.oldPrice = oldPrice;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public Object getSalesBoxPrice() {
            return salesBoxPrice;
        }

        public void setSalesBoxPrice(Object salesBoxPrice) {
            this.salesBoxPrice = salesBoxPrice;
        }

        public Object getSalesBoxDiscount() {
            return salesBoxDiscount;
        }

        public void setSalesBoxDiscount(Object salesBoxDiscount) {
            this.salesBoxDiscount = salesBoxDiscount;
        }

        public Object getPeriod() {
            return period;
        }

        public void setPeriod(Object period) {
            this.period = period;
        }

    }

    public class Payload {

        @SerializedName("products")
        @Expose
        private List<Product> products = null;
        @SerializedName("addresses")
        @Expose
        private List<Address> addresses = null;
        @SerializedName("additionalData")
        @Expose
        private AdditionalData additionalData;
        @SerializedName("city")
        @Expose
        private City city;
        @SerializedName("pins")
        @Expose
        private List<Pin> pins = null;

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }

        public AdditionalData getAdditionalData() {
            return additionalData;
        }

        public void setAdditionalData(AdditionalData additionalData) {
            this.additionalData = additionalData;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public List<Pin> getPins() {
            return pins;
        }

        public void setPins(List<Pin> pins) {
            this.pins = pins;
        }

    }


    public class Pin {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("address")
        @Expose
        private Address__ address;
        @SerializedName("company")
        @Expose
        private Company_ company;
        @SerializedName("coords")
        @Expose
        private Coords_ coords;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Address__ getAddress() {
            return address;
        }

        public void setAddress(Address__ address) {
            this.address = address;
        }

        public Company_ getCompany() {
            return company;
        }

        public void setCompany(Company_ company) {
            this.company = company;
        }

        public Coords_ getCoords() {
            return coords;
        }

        public void setCoords(Coords_ coords) {
            this.coords = coords;
        }

    }


    public class RestMethodSearchOnMap{

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
}