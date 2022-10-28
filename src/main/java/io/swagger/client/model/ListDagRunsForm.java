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
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * ListDagRunsForm
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-28T10:55:43.678Z[GMT]")
public class ListDagRunsForm {
  @SerializedName("order_by")
  private String orderBy = null;

  @SerializedName("page_offset")
  private Integer pageOffset = null;

  @SerializedName("page_limit")
  private Integer pageLimit = 100;

  @SerializedName("dag_ids")
  private List<String> dagIds = null;

  @SerializedName("states")
  private List<String> states = null;

  @SerializedName("execution_date_gte")
  private OffsetDateTime executionDateGte = null;

  @SerializedName("execution_date_lte")
  private OffsetDateTime executionDateLte = null;

  @SerializedName("start_date_gte")
  private OffsetDateTime startDateGte = null;

  @SerializedName("start_date_lte")
  private OffsetDateTime startDateLte = null;

  @SerializedName("end_date_gte")
  private OffsetDateTime endDateGte = null;

  @SerializedName("end_date_lte")
  private OffsetDateTime endDateLte = null;

  public ListDagRunsForm orderBy(String orderBy) {
    this.orderBy = orderBy;
    return this;
  }

   /**
   * The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0* 
   * @return orderBy
  **/
  @Schema(description = "The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* ")
  public String getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public ListDagRunsForm pageOffset(Integer pageOffset) {
    this.pageOffset = pageOffset;
    return this;
  }

   /**
   * The number of items to skip before starting to collect the result set.
   * minimum: 0
   * @return pageOffset
  **/
  @Schema(description = "The number of items to skip before starting to collect the result set.")
  public Integer getPageOffset() {
    return pageOffset;
  }

  public void setPageOffset(Integer pageOffset) {
    this.pageOffset = pageOffset;
  }

  public ListDagRunsForm pageLimit(Integer pageLimit) {
    this.pageLimit = pageLimit;
    return this;
  }

   /**
   * The numbers of items to return.
   * minimum: 1
   * @return pageLimit
  **/
  @Schema(description = "The numbers of items to return.")
  public Integer getPageLimit() {
    return pageLimit;
  }

  public void setPageLimit(Integer pageLimit) {
    this.pageLimit = pageLimit;
  }

  public ListDagRunsForm dagIds(List<String> dagIds) {
    this.dagIds = dagIds;
    return this;
  }

  public ListDagRunsForm addDagIdsItem(String dagIdsItem) {
    if (this.dagIds == null) {
      this.dagIds = new ArrayList<String>();
    }
    this.dagIds.add(dagIdsItem);
    return this;
  }

   /**
   * Return objects with specific DAG IDs. The value can be repeated to retrieve multiple matching values (OR condition).
   * @return dagIds
  **/
  @Schema(description = "Return objects with specific DAG IDs. The value can be repeated to retrieve multiple matching values (OR condition).")
  public List<String> getDagIds() {
    return dagIds;
  }

  public void setDagIds(List<String> dagIds) {
    this.dagIds = dagIds;
  }

  public ListDagRunsForm states(List<String> states) {
    this.states = states;
    return this;
  }

  public ListDagRunsForm addStatesItem(String statesItem) {
    if (this.states == null) {
      this.states = new ArrayList<String>();
    }
    this.states.add(statesItem);
    return this;
  }

   /**
   * Return objects with specific states. The value can be repeated to retrieve multiple matching values (OR condition).
   * @return states
  **/
  @Schema(description = "Return objects with specific states. The value can be repeated to retrieve multiple matching values (OR condition).")
  public List<String> getStates() {
    return states;
  }

  public void setStates(List<String> states) {
    this.states = states;
  }

  public ListDagRunsForm executionDateGte(OffsetDateTime executionDateGte) {
    this.executionDateGte = executionDateGte;
    return this;
  }

   /**
   * Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte key to receive only the selected period. 
   * @return executionDateGte
  **/
  @Schema(description = "Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte key to receive only the selected period. ")
  public OffsetDateTime getExecutionDateGte() {
    return executionDateGte;
  }

  public void setExecutionDateGte(OffsetDateTime executionDateGte) {
    this.executionDateGte = executionDateGte;
  }

  public ListDagRunsForm executionDateLte(OffsetDateTime executionDateLte) {
    this.executionDateLte = executionDateLte;
    return this;
  }

   /**
   * Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte key to receive only the selected period. 
   * @return executionDateLte
  **/
  @Schema(description = "Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte key to receive only the selected period. ")
  public OffsetDateTime getExecutionDateLte() {
    return executionDateLte;
  }

