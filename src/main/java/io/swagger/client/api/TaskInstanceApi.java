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


import java.math.BigDecimal;
import io.swagger.client.model.Error;
import io.swagger.client.model.ExtraLinkCollection;
import io.swagger.client.model.InlineResponse2001;
import io.swagger.client.model.ListTaskInstanceForm;
import org.threeten.bp.OffsetDateTime;
import io.swagger.client.model.TaskInstance;
import io.swagger.client.model.TaskInstanceCollection;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskInstanceApi {
    private ApiClient apiClient;

    public TaskInstanceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TaskInstanceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getExtraLinks
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getExtraLinksCall(String dagId, String dagRunId, String taskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/links"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()))
            .replaceAll("\\{" + "task_id" + "\\}", apiClient.escapeString(taskId.toString()));

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
    private com.squareup.okhttp.Call getExtraLinksValidateBeforeCall(String dagId, String dagRunId, String taskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getExtraLinks(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling getExtraLinks(Async)");
        }
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling getExtraLinks(Async)");
        }
        
        com.squareup.okhttp.Call call = getExtraLinksCall(dagId, dagRunId, taskId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List extra links
     * List extra links for task instance. 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @return ExtraLinkCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExtraLinkCollection getExtraLinks(String dagId, String dagRunId, String taskId) throws ApiException {
        ApiResponse<ExtraLinkCollection> resp = getExtraLinksWithHttpInfo(dagId, dagRunId, taskId);
        return resp.getData();
    }

    /**
     * List extra links
     * List extra links for task instance. 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @return ApiResponse&lt;ExtraLinkCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ExtraLinkCollection> getExtraLinksWithHttpInfo(String dagId, String dagRunId, String taskId) throws ApiException {
        com.squareup.okhttp.Call call = getExtraLinksValidateBeforeCall(dagId, dagRunId, taskId, null, null);
        Type localVarReturnType = new TypeToken<ExtraLinkCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List extra links (asynchronously)
     * List extra links for task instance. 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getExtraLinksAsync(String dagId, String dagRunId, String taskId, final ApiCallback<ExtraLinkCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getExtraLinksValidateBeforeCall(dagId, dagRunId, taskId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ExtraLinkCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getLog
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param taskTryNumber The task try number. (required)
     * @param fullContent A full content will be returned. By default, only the first fragment will be returned.  (optional)
     * @param mapIndex Filter on map index for mapped task. (optional)
     * @param token A token that allows you to continue fetching logs. If passed, it will specify the location from which the download should be continued.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getLogCall(String dagId, String dagRunId, String taskId, Integer taskTryNumber, Boolean fullContent, Integer mapIndex, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/logs/{task_try_number}"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()))
            .replaceAll("\\{" + "task_id" + "\\}", apiClient.escapeString(taskId.toString()))
            .replaceAll("\\{" + "task_try_number" + "\\}", apiClient.escapeString(taskTryNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fullContent != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("full_content", fullContent));
        if (mapIndex != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("map_index", mapIndex));
        if (token != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("token", token));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
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
    private com.squareup.okhttp.Call getLogValidateBeforeCall(String dagId, String dagRunId, String taskId, Integer taskTryNumber, Boolean fullContent, Integer mapIndex, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getLog(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling getLog(Async)");
        }
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling getLog(Async)");
        }
        // verify the required parameter 'taskTryNumber' is set
        if (taskTryNumber == null) {
            throw new ApiException("Missing the required parameter 'taskTryNumber' when calling getLog(Async)");
        }
        
        com.squareup.okhttp.Call call = getLogCall(dagId, dagRunId, taskId, taskTryNumber, fullContent, mapIndex, token, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get logs
     * Get logs for a specific task instance and its try number.
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param taskTryNumber The task try number. (required)
     * @param fullContent A full content will be returned. By default, only the first fragment will be returned.  (optional)
     * @param mapIndex Filter on map index for mapped task. (optional)
     * @param token A token that allows you to continue fetching logs. If passed, it will specify the location from which the download should be continued.  (optional)
     * @return InlineResponse2001
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2001 getLog(String dagId, String dagRunId, String taskId, Integer taskTryNumber, Boolean fullContent, Integer mapIndex, String token) throws ApiException {
        ApiResponse<InlineResponse2001> resp = getLogWithHttpInfo(dagId, dagRunId, taskId, taskTryNumber, fullContent, mapIndex, token);
        return resp.getData();
    }

    /**
     * Get logs
     * Get logs for a specific task instance and its try number.
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param taskTryNumber The task try number. (required)
     * @param fullContent A full content will be returned. By default, only the first fragment will be returned.  (optional)
     * @param mapIndex Filter on map index for mapped task. (optional)
     * @param token A token that allows you to continue fetching logs. If passed, it will specify the location from which the download should be continued.  (optional)
     * @return ApiResponse&lt;InlineResponse2001&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2001> getLogWithHttpInfo(String dagId, String dagRunId, String taskId, Integer taskTryNumber, Boolean fullContent, Integer mapIndex, String token) throws ApiException {
        com.squareup.okhttp.Call call = getLogValidateBeforeCall(dagId, dagRunId, taskId, taskTryNumber, fullContent, mapIndex, token, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get logs (asynchronously)
     * Get logs for a specific task instance and its try number.
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param taskTryNumber The task try number. (required)
     * @param fullContent A full content will be returned. By default, only the first fragment will be returned.  (optional)
     * @param mapIndex Filter on map index for mapped task. (optional)
     * @param token A token that allows you to continue fetching logs. If passed, it will specify the location from which the download should be continued.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getLogAsync(String dagId, String dagRunId, String taskId, Integer taskTryNumber, Boolean fullContent, Integer mapIndex, String token, final ApiCallback<InlineResponse2001> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getLogValidateBeforeCall(dagId, dagRunId, taskId, taskTryNumber, fullContent, mapIndex, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getMappedTaskInstance
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param mapIndex The map index. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getMappedTaskInstanceCall(String dagId, String dagRunId, String taskId, Integer mapIndex, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/{map_index}"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()))
            .replaceAll("\\{" + "task_id" + "\\}", apiClient.escapeString(taskId.toString()))
            .replaceAll("\\{" + "map_index" + "\\}", apiClient.escapeString(mapIndex.toString()));

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
    private com.squareup.okhttp.Call getMappedTaskInstanceValidateBeforeCall(String dagId, String dagRunId, String taskId, Integer mapIndex, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getMappedTaskInstance(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling getMappedTaskInstance(Async)");
        }
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling getMappedTaskInstance(Async)");
        }
        // verify the required parameter 'mapIndex' is set
        if (mapIndex == null) {
            throw new ApiException("Missing the required parameter 'mapIndex' when calling getMappedTaskInstance(Async)");
        }
        
        com.squareup.okhttp.Call call = getMappedTaskInstanceCall(dagId, dagRunId, taskId, mapIndex, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a mapped task instance
     * Get details of a mapped task instance.  *New in version 2.3.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param mapIndex The map index. (required)
     * @return TaskInstance
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskInstance getMappedTaskInstance(String dagId, String dagRunId, String taskId, Integer mapIndex) throws ApiException {
        ApiResponse<TaskInstance> resp = getMappedTaskInstanceWithHttpInfo(dagId, dagRunId, taskId, mapIndex);
        return resp.getData();
    }

    /**
     * Get a mapped task instance
     * Get details of a mapped task instance.  *New in version 2.3.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param mapIndex The map index. (required)
     * @return ApiResponse&lt;TaskInstance&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TaskInstance> getMappedTaskInstanceWithHttpInfo(String dagId, String dagRunId, String taskId, Integer mapIndex) throws ApiException {
        com.squareup.okhttp.Call call = getMappedTaskInstanceValidateBeforeCall(dagId, dagRunId, taskId, mapIndex, null, null);
        Type localVarReturnType = new TypeToken<TaskInstance>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a mapped task instance (asynchronously)
     * Get details of a mapped task instance.  *New in version 2.3.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param mapIndex The map index. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getMappedTaskInstanceAsync(String dagId, String dagRunId, String taskId, Integer mapIndex, final ApiCallback<TaskInstance> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getMappedTaskInstanceValidateBeforeCall(dagId, dagRunId, taskId, mapIndex, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskInstance>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getMappedTaskInstances
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param durationGte Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  (optional)
     * @param durationLte Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param pool The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param queue The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getMappedTaskInstancesCall(String dagId, String dagRunId, String taskId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, String orderBy, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/listMapped"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()))
            .replaceAll("\\{" + "task_id" + "\\}", apiClient.escapeString(taskId.toString()));

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
        if (durationGte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("duration_gte", durationGte));
        if (durationLte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("duration_lte", durationLte));
        if (state != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "state", state));
        if (pool != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "pool", pool));
        if (queue != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "queue", queue));
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
    private com.squareup.okhttp.Call getMappedTaskInstancesValidateBeforeCall(String dagId, String dagRunId, String taskId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, String orderBy, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getMappedTaskInstances(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling getMappedTaskInstances(Async)");
        }
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling getMappedTaskInstances(Async)");
        }
        
        com.squareup.okhttp.Call call = getMappedTaskInstancesCall(dagId, dagRunId, taskId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, orderBy, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List mapped task instances
     * Get details of all mapped task instances.  *New in version 2.3.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param durationGte Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  (optional)
     * @param durationLte Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param pool The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param queue The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @return TaskInstanceCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskInstanceCollection getMappedTaskInstances(String dagId, String dagRunId, String taskId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, String orderBy) throws ApiException {
        ApiResponse<TaskInstanceCollection> resp = getMappedTaskInstancesWithHttpInfo(dagId, dagRunId, taskId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, orderBy);
        return resp.getData();
    }

    /**
     * List mapped task instances
     * Get details of all mapped task instances.  *New in version 2.3.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param durationGte Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  (optional)
     * @param durationLte Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param pool The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param queue The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @return ApiResponse&lt;TaskInstanceCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TaskInstanceCollection> getMappedTaskInstancesWithHttpInfo(String dagId, String dagRunId, String taskId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, String orderBy) throws ApiException {
        com.squareup.okhttp.Call call = getMappedTaskInstancesValidateBeforeCall(dagId, dagRunId, taskId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, orderBy, null, null);
        Type localVarReturnType = new TypeToken<TaskInstanceCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List mapped task instances (asynchronously)
     * Get details of all mapped task instances.  *New in version 2.3.0* 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param durationGte Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  (optional)
     * @param durationLte Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param pool The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param queue The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getMappedTaskInstancesAsync(String dagId, String dagRunId, String taskId, Integer limit, Integer offset, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, String orderBy, final ApiCallback<TaskInstanceCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getMappedTaskInstancesValidateBeforeCall(dagId, dagRunId, taskId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, orderBy, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskInstanceCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskInstance
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTaskInstanceCall(String dagId, String dagRunId, String taskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()))
            .replaceAll("\\{" + "task_id" + "\\}", apiClient.escapeString(taskId.toString()));

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
    private com.squareup.okhttp.Call getTaskInstanceValidateBeforeCall(String dagId, String dagRunId, String taskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getTaskInstance(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling getTaskInstance(Async)");
        }
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling getTaskInstance(Async)");
        }
        
        com.squareup.okhttp.Call call = getTaskInstanceCall(dagId, dagRunId, taskId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a task instance
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @return TaskInstance
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskInstance getTaskInstance(String dagId, String dagRunId, String taskId) throws ApiException {
        ApiResponse<TaskInstance> resp = getTaskInstanceWithHttpInfo(dagId, dagRunId, taskId);
        return resp.getData();
    }

    /**
     * Get a task instance
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @return ApiResponse&lt;TaskInstance&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TaskInstance> getTaskInstanceWithHttpInfo(String dagId, String dagRunId, String taskId) throws ApiException {
        com.squareup.okhttp.Call call = getTaskInstanceValidateBeforeCall(dagId, dagRunId, taskId, null, null);
        Type localVarReturnType = new TypeToken<TaskInstance>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a task instance (asynchronously)
     * 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param taskId The task ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskInstanceAsync(String dagId, String dagRunId, String taskId, final ApiCallback<TaskInstance> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getTaskInstanceValidateBeforeCall(dagId, dagRunId, taskId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskInstance>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskInstances
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param durationGte Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  (optional)
     * @param durationLte Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param pool The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param queue The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTaskInstancesCall(String dagId, String dagRunId, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, Integer limit, Integer offset, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
            .replaceAll("\\{" + "dag_run_id" + "\\}", apiClient.escapeString(dagRunId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
        if (durationGte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("duration_gte", durationGte));
        if (durationLte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("duration_lte", durationLte));
        if (state != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "state", state));
        if (pool != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "pool", pool));
        if (queue != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "queue", queue));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));

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
    private com.squareup.okhttp.Call getTaskInstancesValidateBeforeCall(String dagId, String dagRunId, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, Integer limit, Integer offset, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getTaskInstances(Async)");
        }
        // verify the required parameter 'dagRunId' is set
        if (dagRunId == null) {
            throw new ApiException("Missing the required parameter 'dagRunId' when calling getTaskInstances(Async)");
        }
        
        com.squareup.okhttp.Call call = getTaskInstancesCall(dagId, dagRunId, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, limit, offset, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List task instances
     * This endpoint allows specifying &#x60;~&#x60; as the dag_id, dag_run_id to retrieve DAG runs for all DAGs and DAG runs. 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param durationGte Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  (optional)
     * @param durationLte Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param pool The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param queue The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @return TaskInstanceCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskInstanceCollection getTaskInstances(String dagId, String dagRunId, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, Integer limit, Integer offset) throws ApiException {
        ApiResponse<TaskInstanceCollection> resp = getTaskInstancesWithHttpInfo(dagId, dagRunId, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, limit, offset);
        return resp.getData();
    }

    /**
     * List task instances
     * This endpoint allows specifying &#x60;~&#x60; as the dag_id, dag_run_id to retrieve DAG runs for all DAGs and DAG runs. 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param durationGte Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  (optional)
     * @param durationLte Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param pool The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param queue The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @return ApiResponse&lt;TaskInstanceCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TaskInstanceCollection> getTaskInstancesWithHttpInfo(String dagId, String dagRunId, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, Integer limit, Integer offset) throws ApiException {
        com.squareup.okhttp.Call call = getTaskInstancesValidateBeforeCall(dagId, dagRunId, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, limit, offset, null, null);
        Type localVarReturnType = new TypeToken<TaskInstanceCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List task instances (asynchronously)
     * This endpoint allows specifying &#x60;~&#x60; as the dag_id, dag_run_id to retrieve DAG runs for all DAGs and DAG runs. 
     * @param dagId The DAG ID. (required)
     * @param dagRunId The DAG run ID. (required)
     * @param executionDateGte Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  (optional)
     * @param executionDateLte Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  (optional)
     * @param startDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param startDateLte Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param endDateGte Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  (optional)
     * @param endDateLte Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  (optional)
     * @param durationGte Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  (optional)
     * @param durationLte Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  (optional)
     * @param state The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param pool The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param queue The value can be repeated to retrieve multiple matching values (OR condition). (optional)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskInstancesAsync(String dagId, String dagRunId, OffsetDateTime executionDateGte, OffsetDateTime executionDateLte, OffsetDateTime startDateGte, OffsetDateTime startDateLte, OffsetDateTime endDateGte, OffsetDateTime endDateLte, BigDecimal durationGte, BigDecimal durationLte, List<String> state, List<String> pool, List<String> queue, Integer limit, Integer offset, final ApiCallback<TaskInstanceCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getTaskInstancesValidateBeforeCall(dagId, dagRunId, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, limit, offset, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskInstanceCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTaskInstancesBatch
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTaskInstancesBatchCall(ListTaskInstanceForm body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags/~/dagRuns/~/taskInstances/list";

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
    private com.squareup.okhttp.Call getTaskInstancesBatchValidateBeforeCall(ListTaskInstanceForm body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling getTaskInstancesBatch(Async)");
        }
        
        com.squareup.okhttp.Call call = getTaskInstancesBatchCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List task instances (batch)
     * List task instances from all DAGs and DAG runs. This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limits. 
     * @param body  (required)
     * @return TaskInstanceCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskInstanceCollection getTaskInstancesBatch(ListTaskInstanceForm body) throws ApiException {
        ApiResponse<TaskInstanceCollection> resp = getTaskInstancesBatchWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * List task instances (batch)
     * List task instances from all DAGs and DAG runs. This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limits. 
     * @param body  (required)
     * @return ApiResponse&lt;TaskInstanceCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TaskInstanceCollection> getTaskInstancesBatchWithHttpInfo(ListTaskInstanceForm body) throws ApiException {
        com.squareup.okhttp.Call call = getTaskInstancesBatchValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<TaskInstanceCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List task instances (batch) (asynchronously)
     * List task instances from all DAGs and DAG runs. This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limits. 
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskInstancesBatchAsync(ListTaskInstanceForm body, final ApiCallback<TaskInstanceCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getTaskInstancesBatchValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskInstanceCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
