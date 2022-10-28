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

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.ClearDagRun;
import io.swagger.client.model.DAGRun;
import io.swagger.client.model.DAGRunCollection;
import io.swagger.client.model.DatasetEventCollection;
import io.swagger.client.model.Error;
import io.swagger.client.model.ListDagRunsForm;
import org.threeten.bp.OffsetDateTime;
import io.swagger.client.model.UpdateDagRunState;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DagRunApi {
    private ApiClient apiClient;

    public DagRunApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DagRunApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for clearDagRun
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call clearDagRunCall(ClearDagRun body, String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}/clear"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call clearDagRunValidateBeforeCall(ClearDagRun body, String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling clearDagRun(Async)");
        }
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling clearDagRun(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling clearDagRun(Async)");
        }
        
        com.squareup.okhttp.Call call = clearDagRunCall(body, dagId, dagRunId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Clear a DAG run
     * Clear a DAG run.  *New in version 2.4.0* 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return DAGRun
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGRun clearDagRun(ClearDagRun body, String dagId, String dagRunId) throws ApiException {
        ApiResponse<DAGRun> resp = clearDagRunWithHttpInfo(body, dagId, dagRunId);
        return resp.getData();
    }

    /**
     * Clear a DAG run
     * Clear a DAG run.  *New in version 2.4.0* 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return ApiResponse&lt;DAGRun&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGRun> clearDagRunWithHttpInfo(ClearDagRun body, String dagId, String dagRunId) throws ApiException {
        com.squareup.okhttp.Call call = clearDagRunValidateBeforeCall(body, dagId, dagRunId, null, null);
        Type localVarReturnType = new TypeToken<DAGRun>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Clear a DAG run (asynchronously)
     * Clear a DAG run.  *New in version 2.4.0* 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call clearDagRunAsync(ClearDagRun body, String dagId, String dagRunId, final ApiCallback<DAGRun> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = clearDagRunValidateBeforeCall(body, dagId, dagRunId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGRun>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteDagRun
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteDagRunCall(String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteDagRunValidateBeforeCall(String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling deleteDagRun(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling deleteDagRun(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteDagRunCall(dagId, dagRunId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a DAG run
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteDagRun(String dagId, String dagRunId) throws ApiException {
        deleteDagRunWithHttpInfo(dagId, dagRunId);
    }

    /**
     * Delete a DAG run
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteDagRunWithHttpInfo(String dagId, String dagRunId) throws ApiException {
        com.squareup.okhttp.Call call = deleteDagRunValidateBeforeCall(dagId, dagRunId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete a DAG run (asynchronously)
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteDagRunAsync(String dagId, String dagRunId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteDagRunValidateBeforeCall(dagId, dagRunId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getDagRun
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDagRunCall(String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDagRunValidateBeforeCall(String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getDagRun(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling getDagRun(Async)");
        }
        
        com.squareup.okhttp.Call call = getDagRunCall(dagId, dagRunId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a DAG run
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return DAGRun
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGRun getDagRun(String dagId, String dagRunId) throws ApiException {
        ApiResponse<DAGRun> resp = getDagRunWithHttpInfo(dagId, dagRunId);
        return resp.getData();
    }

    /**
     * Get a DAG run
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return ApiResponse&lt;DAGRun&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGRun> getDagRunWithHttpInfo(String dagId, String dagRunId) throws ApiException {
        com.squareup.okhttp.Call call = getDagRunValidateBeforeCall(dagId, dagRunId, null, null);
        Type localVarReturnType = new TypeToken<DAGRun>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a DAG run (asynchronously)
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDagRunAsync(String dagId, String dagRunId, final ApiCallback<DAGRun> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDagRunValidateBeforeCall(dagId, dagRunId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGRun>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDagRuns
     * @param dagId The DAG ID. (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDagRunsCall(String dagId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, List<String> state, String orderBy, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (executionDateGte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("execution_date_gte", executionDateGte));
        if (executionDateLte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("execution_date_lte", executionDateLte));
        if (startDateGte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("start_date_gte", startDateGte));
        if (startDateLte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("start_date_lte", startDateLte));
        if (endDateGte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("end_date_gte", endDateGte));
        if (endDateLte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("end_date_lte", endDateLte));
        if (state != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "state", state));
        if (orderBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("order_by", orderBy));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDagRunsValidateBeforeCall(String dagId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, List<String> state, String orderBy, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getDagRuns(Async)");
        }
        
        com.squareup.okhttp.Call call = getDagRunsCall(dagId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, state, orderBy, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List DAG runs
     * This endpoint allows specifying &#x60;~&#x60; as the dag_id to retrieve DAG runs for all DAGs. 
     * @param dagId The DAG ID. (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @return DAGRunCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGRunCollection getDagRuns(String dagId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, List<String> state, String orderBy) throws ApiException {
        ApiResponse<DAGRunCollection> resp = getDagRunsWithHttpInfo(dagId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, state, orderBy);
        return resp.getData();
    }

    /**
     * List DAG runs
     * This endpoint allows specifying &#x60;~&#x60; as the dag_id to retrieve DAG runs for all DAGs. 
     * @param dagId The DAG ID. (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @return ApiResponse&lt;DAGRunCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGRunCollection> getDagRunsWithHttpInfo(String dagId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, List<String> state, String orderBy) throws ApiException {
        com.squareup.okhttp.Call call = getDagRunsValidateBeforeCall(dagId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, state, orderBy, null, null);
        Type localVarReturnType = new TypeToken<DAGRunCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List DAG runs (asynchronously)
     * This endpoint allows specifying &#x60;~&#x60; as the dag_id to retrieve DAG runs for all DAGs. 
     * @param dagId The DAG ID. (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDagRunsAsync(String dagId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, List<String> state, String orderBy, final ApiCallback<DAGRunCollection> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDagRunsValidateBeforeCall(dagId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, state, orderBy, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGRunCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDagRunsBatch
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDagRunsBatchCall(ListDagRunsForm body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags/~/dagRuns/list";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDagRunsBatchValidateBeforeCall(ListDagRunsForm body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling getDagRunsBatch(Async)");
        }
        
        com.squareup.okhttp.Call call = getDagRunsBatchCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List DAG runs (batch)
     * This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limit. 
     * @param body  (required)
     * @return DAGRunCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGRunCollection getDagRunsBatch(ListDagRunsForm body) throws ApiException {
        ApiResponse<DAGRunCollection> resp = getDagRunsBatchWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * List DAG runs (batch)
     * This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limit. 
     * @param body  (required)
     * @return ApiResponse&lt;DAGRunCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGRunCollection> getDagRunsBatchWithHttpInfo(ListDagRunsForm body) throws ApiException {
        com.squareup.okhttp.Call call = getDagRunsBatchValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<DAGRunCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List DAG runs (batch) (asynchronously)
     * This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limit. 
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDagRunsBatchAsync(ListDagRunsForm body, final ApiCallback<DAGRunCollection> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDagRunsBatchValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGRunCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getUpstreamDatasetEvents
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getUpstreamDatasetEventsCall(String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}/upstreamDatasetEvents"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getUpstreamDatasetEventsValidateBeforeCall(String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getUpstreamDatasetEvents(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling getUpstreamDatasetEvents(Async)");
        }
        
        com.squareup.okhttp.Call call = getUpstreamDatasetEventsCall(dagId, dagRunId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get dataset events for a DAG run
     * Get datasets for a dag run.  *New in version 2.4.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return DatasetEventCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DatasetEventCollection getUpstreamDatasetEvents(String dagId, String dagRunId) throws ApiException {
        ApiResponse<DatasetEventCollection> resp = getUpstreamDatasetEventsWithHttpInfo(dagId, dagRunId);
        return resp.getData();
    }

    /**
     * Get dataset events for a DAG run
     * Get datasets for a dag run.  *New in version 2.4.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return ApiResponse&lt;DatasetEventCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DatasetEventCollection> getUpstreamDatasetEventsWithHttpInfo(String dagId, String dagRunId) throws ApiException {
        com.squareup.okhttp.Call call = getUpstreamDatasetEventsValidateBeforeCall(dagId, dagRunId, null, null);
        Type localVarReturnType = new TypeToken<DatasetEventCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get dataset events for a DAG run (asynchronously)
     * Get datasets for a dag run.  *New in version 2.4.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUpstreamDatasetEventsAsync(String dagId, String dagRunId, final ApiCallback<DatasetEventCollection> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getUpstreamDatasetEventsValidateBeforeCall(dagId, dagRunId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DatasetEventCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postDagRun
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postDagRunCall(DAGRun body, String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postDagRunValidateBeforeCall(DAGRun body, String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling postDagRun(Async)");
        }
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling postDagRun(Async)");
        }
        
        com.squareup.okhttp.Call call = postDagRunCall(body, dagId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Trigger a new DAG run
     * 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @return DAGRun
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGRun postDagRun(DAGRun body, String dagId) throws ApiException {
        ApiResponse<DAGRun> resp = postDagRunWithHttpInfo(body, dagId);
        return resp.getData();
    }

    /**
     * Trigger a new DAG run
     * 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @return ApiResponse&lt;DAGRun&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGRun> postDagRunWithHttpInfo(DAGRun body, String dagId) throws ApiException {
        com.squareup.okhttp.Call call = postDagRunValidateBeforeCall(body, dagId, null, null);
        Type localVarReturnType = new TypeToken<DAGRun>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Trigger a new DAG run (asynchronously)
     * 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postDagRunAsync(DAGRun body, String dagId, final ApiCallback<DAGRun> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postDagRunValidateBeforeCall(body, dagId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGRun>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateDagRunState
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateDagRunStateCall(UpdateDagRunState body, String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateDagRunStateValidateBeforeCall(UpdateDagRunState body, String dagId, String dagRunId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling updateDagRunState(Async)");
        }
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling updateDagRunState(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling updateDagRunState(Async)");
        }
        
        com.squareup.okhttp.Call call = updateDagRunStateCall(body, dagId, dagRunId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Modify a DAG run
     * Modify a DAG run.  *New in version 2.2.0* 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return DAGRun
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGRun updateDagRunState(UpdateDagRunState body, String dagId, String dagRunId) throws ApiException {
        ApiResponse<DAGRun> resp = updateDagRunStateWithHttpInfo(body, dagId, dagRunId);
        return resp.getData();
    }

    /**
     * Modify a DAG run
     * Modify a DAG run.  *New in version 2.2.0* 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @return ApiResponse&lt;DAGRun&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGRun> updateDagRunStateWithHttpInfo(UpdateDagRunState body, String dagId, String dagRunId) throws ApiException {
        com.squareup.okhttp.Call call = updateDagRunStateValidateBeforeCall(body, dagId, dagRunId, null, null);
        Type localVarReturnType = new TypeToken<DAGRun>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Modify a DAG run (asynchronously)
     * Modify a DAG run.  *New in version 2.2.0* 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateDagRunStateAsync(UpdateDagRunState body, String dagId, String dagRunId, final ApiCallback<DAGRun> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateDagRunStateValidateBeforeCall(body, dagId, dagRunId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGRun>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
