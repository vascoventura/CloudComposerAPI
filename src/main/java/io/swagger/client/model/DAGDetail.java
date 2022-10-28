/*
 * Airflow API (Stable)
 * # Overview  To facilitate management, Apache Airflow supports a range of REST API endpoints across its objects. This section provides an overview of the API design, methods, and supported use cases.  Most of the endpoints accept `JSON` as input and return `JSON` responses. This means that you must usually add the following headers to your request: ``` Content-type: application/json Accept: application/json ```  ## Resources  The term `resource` refers to a single type of object in the Airflow metadata. An API is broken up by its endpoint's corresponding resource. The name of a resource is typically plural and expressed in camelCase. Example: `dagRuns`.  Resource names are used as part of endpoint URLs, as well as in API parameters and responses.  ## CRUD Operations  The platform supports **C**reate, **R**ead, **U**pdate, and **D**elete operations on most resources. You can review the standards for these operations and their standard parameters below.  Some endpoints have special behavior as exceptions.  ### Create  To create a resource, you typically submit an HTTP `POST` request with the resource's required metadata in the request body. The response returns a `201 Created` response code upon success with the resource's metadata, including its internal `id`, in the response body.  ### Read  The HTTP `GET` request can be used to read a resource or to list a number of resources.  A resource's `id` can be submitted in the request parameters to read a specific resource. The response usually returns a `200 OK` response code upon success, with the resource's metadata in the response body.  If a `GET` request does not include a specific resource `id`, it is treated as a list request. The response usually returns a `200 OK` response code upon success, with an object containing a list of resources' metadata in the response body.  When reading resources, some common query parameters are usually available. e.g.: ``` v1/connections?limit=25&offset=25 ```  |Query Parameter|Type|Description| |---------------|----|-----------| |limit|integer|Maximum number of objects to fetch. Usually 25 by default| |offset|integer|Offset after which to start returning objects. For use with limit query parameter.|  ### Update  Updating a resource requires the resource `id`, and is typically done using an HTTP `PATCH` request, with the fields to modify in the request body. The response usually returns a `200 OK` response code upon success, with information about the modified resource in the response body.  ### Delete  Deleting a resource requires the resource `id` and is typically executing via an HTTP `DELETE` request. The response usually returns a `204 No Content` response code upon success.  ## Conventions  - Resource names are plural and expressed in camelCase. - Names are consistent between URL parameter name and field name.  - Field names are in snake_case. ```json {     \"name\": \"string\",     \"slots\": 0,     \"occupied_slots\": 0,     \"used_slots\": 0,     \"queued_slots\": 0,     \"open_slots\": 0 } ```  ### Update Mask  Update mask is available as a query parameter in patch endpoints. It is used to notify the API which fields you want to update. Using `update_mask` makes it easier to update objects by helping the server know which fields to update in an object instead of updating all fields. The update request ignores any fields that aren't specified in the field mask, leaving them with their current values.  Example: ```   resource = request.get('/resource/my-id').json()   resource['my_field'] = 'new-value'   request.patch('/resource/my-id?update_mask=my_field', data=json.dumps(resource)) ```  ## Versioning and Endpoint Lifecycle  - API versioning is not synchronized to specific releases of the Apache Airflow. - APIs are designed to be backward compatible. - Any changes to the API will first go through a deprecation phase.  # Trying the API  You can use a third party client, such as [curl](https://curl.haxx.se/), [HTTPie](https://httpie.org/), [Postman](https://www.postman.com/) or [the Insomnia rest client](https://insomnia.rest/) to test the Apache Airflow API.  Note that you will need to pass credentials data.  For e.g., here is how to pause a DAG with [curl](https://curl.haxx.se/), when basic authorization is used: ```bash curl -X PATCH 'https://example.com/api/v1/dags/{dag_id}?update_mask=is_paused' \\ -H 'Content-Type: application/json' \\ --user \"username:password\" \\ -d '{     \"is_paused\": true }' ```  Using a graphical tool such as [Postman](https://www.postman.com/) or [Insomnia](https://insomnia.rest/), it is possible to import the API specifications directly:  1. Download the API specification by clicking the **Download** button at top of this document 2. Import the JSON specification in the graphical tool of your choice.   - In *Postman*, you can click the **import** button at the top   - With *Insomnia*, you can just drag-and-drop the file on the UI  Note that with *Postman*, you can also generate code snippets by selecting a request and clicking on the **Code** button.  ## Enabling CORS  [Cross-origin resource sharing (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS) is a browser security feature that restricts HTTP requests that are initiated from scripts running in the browser.  For details on enabling/configuring CORS, see [Enabling CORS](https://airflow.apache.org/docs/apache-airflow/stable/security/api.html).  # Authentication  To be able to meet the requirements of many organizations, Airflow supports many authentication methods, and it is even possible to add your own method.  If you want to check which auth backend is currently set, you can use `airflow config get-value api auth_backends` command as in the example below. ```bash $ airflow config get-value api auth_backends airflow.api.auth.backend.basic_auth ``` The default is to deny all requests.  For details on configuring the authentication, see [API Authorization](https://airflow.apache.org/docs/apache-airflow/stable/security/api.html).  # Errors  We follow the error response format proposed in [RFC 7807](https://tools.ietf.org/html/rfc7807) also known as Problem Details for HTTP APIs. As with our normal API responses, your client must be prepared to gracefully handle additional members of the response.  ## Unauthenticated  This indicates that the request has not been applied because it lacks valid authentication credentials for the target resource. Please check that you have valid credentials.  ## PermissionDenied  This response means that the server understood the request but refuses to authorize it because it lacks sufficient rights to the resource. It happens when you do not have the necessary permission to execute the action you performed. You need to get the appropriate permissions in other to resolve this error.  ## BadRequest  This response means that the server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, invalid request message framing, or deceptive request routing). To resolve this, please ensure that your syntax is correct.  ## NotFound  This client error response indicates that the server cannot find the requested resource.  ## MethodNotAllowed  Indicates that the request method is known by the server but is not supported by the target resource.  ## NotAcceptable  The target resource does not have a current representation that would be acceptable to the user agent, according to the proactive negotiation header fields received in the request, and the server is unwilling to supply a default representation.  ## AlreadyExists  The request could not be completed due to a conflict with the current state of the target resource, e.g. the resource it tries to create already exists.  ## Unknown  This means that the server encountered an unexpected condition that prevented it from fulfilling the request. 
 *
 * OpenAPI spec version: 2.3.0
 * Contact: dev@airflow.apache.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.client.model.DAG;
import io.swagger.client.model.ScheduleInterval;
import io.swagger.client.model.Tag;
import io.swagger.client.model.TimeDelta;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * DAG details.  For details see: [airflow.models.DAG](https://airflow.apache.org/docs/apache-airflow/stable/_api/airflow/models/index.html#airflow.models.DAG) 
 */
