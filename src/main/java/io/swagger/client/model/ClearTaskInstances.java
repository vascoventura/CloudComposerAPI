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
/**
 * ClearTaskInstances
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-28T10:55:43.678Z[GMT]")
public class ClearTaskInstances {
  @SerializedName("dry_run")
  private Boolean dryRun = true;

  @SerializedName("task_ids")
  private List<String> taskIds = null;

  @SerializedName("start_date")
  private String startDate = null;

  @SerializedName("end_date")
  private String endDate = null;

  @SerializedName("only_failed")
  private Boolean onlyFailed = true;

  @SerializedName("only_running")
  private Boolean onlyRunning = false;

  @SerializedName("include_subdags")
  private Boolean includeSubdags = null;

  @SerializedName("include_parentdag")
  private Boolean includeParentdag = null;

  @SerializedName("reset_dag_runs")
  private Boolean resetDagRuns = null;

  @SerializedName("dag_run_id")
  private String dagRunId = null;

  @SerializedName("include_upstream")
  private Boolean includeUpstream = false;

  @SerializedName("include_downstream")
  private Boolean includeDownstream = false;

  @SerializedName("include_future")
  private Boolean includeFuture = false;

  @SerializedName("include_past")
  private Boolean includePast = false;

  public ClearTaskInstances dryRun(Boolean dryRun) {
    this.dryRun = dryRun;
    return this;
  }

   /**
   * If set, don&#x27;t actually run this operation. The response will contain a list of task instances planned to be cleaned, but not modified in any way. 
   * @return dryRun
  **/
  @Schema(description = "If set, don't actually run this operation. The response will contain a list of task instances planned to be cleaned, but not modified in any way. ")
  public Boolean isDryRun() {
    return dryRun;
  }

  public void setDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
  }

  public ClearTaskInstances taskIds(List<String> taskIds) {
    this.taskIds = taskIds;
    return this;
  }

  public ClearTaskInstances addTaskIdsItem(String taskIdsItem) {
    if (this.taskIds == null) {
      this.taskIds = new ArrayList<String>();
    }
    this.taskIds.add(taskIdsItem);
    return this;
  }

   /**
   * A list of task ids to clear.  *New in version 2.1.0* 
   * @return taskIds
  **/
  @Schema(description = "A list of task ids to clear.  *New in version 2.1.0* ")
  public List<String> getTaskIds() {
    return taskIds;
  }

  public void setTaskIds(List<String> taskIds) {
    this.taskIds = taskIds;
  }

  public ClearTaskInstances startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * The minimum execution date to clear.
   * @return startDate
  **/
  @Schema(description = "The minimum execution date to clear.")
  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public ClearTaskInstances endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

   /**
   * The maximum execution date to clear.
   * @return endDate
  **/
  @Schema(description = "The maximum execution date to clear.")
  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public ClearTaskInstances onlyFailed(Boolean onlyFailed) {
    this.onlyFailed = onlyFailed;
    return this;
  }

   /**
   * Only clear failed tasks.
   * @return onlyFailed
  **/
  @Schema(description = "Only clear failed tasks.")
  public Boolean isOnlyFailed() {
    return onlyFailed;
  }

  public void setOnlyFailed(Boolean onlyFailed) {
    this.onlyFailed = onlyFailed;
  }

  public ClearTaskInstances onlyRunning(Boolean onlyRunning) {
    this.onlyRunning = onlyRunning;
    return this;
  }

   /**
   * Only clear running tasks.
   * @return onlyRunning
  **/
  @Schema(description = "Only clear running tasks.")
  public Boolean isOnlyRunning() {
    return onlyRunning;
  }

  public void setOnlyRunning(Boolean onlyRunning) {
    this.onlyRunning = onlyRunning;
  }

  public ClearTaskInstances includeSubdags(Boolean includeSubdags) {
    this.includeSubdags = includeSubdags;
    return this;
  }

   /**
   * Clear tasks in subdags and clear external tasks indicated by ExternalTaskMarker.
   * @return includeSubdags
  **/
  @Schema(description = "Clear tasks in subdags and clear external tasks indicated by ExternalTaskMarker.")
  public Boolean isIncludeSubdags() {
    return includeSubdags;
  }

  public void setIncludeSubdags(Boolean includeSubdags) {
    this.includeSubdags = includeSubdags;
  }

  public ClearTaskInstances includeParentdag(Boolean includeParentdag) {
    this.includeParentdag = includeParentdag;
    return this;
  }

   /**
   * Clear tasks in the parent dag of the subdag.
   * @return includeParentdag
  **/
  @Schema(description = "Clear tasks in the parent dag of the subdag.")
  public Boolean isIncludeParentdag() {
    return includeParentdag;
  }

  public void setIncludeParentdag(Boolean includeParentdag) {
    this.includeParentdag = includeParentdag;
  }

  public ClearTaskInstances resetDagRuns(Boolean resetDagRuns) {
    this.resetDagRuns = resetDagRuns;
    return this;
  }

   /**
   * Set state of DAG runs to RUNNING.
   * @return resetDagRuns
  **/
  @Schema(description = "Set state of DAG runs to RUNNING.")
  public Boolean isResetDagRuns() {
    return resetDagRuns;
  }

  public void setResetDagRuns(Boolean resetDagRuns) {
    this.resetDagRuns = resetDagRuns;
  }

  public ClearTaskInstances dagRunId(String dagRunId) {
    this.dagRunId = dagRunId;
    return this;
  }

   /**
   * The DagRun ID for this task instance
   * @return dagRunId
  **/
  @Schema(description = "The DagRun ID for this task instance")
  public String getDagRunId() {
    return dagRunId;
  }

  public void setDagRunId(String dagRunId) {
    this.dagRunId = dagRunId;
  }

  public ClearTaskInstances includeUpstream(Boolean includeUpstream) {
    this.includeUpstream = includeUpstream;
    return this;
  }

   /**
   * If set to true, upstream tasks are also affected.
   * @return includeUpstream
  **/
  @Schema(description = "If set to true, upstream tasks are also affected.")
  public Boolean isIncludeUpstream() {
    return includeUpstream;
  }

  public void setIncludeUpstream(Boolean includeUpstream) {
    this.includeUpstream = includeUpstream;
  }

  public ClearTaskInstances includeDownstream(Boolean includeDownstream) {
    this.includeDownstream = includeDownstream;
    return this;
  }

   /**
   * If set to true, downstream tasks are also affected.
   * @return includeDownstream
  **/
  @Schema(description = "If set to true, downstream tasks are also affected.")
  public Boolean isIncludeDownstream() {
    return includeDownstream;
  }

  public void setIncludeDownstream(Boolean includeDownstream) {
    this.includeDownstream = includeDownstream;
  }

  public ClearTaskInstances includeFuture(Boolean includeFuture) {
    this.includeFuture = includeFuture;
    return this;
  }

   /**
   * If set to True, also tasks from future DAG Runs are affected.
   * @return includeFuture
  **/
  @Schema(description = "If set to True, also tasks from future DAG Runs are affected.")
  public Boolean isIncludeFuture() {
    return includeFuture;
  }

  public void setIncludeFuture(Boolean includeFuture) {
    this.includeFuture = includeFuture;
  }

  public ClearTaskInstances includePast(Boolean includePast) {
    this.includePast = includePast;
    return this;
  }

   /**
   * If set to True, also tasks from past DAG Runs are affected.
   * @return includePast
  **/
  @Schema(description = "If set to True, also tasks from past DAG Runs are affected.")
  public Boolean isIncludePast() {
    return includePast;
  }

  public void setIncludePast(Boolean includePast) {
    this.includePast = includePast;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClearTaskInstances clearTaskInstances = (ClearTaskInstances) o;
    return Objects.equals(this.dryRun, clearTaskInstances.dryRun) &&
        Objects.equals(this.taskIds, clearTaskInstances.taskIds) &&
        Objects.equals(this.startDate, clearTaskInstances.startDate) &&
        Objects.equals(this.endDate, clearTaskInstances.endDate) &&
        Objects.equals(this.onlyFailed, clearTaskInstances.onlyFailed) &&
        Objects.equals(this.onlyRunning, clearTaskInstances.onlyRunning) &&
        Objects.equals(this.includeSubdags, clearTaskInstances.includeSubdags) &&
        Objects.equals(this.includeParentdag, clearTaskInstances.includeParentdag) &&
        Objects.equals(this.resetDagRuns, clearTaskInstances.resetDagRuns) &&
        Objects.equals(this.dagRunId, clearTaskInstances.dagRunId) &&
        Objects.equals(this.includeUpstream, clearTaskInstances.includeUpstream) &&
        Objects.equals(this.includeDownstream, clearTaskInstances.includeDownstream) &&
        Objects.equals(this.includeFuture, clearTaskInstances.includeFuture) &&
        Objects.equals(this.includePast, clearTaskInstances.includePast);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dryRun, taskIds, startDate, endDate, onlyFailed, onlyRunning, includeSubdags, includeParentdag, resetDagRuns, dagRunId, includeUpstream, includeDownstream, includeFuture, includePast);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClearTaskInstances {\n");
    
    sb.append("    dryRun: ").append(toIndentedString(dryRun)).append("\n");
    sb.append("    taskIds: ").append(toIndentedString(taskIds)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    onlyFailed: ").append(toIndentedString(onlyFailed)).append("\n");
    sb.append("    onlyRunning: ").append(toIndentedString(onlyRunning)).append("\n");
    sb.append("    includeSubdags: ").append(toIndentedString(includeSubdags)).append("\n");
    sb.append("    includeParentdag: ").append(toIndentedString(includeParentdag)).append("\n");
    sb.append("    resetDagRuns: ").append(toIndentedString(resetDagRuns)).append("\n");
    sb.append("    dagRunId: ").append(toIndentedString(dagRunId)).append("\n");
    sb.append("    includeUpstream: ").append(toIndentedString(includeUpstream)).append("\n");
    sb.append("    includeDownstream: ").append(toIndentedString(includeDownstream)).append("\n");
    sb.append("    includeFuture: ").append(toIndentedString(includeFuture)).append("\n");
    sb.append("    includePast: ").append(toIndentedString(includePast)).append("\n");
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
