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
import io.swagger.client.model.ScheduleInterval;
import io.swagger.client.model.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * DAG
 */
@Schema(description = "DAG")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-28T10:55:43.678Z[GMT]")
public class DAG {
  @SerializedName("dag_id")
  private String dagId = null;

  @SerializedName("root_dag_id")
  private String rootDagId = null;

  @SerializedName("is_paused")
  private Boolean isPaused = null;

  @SerializedName("is_active")
  private Boolean isActive = null;

  @SerializedName("is_subdag")
  private Boolean isSubdag = null;

  @SerializedName("last_parsed_time")
  private OffsetDateTime lastParsedTime = null;

  @SerializedName("last_pickled")
  private OffsetDateTime lastPickled = null;

  @SerializedName("last_expired")
  private OffsetDateTime lastExpired = null;

  @SerializedName("scheduler_lock")
  private Boolean schedulerLock = null;

  @SerializedName("pickle_id")
  private String pickleId = null;

  @SerializedName("default_view")
  private String defaultView = null;

  @SerializedName("fileloc")
  private String fileloc = null;

  @SerializedName("file_token")
  private String fileToken = null;

  @SerializedName("owners")
  private List<String> owners = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("schedule_interval")
  private ScheduleInterval scheduleInterval = null;

  @SerializedName("timetable_description")
  private String timetableDescription = null;

  @SerializedName("tags")
  private List<Tag> tags = null;

  @SerializedName("max_active_tasks")
  private Integer maxActiveTasks = null;

  @SerializedName("max_active_runs")
  private Integer maxActiveRuns = null;

  @SerializedName("has_task_concurrency_limits")
  private Boolean hasTaskConcurrencyLimits = null;

  @SerializedName("has_import_errors")
  private Boolean hasImportErrors = null;

  @SerializedName("next_dagrun")
  private OffsetDateTime nextDagrun = null;

  @SerializedName("next_dagrun_data_interval_start")
  private OffsetDateTime nextDagrunDataIntervalStart = null;

  @SerializedName("next_dagrun_data_interval_end")
  private OffsetDateTime nextDagrunDataIntervalEnd = null;

  @SerializedName("next_dagrun_create_after")
  private OffsetDateTime nextDagrunCreateAfter = null;

   /**
   * The ID of the DAG.
   * @return dagId
  **/
  @Schema(description = "The ID of the DAG.")
  public String getDagId() {
    return dagId;
  }

   /**
   * If the DAG is SubDAG then it is the top level DAG identifier. Otherwise, null.
   * @return rootDagId
  **/
  @Schema(description = "If the DAG is SubDAG then it is the top level DAG identifier. Otherwise, null.")
  public String getRootDagId() {
    return rootDagId;
  }

  public DAG isPaused(Boolean isPaused) {
    this.isPaused = isPaused;
    return this;
  }

   /**
   * Whether the DAG is paused.
   * @return isPaused
  **/
  @Schema(description = "Whether the DAG is paused.")
  public Boolean isIsPaused() {
    return isPaused;
  }

  public void setIsPaused(Boolean isPaused) {
    this.isPaused = isPaused;
  }

   /**
   * Whether the DAG is currently seen by the scheduler(s).  *New in version 2.1.1*  *Changed in version 2.2.0*&amp;#58; Field is read-only. 
   * @return isActive
  **/
  @Schema(description = "Whether the DAG is currently seen by the scheduler(s).  *New in version 2.1.1*  *Changed in version 2.2.0*&#58; Field is read-only. ")
  public Boolean isIsActive() {
    return isActive;
  }

   /**
   * Whether the DAG is SubDAG.
   * @return isSubdag
  **/
  @Schema(description = "Whether the DAG is SubDAG.")
  public Boolean isIsSubdag() {
    return isSubdag;
  }

   /**
   * The last time the DAG was parsed.  *New in version 2.3.0* 
   * @return lastParsedTime
  **/
  @Schema(description = "The last time the DAG was parsed.  *New in version 2.3.0* ")
  public OffsetDateTime getLastParsedTime() {
    return lastParsedTime;
  }

   /**
   * The last time the DAG was pickled.  *New in version 2.3.0* 
   * @return lastPickled
  **/
  @Schema(description = "The last time the DAG was pickled.  *New in version 2.3.0* ")
  public OffsetDateTime getLastPickled() {
    return lastPickled;
  }

   /**
   * Time when the DAG last received a refresh signal (e.g. the DAG&#x27;s \&quot;refresh\&quot; button was clicked in the web UI)  *New in version 2.3.0* 
   * @return lastExpired
  **/
  @Schema(description = "Time when the DAG last received a refresh signal (e.g. the DAG's \"refresh\" button was clicked in the web UI)  *New in version 2.3.0* ")
  public OffsetDateTime getLastExpired() {
    return lastExpired;
  }