@Schema(description = "DAG details.  For details see: [airflow.models.DAG](https://airflow.apache.org/docs/apache-airflow/stable/_api/airflow/models/index.html#airflow.models.DAG) ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-28T10:55:43.678Z[GMT]")
public class DAGDetail extends DAG {
  @SerializedName("timezone")
  private String timezone = null;

  @SerializedName("catchup")
  private Boolean catchup = null;

  @SerializedName("orientation")
  private String orientation = null;

  @SerializedName("concurrency")
  private BigDecimal concurrency = null;

  @SerializedName("start_date")
  private OffsetDateTime startDate = null;

  @SerializedName("dag_run_timeout")
  private TimeDelta dagRunTimeout = null;

  @SerializedName("doc_md")
  private String docMd = null;

  @SerializedName("default_view")
  private String defaultView = null;

  @SerializedName("params")
  private Object params = null;

  @SerializedName("end_date")
  private OffsetDateTime endDate = null;

  @SerializedName("is_paused_upon_creation")
  private Boolean isPausedUponCreation = null;

  @SerializedName("last_parsed")
  private OffsetDateTime lastParsed = null;

  @SerializedName("template_search_path")
  private List<String> templateSearchPath = null;

  @SerializedName("render_template_as_native_obj")
  private Boolean renderTemplateAsNativeObj = null;

  public DAGDetail timezone(String timezone) {
    this.timezone = timezone;
    return this;
  }

   /**
   * Get timezone
   * @return timezone
  **/
  @Schema(description = "")
  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

   /**
   * Get catchup
   * @return catchup
  **/
  @Schema(description = "")
  public Boolean isCatchup() {
    return catchup;
  }

   /**
   * Get orientation
   * @return orientation
  **/
  @Schema(description = "")
  public String getOrientation() {
    return orientation;
  }

   /**
   * Get concurrency
   * @return concurrency
  **/
  @Schema(description = "")
  public BigDecimal getConcurrency() {
    return concurrency;
  }

   /**
   * The DAG&#x27;s start date.  *Changed in version 2.0.1*&amp;#58; Field becomes nullable. 
   * @return startDate
  **/
  @Schema(description = "The DAG's start date.  *Changed in version 2.0.1*&#58; Field becomes nullable. ")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public DAGDetail dagRunTimeout(TimeDelta dagRunTimeout) {
    this.dagRunTimeout = dagRunTimeout;
    return this;
  }

   /**
   * Get dagRunTimeout
   * @return dagRunTimeout
  **/
  @Schema(description = "")
  public TimeDelta getDagRunTimeout() {
    return dagRunTimeout;
  }

  public void setDagRunTimeout(TimeDelta dagRunTimeout) {
    this.dagRunTimeout = dagRunTimeout;
  }

