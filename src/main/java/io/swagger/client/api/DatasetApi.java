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


import io.swagger.client.model.Dataset;
import io.swagger.client.model.DatasetCollection;
import io.swagger.client.model.DatasetEventCollection;
import io.swagger.client.model.Error;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatasetApi {
    private ApiClient apiClient;

    public DatasetApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DatasetApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getDataset
     * @param uri The encoded Dataset URI (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDatasetCall(String uri, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/datasets/{uri}"
            .replaceAll("\\{" + "uri" + "\\}", apiClient.escapeString(uri.toString()));

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
    private com.squareup.okhttp.Call getDatasetValidateBeforeCall(String uri, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'uri' is set
        if (uri == null) {
            throw new ApiException("Missing the required parameter 'uri' when calling getDataset(Async)");
        }
        
        com.squareup.okhttp.Call call = getDatasetCall(uri, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a dataset
     * Get a dataset by uri.
     * @param uri The encoded Dataset URI (required)
     * @return Dataset
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Dataset getDataset(String uri) throws ApiException {
        ApiResponse<Dataset> resp = getDatasetWithHttpInfo(uri);
        return resp.getData();
    }

    /**
     * Get a dataset
     * Get a dataset by uri.
     * @param uri The encoded Dataset URI (required)
     * @return ApiResponse&lt;Dataset&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Dataset> getDatasetWithHttpInfo(String uri) throws ApiException {
        com.squareup.okhttp.Call call = getDatasetValidateBeforeCall(uri, null, null);
        Type localVarReturnType = new TypeToken<Dataset>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a dataset (asynchronously)
     * Get a dataset by uri.
     * @param uri The encoded Dataset URI (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDatasetAsync(String uri, final ApiCallback<Dataset> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDatasetValidateBeforeCall(uri, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Dataset>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDatasetEvents
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param datasetId The Dataset ID that updated the dataset. (optional)
     * @param sourceDagId The DAG ID that updated the dataset. (optional)
     * @param sourceTaskId The task ID that updated the dataset. (optional)
     * @param sourceRunId The DAG run ID that updated the dataset. (optional)
     * @param sourceMapIndex The map index that updated the dataset. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDatasetEventsCall(Integer limit, Integer offset, String orderBy, Integer datasetId, String sourceDagId, String sourceTaskId, String sourceRunId, Integer sourceMapIndex, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/datasets/events";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (orderBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("order_by", orderBy));
        if (datasetId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("dataset_id", datasetId));
        if (sourceDagId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("source_dag_id", sourceDagId));
        if (sourceTaskId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("source_task_id", sourceTaskId));
        if (sourceRunId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("source_run_id", sourceRunId));
        if (sourceMapIndex != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("source_map_index", sourceMapIndex));

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
    private com.squareup.okhttp.Call getDatasetEventsValidateBeforeCall(Integer limit, Integer offset, String orderBy, Integer datasetId, String sourceDagId, String sourceTaskId, String sourceRunId, Integer sourceMapIndex, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getDatasetEventsCall(limit, offset, orderBy, datasetId, sourceDagId, sourceTaskId, sourceRunId, sourceMapIndex, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get dataset events
     * Get dataset events
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param datasetId The Dataset ID that updated the dataset. (optional)
     * @param sourceDagId The DAG ID that updated the dataset. (optional)
     * @param sourceTaskId The task ID that updated the dataset. (optional)
     * @param sourceRunId The DAG run ID that updated the dataset. (optional)
     * @param sourceMapIndex The map index that updated the dataset. (optional)
     * @return DatasetEventCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DatasetEventCollection getDatasetEvents(Integer limit, Integer offset, String orderBy, Integer datasetId, String sourceDagId, String sourceTaskId, String sourceRunId, Integer sourceMapIndex) throws ApiException {
        ApiResponse<DatasetEventCollection> resp = getDatasetEventsWithHttpInfo(limit, offset, orderBy, datasetId, sourceDagId, sourceTaskId, sourceRunId, sourceMapIndex);
        return resp.getData();
    }

    /**
     * Get dataset events
     * Get dataset events
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param datasetId The Dataset ID that updated the dataset. (optional)
     * @param sourceDagId The DAG ID that updated the dataset. (optional)
     * @param sourceTaskId The task ID that updated the dataset. (optional)
     * @param sourceRunId The DAG run ID that updated the dataset. (optional)
     * @param sourceMapIndex The map index that updated the dataset. (optional)
     * @return ApiResponse&lt;DatasetEventCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DatasetEventCollection> getDatasetEventsWithHttpInfo(Integer limit, Integer offset, String orderBy, Integer datasetId, String sourceDagId, String sourceTaskId, String sourceRunId, Integer sourceMapIndex) throws ApiException {
        com.squareup.okhttp.Call call = getDatasetEventsValidateBeforeCall(limit, offset, orderBy, datasetId, sourceDagId, sourceTaskId, sourceRunId, sourceMapIndex, null, null);
        Type localVarReturnType = new TypeToken<DatasetEventCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get dataset events (asynchronously)
     * Get dataset events
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param datasetId The Dataset ID that updated the dataset. (optional)
     * @param sourceDagId The DAG ID that updated the dataset. (optional)
     * @param sourceTaskId The task ID that updated the dataset. (optional)
     * @param sourceRunId The DAG run ID that updated the dataset. (optional)
     * @param sourceMapIndex The map index that updated the dataset. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDatasetEventsAsync(Integer limit, Integer offset, String orderBy, Integer datasetId, String sourceDagId, String sourceTaskId, String sourceRunId, Integer sourceMapIndex, final ApiCallback<DatasetEventCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDatasetEventsValidateBeforeCall(limit, offset, orderBy, datasetId, sourceDagId, sourceTaskId, sourceRunId, sourceMapIndex, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DatasetEventCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDatasets
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param uriPattern If set, only return datasets with uris matching this pattern.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDatasetsCall(Integer limit, Integer offset, String orderBy, String uriPattern, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/datasets";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (orderBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("order_by", orderBy));
        if (uriPattern != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("uri_pattern", uriPattern));

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
    private com.squareup.okhttp.Call getDatasetsValidateBeforeCall(Integer limit, Integer offset, String orderBy, String uriPattern, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getDatasetsCall(limit, offset, orderBy, uriPattern, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List datasets
     * 
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param uriPattern If set, only return datasets with uris matching this pattern.  (optional)
     * @return DatasetCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DatasetCollection getDatasets(Integer limit, Integer offset, String orderBy, String uriPattern) throws ApiException {
        ApiResponse<DatasetCollection> resp = getDatasetsWithHttpInfo(limit, offset, orderBy, uriPattern);
        return resp.getData();
    }

    /**
     * List datasets
     * 
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param uriPattern If set, only return datasets with uris matching this pattern.  (optional)
     * @return ApiResponse&lt;DatasetCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DatasetCollection> getDatasetsWithHttpInfo(Integer limit, Integer offset, String orderBy, String uriPattern) throws ApiException {
        com.squareup.okhttp.Call call = getDatasetsValidateBeforeCall(limit, offset, orderBy, uriPattern, null, null);
        Type localVarReturnType = new TypeToken<DatasetCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List datasets (asynchronously)
     * 
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param uriPattern If set, only return datasets with uris matching this pattern.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDatasetsAsync(Integer limit, Integer offset, String orderBy, String uriPattern, final ApiCallback<DatasetCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDatasetsValidateBeforeCall(limit, offset, orderBy, uriPattern, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DatasetCollection>(){}.getType();
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
}
