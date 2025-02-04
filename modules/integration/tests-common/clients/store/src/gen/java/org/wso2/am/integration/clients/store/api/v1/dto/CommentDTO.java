/*
 * WSO2 API Manager - Developer Portal
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Developer Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.store.v1/src/main/resources/devportal-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication The Developer Portal REST API is protected using OAuth2 and access control is achieved through scopes. Before you start invoking the API, you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_devportal\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown below to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_devportal\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_devportal\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for devportal REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_password>&scope=<scopes separated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<servlet_port>/oauth2/token ``` **Sample request** ``` curl https://localhost:9443/oauth2/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:subscribe apim:api_key\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:subscribe apim:api_key\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5bc0161b8aa7e701d7bf)
 *
 * The version of the OpenAPI document: v3
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.store.api.v1.dto;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CommentDTO
 */

public class CommentDTO {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    private String id;

    public static final String SERIALIZED_NAME_CONTENT = "content";
    @SerializedName(SERIALIZED_NAME_CONTENT)
    private String content;

    public static final String SERIALIZED_NAME_CREATED_TIME = "createdTime";
    @SerializedName(SERIALIZED_NAME_CREATED_TIME)
    private String createdTime;

    public static final String SERIALIZED_NAME_CREATED_BY = "createdBy";
    @SerializedName(SERIALIZED_NAME_CREATED_BY)
    private String createdBy;

    public static final String SERIALIZED_NAME_UPDATED_TIME = "updatedTime";
    @SerializedName(SERIALIZED_NAME_UPDATED_TIME)
    private String updatedTime;

    public static final String SERIALIZED_NAME_CATEGORY = "category";
    @SerializedName(SERIALIZED_NAME_CATEGORY)
    private String category = "general";

    public static final String SERIALIZED_NAME_PARENT_COMMENT_ID = "parentCommentId";
    @SerializedName(SERIALIZED_NAME_PARENT_COMMENT_ID)
    private String parentCommentId;

    /**
     * Gets or Sets entryPoint
     */
    @JsonAdapter(EntryPointEnum.Adapter.class)
    public enum EntryPointEnum {
        DEVPORTAL("devPortal"),

        PUBLISHER("publisher");

        private String value;

        EntryPointEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static EntryPointEnum fromValue(String value) {
            for (EntryPointEnum b : EntryPointEnum.values()) {
                if (b.name().equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<EntryPointEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final EntryPointEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EntryPointEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return EntryPointEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_ENTRY_POINT = "entryPoint";
    @SerializedName(SERIALIZED_NAME_ENTRY_POINT)
    private EntryPointEnum entryPoint;

    public static final String SERIALIZED_NAME_COMMENTER_INFO = "commenterInfo";
    @SerializedName(SERIALIZED_NAME_COMMENTER_INFO)
    private CommenterInfoDTO commenterInfo;

    public static final String SERIALIZED_NAME_REPLIES = "replies";
    @SerializedName(SERIALIZED_NAME_REPLIES)
    private CommentListDTO replies;


    public CommentDTO id(String id) {

        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "943d3002-000c-42d3-a1b9-d6559f8a4d49", value = "")

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public CommentDTO content(String content) {

        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     **/
    @ApiModelProperty(example = "This is a comment", required = true, value = "")

    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public CommentDTO createdTime(String createdTime) {

        this.createdTime = createdTime;
        return this;
    }

    /**
     * Get createdTime
     *
     * @return createdTime
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2021-02-11-09:57:25", value = "")

    public String getCreatedTime() {
        return createdTime;
    }


    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }


    public CommentDTO createdBy(String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     *
     * @return createdBy
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "admin", value = "")

    public String getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public CommentDTO updatedTime(String updatedTime) {

        this.updatedTime = updatedTime;
        return this;
    }

    /**
     * Get updatedTime
     *
     * @return updatedTime
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2021-02-12-19:57:25", value = "")

    public String getUpdatedTime() {
        return updatedTime;
    }


    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }


    public CommentDTO category(String category) {

        this.category = category;
        return this;
    }

    /**
     * Get category
     *
     * @return category
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "general", value = "")

    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public CommentDTO parentCommentId(String parentCommentId) {

        this.parentCommentId = parentCommentId;
        return this;
    }

    /**
     * Get parentCommentId
     *
     * @return parentCommentId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "6f38aea2-f41e-4ac9-b3f2-a9493d00ba97", value = "")

    public String getParentCommentId() {
        return parentCommentId;
    }


    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }


    public CommentDTO entryPoint(EntryPointEnum entryPoint) {

        this.entryPoint = entryPoint;
        return this;
    }

    /**
     * Get entryPoint
     *
     * @return entryPoint
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public EntryPointEnum getEntryPoint() {
        return entryPoint;
    }


    public void setEntryPoint(EntryPointEnum entryPoint) {
        this.entryPoint = entryPoint;
    }


    public CommentDTO commenterInfo(CommenterInfoDTO commenterInfo) {

        this.commenterInfo = commenterInfo;
        return this;
    }

    /**
     * Get commenterInfo
     *
     * @return commenterInfo
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public CommenterInfoDTO getCommenterInfo() {
        return commenterInfo;
    }


    public void setCommenterInfo(CommenterInfoDTO commenterInfo) {
        this.commenterInfo = commenterInfo;
    }


    public CommentDTO replies(CommentListDTO replies) {

        this.replies = replies;
        return this;
    }

    /**
     * Get replies
     *
     * @return replies
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public CommentListDTO getReplies() {
        return replies;
    }


    public void setReplies(CommentListDTO replies) {
        this.replies = replies;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommentDTO comment = (CommentDTO) o;
        return Objects.equals(this.id, comment.id) &&
                Objects.equals(this.content, comment.content) &&
                Objects.equals(this.createdTime, comment.createdTime) &&
                Objects.equals(this.createdBy, comment.createdBy) &&
                Objects.equals(this.updatedTime, comment.updatedTime) &&
                Objects.equals(this.category, comment.category) &&
                Objects.equals(this.parentCommentId, comment.parentCommentId) &&
                Objects.equals(this.entryPoint, comment.entryPoint) &&
                Objects.equals(this.commenterInfo, comment.commenterInfo) &&
                Objects.equals(this.replies, comment.replies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, createdTime, createdBy, updatedTime, category, parentCommentId, entryPoint, commenterInfo, replies);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommentDTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    updatedTime: ").append(toIndentedString(updatedTime)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    parentCommentId: ").append(toIndentedString(parentCommentId)).append("\n");
        sb.append("    entryPoint: ").append(toIndentedString(entryPoint)).append("\n");
        sb.append("    commenterInfo: ").append(toIndentedString(commenterInfo)).append("\n");
        sb.append("    replies: ").append(toIndentedString(replies)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