  public void setExecutionDateLte(OffsetDateTime executionDateLte) {
    this.executionDateLte = executionDateLte;
  }

  public ListDagRunsForm startDateGte(OffsetDateTime startDateGte) {
    this.startDateGte = startDateGte;
    return this;
  }

   /**
   * Returns objects greater or equal the specified date.  This can be combined with start_date_lte key to receive only the selected period. 
   * @return startDateGte
  **/
  @Schema(description = "Returns objects greater or equal the specified date.  This can be combined with start_date_lte key to receive only the selected period. ")
  public OffsetDateTime getStartDateGte() {
    return startDateGte;
  }

  public void setStartDateGte(OffsetDateTime startDateGte) {
    this.startDateGte = startDateGte;
  }

  public ListDagRunsForm startDateLte(OffsetDateTime startDateLte) {
    this.startDateLte = startDateLte;
    return this;
  }

   /**
   * Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period 
   * @return startDateLte
  **/
  @Schema(description = "Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period ")
  public OffsetDateTime getStartDateLte() {
    return startDateLte;
  }

  public void setStartDateLte(OffsetDateTime startDateLte) {
    this.startDateLte = startDateLte;
  }

  public ListDagRunsForm endDateGte(OffsetDateTime endDateGte) {
    this.endDateGte = endDateGte;
    return this;
  }

   /**
   * Returns objects greater or equal the specified date.  This can be combined with end_date_lte parameter to receive only the selected period. 
   * @return endDateGte
  **/
  @Schema(description = "Returns objects greater or equal the specified date.  This can be combined with end_date_lte parameter to receive only the selected period. ")
  public OffsetDateTime getEndDateGte() {
    return endDateGte;
  }

  public void setEndDateGte(OffsetDateTime endDateGte) {
    this.endDateGte = endDateGte;
  }

  public ListDagRunsForm endDateLte(OffsetDateTime endDateLte) {
    this.endDateLte = endDateLte;
    return this;
  }

   /**
   * Returns objects less than or equal to the specified date.  This can be combined with end_date_gte parameter to receive only the selected period. 
   * @return endDateLte
  **/
  @Schema(description = "Returns objects less than or equal to the specified date.  This can be combined with end_date_gte parameter to receive only the selected period. ")
  public OffsetDateTime getEndDateLte() {
    return endDateLte;
  }

  public void setEndDateLte(OffsetDateTime endDateLte) {
    this.endDateLte = endDateLte;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListDagRunsForm listDagRunsForm = (ListDagRunsForm) o;
    return Objects.equals(this.orderBy, listDagRunsForm.orderBy) &&
        Objects.equals(this.pageOffset, listDagRunsForm.pageOffset) &&
        Objects.equals(this.pageLimit, listDagRunsForm.pageLimit) &&
        Objects.equals(this.dagIds, listDagRunsForm.dagIds) &&
        Objects.equals(this.states, listDagRunsForm.states) &&
        Objects.equals(this.executionDateGte, listDagRunsForm.executionDateGte) &&
        Objects.equals(this.executionDateLte, listDagRunsForm.executionDateLte) &&
        Objects.equals(this.startDateGte, listDagRunsForm.startDateGte) &&
        Objects.equals(this.startDateLte, listDagRunsForm.startDateLte) &&
        Objects.equals(this.endDateGte, listDagRunsForm.endDateGte) &&
        Objects.equals(this.endDateLte, listDagRunsForm.endDateLte);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderBy, pageOffset, pageLimit, dagIds, states, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListDagRunsForm {\n");
    
    sb.append("    orderBy: ").append(toIndentedString(orderBy)).append("\n");
    sb.append("    pageOffset: ").append(toIndentedString(pageOffset)).append("\n");
    sb.append("    pageLimit: ").append(toIndentedString(pageLimit)).append("\n");
    sb.append("    dagIds: ").append(toIndentedString(dagIds)).append("\n");
    sb.append("    states: ").append(toIndentedString(states)).append("\n");
    sb.append("    executionDateGte: ").append(toIndentedString(executionDateGte)).append("\n");
    sb.append("    executionDateLte: ").append(toIndentedString(executionDateLte)).append("\n");
    sb.append("    startDateGte: ").append(toIndentedString(startDateGte)).append("\n");
    sb.append("    startDateLte: ").append(toIndentedString(startDateLte)).append("\n");
    sb.append("    endDateGte: ").append(toIndentedString(endDateGte)).append("\n");
    sb.append("    endDateLte: ").append(toIndentedString(endDateLte)).append("\n");
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