   /**
   * Get docMd
   * @return docMd
  **/
  @Schema(description = "")
  public String getDocMd() {
    return docMd;
  }

   /**
   * Get defaultView
   * @return defaultView
  **/
  @Schema(description = "")
  public String getDefaultView() {
    return defaultView;
  }

   /**
   * User-specified DAG params.  *New in version 2.0.1* 
   * @return params
  **/
  @Schema(description = "User-specified DAG params.  *New in version 2.0.1* ")
  public Object getParams() {
    return params;
  }

   /**
   * The DAG&#x27;s end date.  *New in version 2.3.0*. 
   * @return endDate
  **/
  @Schema(description = "The DAG's end date.  *New in version 2.3.0*. ")
  public OffsetDateTime getEndDate() {
    return endDate;
  }

   /**
   * Whether the DAG is paused upon creation.  *New in version 2.3.0* 
   * @return isPausedUponCreation
  **/
  @Schema(description = "Whether the DAG is paused upon creation.  *New in version 2.3.0* ")
  public Boolean isIsPausedUponCreation() {
    return isPausedUponCreation;
  }

   /**
   * The last time the DAG was parsed.  *New in version 2.3.0* 
   * @return lastParsed
  **/
  @Schema(description = "The last time the DAG was parsed.  *New in version 2.3.0* ")
  public OffsetDateTime getLastParsed() {
    return lastParsed;
  }

  public DAGDetail templateSearchPath(List<String> templateSearchPath) {
    this.templateSearchPath = templateSearchPath;
    return this;
  }

  public DAGDetail addTemplateSearchPathItem(String templateSearchPathItem) {
    if (this.templateSearchPath == null) {
      this.templateSearchPath = new ArrayList<String>();
    }
    this.templateSearchPath.add(templateSearchPathItem);
    return this;
  }

   /**
   * The template search path.  *New in version 2.3.0* 
   * @return templateSearchPath
  **/
  @Schema(description = "The template search path.  *New in version 2.3.0* ")
  public List<String> getTemplateSearchPath() {
    return templateSearchPath;
  }

  public void setTemplateSearchPath(List<String> templateSearchPath) {
    this.templateSearchPath = templateSearchPath;
  }

   /**
   * Whether to render templates as native Python objects.  *New in version 2.3.0* 
   * @return renderTemplateAsNativeObj
  **/
  @Schema(description = "Whether to render templates as native Python objects.  *New in version 2.3.0* ")
  public Boolean isRenderTemplateAsNativeObj() {
    return renderTemplateAsNativeObj;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DAGDetail daGDetail = (DAGDetail) o;
    return Objects.equals(this.timezone, daGDetail.timezone) &&
        Objects.equals(this.catchup, daGDetail.catchup) &&
        Objects.equals(this.orientation, daGDetail.orientation) &&
        Objects.equals(this.concurrency, daGDetail.concurrency) &&
        Objects.equals(this.startDate, daGDetail.startDate) &&
        Objects.equals(this.dagRunTimeout, daGDetail.dagRunTimeout) &&
        Objects.equals(this.docMd, daGDetail.docMd) &&
        Objects.equals(this.defaultView, daGDetail.defaultView) &&
        Objects.equals(this.params, daGDetail.params) &&
        Objects.equals(this.endDate, daGDetail.endDate) &&
        Objects.equals(this.isPausedUponCreation, daGDetail.isPausedUponCreation) &&
        Objects.equals(this.lastParsed, daGDetail.lastParsed) &&
        Objects.equals(this.templateSearchPath, daGDetail.templateSearchPath) &&
        Objects.equals(this.renderTemplateAsNativeObj, daGDetail.renderTemplateAsNativeObj) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timezone, catchup, orientation, concurrency, startDate, dagRunTimeout, docMd, defaultView, params, endDate, isPausedUponCreation, lastParsed, templateSearchPath, renderTemplateAsNativeObj, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DAGDetail {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
    sb.append("    catchup: ").append(toIndentedString(catchup)).append("\n");
    sb.append("    orientation: ").append(toIndentedString(orientation)).append("\n");
    sb.append("    concurrency: ").append(toIndentedString(concurrency)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    dagRunTimeout: ").append(toIndentedString(dagRunTimeout)).append("\n");
    sb.append("    docMd: ").append(toIndentedString(docMd)).append("\n");
    sb.append("    defaultView: ").append(toIndentedString(defaultView)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    isPausedUponCreation: ").append(toIndentedString(isPausedUponCreation)).append("\n");
    sb.append("    lastParsed: ").append(toIndentedString(lastParsed)).append("\n");
    sb.append("    templateSearchPath: ").append(toIndentedString(templateSearchPath)).append("\n");
    sb.append("    renderTemplateAsNativeObj: ").append(toIndentedString(renderTemplateAsNativeObj)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