   /**
   * Whether (one of) the scheduler is scheduling this DAG at the moment  *New in version 2.3.0* 
   * @return schedulerLock
  **/
  @Schema(description = "Whether (one of) the scheduler is scheduling this DAG at the moment  *New in version 2.3.0* ")
  public Boolean isSchedulerLock() {
    return schedulerLock;
  }

   /**
   * Foreign key to the latest pickle_id  *New in version 2.3.0* 
   * @return pickleId
  **/
  @Schema(description = "Foreign key to the latest pickle_id  *New in version 2.3.0* ")
  public String getPickleId() {
    return pickleId;
  }

   /**
   * Default view of the DAG inside the webserver  *New in version 2.3.0* 
   * @return defaultView
  **/
  @Schema(description = "Default view of the DAG inside the webserver  *New in version 2.3.0* ")
  public String getDefaultView() {
    return defaultView;
  }

   /**
   * The absolute path to the file.
   * @return fileloc
  **/
  @Schema(description = "The absolute path to the file.")
  public String getFileloc() {
    return fileloc;
  }

   /**
   * The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change. 
   * @return fileToken
  **/
  @Schema(description = "The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change. ")
  public String getFileToken() {
    return fileToken;
  }

   /**
   * Get owners
   * @return owners
  **/
  @Schema(description = "")
  public List<String> getOwners() {
    return owners;
  }

   /**
   * User-provided DAG description, which can consist of several sentences or paragraphs that describe DAG contents. 
   * @return description
  **/
  @Schema(description = "User-provided DAG description, which can consist of several sentences or paragraphs that describe DAG contents. ")
  public String getDescription() {
    return description;
  }

  public DAG scheduleInterval(ScheduleInterval scheduleInterval) {
    this.scheduleInterval = scheduleInterval;
    return this;
  }

   /**
   * Get scheduleInterval
   * @return scheduleInterval
  **/
  @Schema(description = "")
  public ScheduleInterval getScheduleInterval() {
    return scheduleInterval;
  }

  public void setScheduleInterval(ScheduleInterval scheduleInterval) {
    this.scheduleInterval = scheduleInterval;
  }

   /**
   * Timetable/Schedule Interval description.  *New in version 2.3.0* 
   * @return timetableDescription
  **/
  @Schema(description = "Timetable/Schedule Interval description.  *New in version 2.3.0* ")
  public String getTimetableDescription() {
    return timetableDescription;
  }

   /**
   * List of tags.
   * @return tags
  **/
  @Schema(description = "List of tags.")
  public List<Tag> getTags() {
    return tags;
  }

   /**
   * Maximum number of active tasks that can be run on the DAG  *New in version 2.3.0* 
   * @return maxActiveTasks
  **/
  @Schema(description = "Maximum number of active tasks that can be run on the DAG  *New in version 2.3.0* ")
  public Integer getMaxActiveTasks() {
    return maxActiveTasks;
  }

   /**
   * Maximum number of active DAG runs for the DAG  *New in version 2.3.0* 
   * @return maxActiveRuns
  **/
  @Schema(description = "Maximum number of active DAG runs for the DAG  *New in version 2.3.0* ")
  public Integer getMaxActiveRuns() {
    return maxActiveRuns;
  }

   /**
   * Whether the DAG has task concurrency limits  *New in version 2.3.0* 
   * @return hasTaskConcurrencyLimits
  **/
  @Schema(description = "Whether the DAG has task concurrency limits  *New in version 2.3.0* ")
  public Boolean isHasTaskConcurrencyLimits() {
    return hasTaskConcurrencyLimits;
  }

   /**
   * Whether the DAG has import errors  *New in version 2.3.0* 
   * @return hasImportErrors
  **/
  @Schema(description = "Whether the DAG has import errors  *New in version 2.3.0* ")
  public Boolean isHasImportErrors() {
    return hasImportErrors;
  }

   /**
   * The logical date of the next dag run.  *New in version 2.3.0* 
   * @return nextDagrun
  **/
  @Schema(description = "The logical date of the next dag run.  *New in version 2.3.0* ")
  public OffsetDateTime getNextDagrun() {
    return nextDagrun;
  }

   /**
   * The start of the interval of the next dag run.  *New in version 2.3.0* 
   * @return nextDagrunDataIntervalStart
  **/
  @Schema(description = "The start of the interval of the next dag run.  *New in version 2.3.0* ")
  public OffsetDateTime getNextDagrunDataIntervalStart() {
    return nextDagrunDataIntervalStart;
  }

   /**
   * The end of the interval of the next dag run.  *New in version 2.3.0* 
   * @return nextDagrunDataIntervalEnd
  **/
  @Schema(description = "The end of the interval of the next dag run.  *New in version 2.3.0* ")
  public OffsetDateTime getNextDagrunDataIntervalEnd() {
    return nextDagrunDataIntervalEnd;
  }

   /**
   * Earliest time at which this &#x60;&#x60;next_dagrun&#x60;&#x60; can be created.  *New in version 2.3.0* 
   * @return nextDagrunCreateAfter
  **/
  @Schema(description = "Earliest time at which this ``next_dagrun`` can be created.  *New in version 2.3.0* ")
  public OffsetDateTime getNextDagrunCreateAfter() {
    return nextDagrunCreateAfter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DAG DAG = (DAG) o;
    return Objects.equals(this.dagId, DAG.dagId) &&
        Objects.equals(this.rootDagId, DAG.rootDagId) &&
        Objects.equals(this.isPaused, DAG.isPaused) &&
        Objects.equals(this.isActive, DAG.isActive) &&
        Objects.equals(this.isSubdag, DAG.isSubdag) &&
        Objects.equals(this.lastParsedTime, DAG.lastParsedTime) &&
        Objects.equals(this.lastPickled, DAG.lastPickled) &&
        Objects.equals(this.lastExpired, DAG.lastExpired) &&
        Objects.equals(this.schedulerLock, DAG.schedulerLock) &&
        Objects.equals(this.pickleId, DAG.pickleId) &&
        Objects.equals(this.defaultView, DAG.defaultView) &&
        Objects.equals(this.fileloc, DAG.fileloc) &&
        Objects.equals(this.fileToken, DAG.fileToken) &&
        Objects.equals(this.owners, DAG.owners) &&
        Objects.equals(this.description, DAG.description) &&
        Objects.equals(this.scheduleInterval, DAG.scheduleInterval) &&
        Objects.equals(this.timetableDescription, DAG.timetableDescription) &&
        Objects.equals(this.tags, DAG.tags) &&
        Objects.equals(this.maxActiveTasks, DAG.maxActiveTasks) &&
        Objects.equals(this.maxActiveRuns, DAG.maxActiveRuns) &&
        Objects.equals(this.hasTaskConcurrencyLimits, DAG.hasTaskConcurrencyLimits) &&
        Objects.equals(this.hasImportErrors, DAG.hasImportErrors) &&
        Objects.equals(this.nextDagrun, DAG.nextDagrun) &&
        Objects.equals(this.nextDagrunDataIntervalStart, DAG.nextDagrunDataIntervalStart) &&
        Objects.equals(this.nextDagrunDataIntervalEnd, DAG.nextDagrunDataIntervalEnd) &&
        Objects.equals(this.nextDagrunCreateAfter, DAG.nextDagrunCreateAfter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dagId, rootDagId, isPaused, isActive, isSubdag, lastParsedTime, lastPickled, lastExpired, schedulerLock, pickleId, defaultView, fileloc, fileToken, owners, description, scheduleInterval, timetableDescription, tags, maxActiveTasks, maxActiveRuns, hasTaskConcurrencyLimits, hasImportErrors, nextDagrun, nextDagrunDataIntervalStart, nextDagrunDataIntervalEnd, nextDagrunCreateAfter);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DAG {\n");
    
    sb.append("    dagId: ").append(toIndentedString(dagId)).append("\n");
    sb.append("    rootDagId: ").append(toIndentedString(rootDagId)).append("\n");
    sb.append("    isPaused: ").append(toIndentedString(isPaused)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    isSubdag: ").append(toIndentedString(isSubdag)).append("\n");
    sb.append("    lastParsedTime: ").append(toIndentedString(lastParsedTime)).append("\n");
    sb.append("    lastPickled: ").append(toIndentedString(lastPickled)).append("\n");
    sb.append("    lastExpired: ").append(toIndentedString(lastExpired)).append("\n");
    sb.append("    schedulerLock: ").append(toIndentedString(schedulerLock)).append("\n");
    sb.append("    pickleId: ").append(toIndentedString(pickleId)).append("\n");
    sb.append("    defaultView: ").append(toIndentedString(defaultView)).append("\n");
    sb.append("    fileloc: ").append(toIndentedString(fileloc)).append("\n");
    sb.append("    fileToken: ").append(toIndentedString(fileToken)).append("\n");
    sb.append("    owners: ").append(toIndentedString(owners)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    scheduleInterval: ").append(toIndentedString(scheduleInterval)).append("\n");
    sb.append("    timetableDescription: ").append(toIndentedString(timetableDescription)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    maxActiveTasks: ").append(toIndentedString(maxActiveTasks)).append("\n");
    sb.append("    maxActiveRuns: ").append(toIndentedString(maxActiveRuns)).append("\n");
    sb.append("    hasTaskConcurrencyLimits: ").append(toIndentedString(hasTaskConcurrencyLimits)).append("\n");
    sb.append("    hasImportErrors: ").append(toIndentedString(hasImportErrors)).append("\n");
    sb.append("    nextDagrun: ").append(toIndentedString(nextDagrun)).append("\n");
    sb.append("    nextDagrunDataIntervalStart: ").append(toIndentedString(nextDagrunDataIntervalStart)).append("\n");
    sb.append("    nextDagrunDataIntervalEnd: ").append(toIndentedString(nextDagrunDataIntervalEnd)).append("\n");
    sb.append("    nextDagrunCreateAfter: ").append(toIndentedString(nextDagrunCreateAfter)).append("\n");
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
