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


import io.swagger.client.model.ClearTaskInstances;
import io.swagger.client.model.DAG;
import io.swagger.client.model.DAGCollection;
import io.swagger.client.model.DAGDetail;
import io.swagger.client.model.Error;
import io.swagger.client.model.InlineResponse2002;
import io.swagger.client.model.Task;
import io.swagger.client.model.TaskCollection;
import io.swagger.client.model.TaskInstanceReferenceCollection;
import io.swagger.client.model.UpdateTaskInstancesState;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DagApi {
    private ApiClient apiClient;

    public DagApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DagApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for deleteDag
     * @param dagId The DAG ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteDagCall(String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}"
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
    private com.squareup.okhttp.Call deleteDagValidateBeforeCall(String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling deleteDag(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteDagCall(dagId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a DAG
     * Deletes all metadata related to the DAG, including finished DAG Runs and Tasks. Logs are not deleted. This action cannot be undone.  *New in version 2.2.0* 
     * @param dagId The DAG ID. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteDag(String dagId) throws ApiException {
        deleteDagWithHttpInfo(dagId);
    }

    /**
     * Delete a DAG
     * Deletes all metadata related to the DAG, including finished DAG Runs and Tasks. Logs are not deleted. This action cannot be undone.  *New in version 2.2.0* 
     * @param dagId The DAG ID. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteDagWithHttpInfo(String dagId) throws ApiException {
        com.squareup.okhttp.Call call = deleteDagValidateBeforeCall(dagId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete a DAG (asynchronously)
     * Deletes all metadata related to the DAG, including finished DAG Runs and Tasks. Logs are not deleted. This action cannot be undone.  *New in version 2.2.0* 
     * @param dagId The DAG ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteDagAsync(String dagId, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteDagValidateBeforeCall(dagId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getDag
     * @param dagId The DAG ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDagCall(String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}"
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
    private com.squareup.okhttp.Call getDagValidateBeforeCall(String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getDag(Async)");
        }
        
        com.squareup.okhttp.Call call = getDagCall(dagId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get basic information about a DAG
     * Presents only information available in database (DAGModel). If you need detailed information, consider using GET /dags/{dag_id}/details. 
     * @param dagId The DAG ID. (required)
     * @return DAG
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAG getDag(String dagId) throws ApiException {
        ApiResponse<DAG> resp = getDagWithHttpInfo(dagId);
        return resp.getData();
    }

    /**
     * Get basic information about a DAG
     * Presents only information available in database (DAGModel). If you need detailed information, consider using GET /dags/{dag_id}/details. 
     * @param dagId The DAG ID. (required)
     * @return ApiResponse&lt;DAG&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAG> getDagWithHttpInfo(String dagId) throws ApiException {
        com.squareup.okhttp.Call call = getDagValidateBeforeCall(dagId, null, null);
        Type localVarReturnType = new TypeToken<DAG>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get basic information about a DAG (asynchronously)
     * Presents only information available in database (DAGModel). If you need detailed information, consider using GET /dags/{dag_id}/details. 
     * @param dagId The DAG ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDagAsync(String dagId, final ApiCallback<DAG> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDagValidateBeforeCall(dagId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAG>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDagDetails
     * @param dagId The DAG ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDagDetailsCall(String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/details"
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
    private com.squareup.okhttp.Call getDagDetailsValidateBeforeCall(String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getDagDetails(Async)");
        }
        
        com.squareup.okhttp.Call call = getDagDetailsCall(dagId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a simplified representation of DAG
     * The response contains many DAG attributes, so the response can be large. If possible, consider using GET /dags/{dag_id}. 
     * @param dagId The DAG ID. (required)
     * @return DAGDetail
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGDetail getDagDetails(String dagId) throws ApiException {
        ApiResponse<DAGDetail> resp = getDagDetailsWithHttpInfo(dagId);
        return resp.getData();
    }

    /**
     * Get a simplified representation of DAG
     * The response contains many DAG attributes, so the response can be large. If possible, consider using GET /dags/{dag_id}. 
     * @param dagId The DAG ID. (required)
     * @return ApiResponse&lt;DAGDetail&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGDetail> getDagDetailsWithHttpInfo(String dagId) throws ApiException {
        com.squareup.okhttp.Call call = getDagDetailsValidateBeforeCall(dagId, null, null);
        Type localVarReturnType = new TypeToken<DAGDetail>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a simplified representation of DAG (asynchronously)
     * The response contains many DAG attributes, so the response can be large. If possible, consider using GET /dags/{dag_id}. 
     * @param dagId The DAG ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDagDetailsAsync(String dagId, final ApiCallback<DAGDetail> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDagDetailsValidateBeforeCall(dagId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGDetail>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDagSource
     * @param fileToken The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change.  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDagSourceCall(String fileToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dagSources/{file_token}"
            .replaceAll("\\{" + "file_token" + "\\}", apiClient.escapeString(fileToken.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "plain/text"
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
    private com.squareup.okhttp.Call getDagSourceValidateBeforeCall(String fileToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'fileToken' is set
        if (fileToken == null) {
            throw new ApiException("Missing the required parameter 'fileToken' when calling getDagSource(Async)");
        }
        
        com.squareup.okhttp.Call call = getDagSourceCall(fileToken, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a source code
     * Get a source code using file token. 
     * @param fileToken The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change.  (required)
     * @return InlineResponse2002
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2002 getDagSource(String fileToken) throws ApiException {
        ApiResponse<InlineResponse2002> resp = getDagSourceWithHttpInfo(fileToken);
        return resp.getData();
    }

    /**
     * Get a source code
     * Get a source code using file token. 
     * @param fileToken The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change.  (required)
     * @return ApiResponse&lt;InlineResponse2002&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2002> getDagSourceWithHttpInfo(String fileToken) throws ApiException {
        com.squareup.okhttp.Call call = getDagSourceValidateBeforeCall(fileToken, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2002>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a source code (asynchronously)
     * Get a source code using file token. 
     * @param fileToken The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change.  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDagSourceAsync(String fileToken, final ApiCallback<InlineResponse2002> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDagSourceValidateBeforeCall(fileToken, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2002>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDags
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param tags List of tags to filter results.  *New in version 2.2.0*  (optional)
     * @param onlyActive Only filter active DAGs.  *New in version 2.1.1*  (optional, default to true)
     * @param dagIdPattern If set, only return DAGs with dag_ids matching this pattern.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDagsCall(Integer limit, Integer offset, String orderBy, List<String> tags, Boolean onlyActive, String dagIdPattern, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (orderBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("order_by", orderBy));
        if (tags != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "tags", tags));
        if (onlyActive != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("only_active", onlyActive));
        if (dagIdPattern != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("dag_id_pattern", dagIdPattern));

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
    private com.squareup.okhttp.Call getDagsValidateBeforeCall(Integer limit, Integer offset, String orderBy, List<String> tags, Boolean onlyActive, String dagIdPattern, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getDagsCall(limit, offset, orderBy, tags, onlyActive, dagIdPattern, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List DAGs
     * List DAGs in the database. &#x60;dag_id_pattern&#x60; can be set to match dags of a specific pattern 
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param tags List of tags to filter results.  *New in version 2.2.0*  (optional)
     * @param onlyActive Only filter active DAGs.  *New in version 2.1.1*  (optional, default to true)
     * @param dagIdPattern If set, only return DAGs with dag_ids matching this pattern.  (optional)
     * @return DAGCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGCollection getDags(Integer limit, Integer offset, String orderBy, List<String> tags, Boolean onlyActive, String dagIdPattern) throws ApiException {
        ApiResponse<DAGCollection> resp = getDagsWithHttpInfo(limit, offset, orderBy, tags, onlyActive, dagIdPattern);
        return resp.getData();
    }

    /**
     * List DAGs
     * List DAGs in the database. &#x60;dag_id_pattern&#x60; can be set to match dags of a specific pattern 
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param tags List of tags to filter results.  *New in version 2.2.0*  (optional)
     * @param onlyActive Only filter active DAGs.  *New in version 2.1.1*  (optional, default to true)
     * @param dagIdPattern If set, only return DAGs with dag_ids matching this pattern.  (optional)
     * @return ApiResponse&lt;DAGCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGCollection> getDagsWithHttpInfo(Integer limit, Integer offset, String orderBy, List<String> tags, Boolean onlyActive, String dagIdPattern) throws ApiException {
        com.squareup.okhttp.Call call = getDagsValidateBeforeCall(limit, offset, orderBy, tags, onlyActive, dagIdPattern, null, null);
        Type localVarReturnType = new TypeToken<DAGCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List DAGs (asynchronously)
     * List DAGs in the database. &#x60;dag_id_pattern&#x60; can be set to match dags of a specific pattern 
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param tags List of tags to filter results.  *New in version 2.2.0*  (optional)
     * @param onlyActive Only filter active DAGs.  *New in version 2.1.1*  (optional, default to true)
     * @param dagIdPattern If set, only return DAGs with dag_ids matching this pattern.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDagsAsync(Integer limit, Integer offset, String orderBy, List<String> tags, Boolean onlyActive, String dagIdPattern, final ApiCallback<DAGCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDagsValidateBeforeCall(limit, offset, orderBy, tags, onlyActive, dagIdPattern, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTask
     * @param dagId The DAG ID. (required)
     * @param taskId The task ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTaskCall(String dagId, String taskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/tasks/{task_id}"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()))
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
    private com.squareup.okhttp.Call getTaskValidateBeforeCall(String dagId, String taskId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getTask(Async)");
        }
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling getTask(Async)");
        }
        
        com.squareup.okhttp.Call call = getTaskCall(dagId, taskId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get simplified representation of a task
     * 
     * @param dagId The DAG ID. (required)
     * @param taskId The task ID. (required)
     * @return Task
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Task getTask(String dagId, String taskId) throws ApiException {
        ApiResponse<Task> resp = getTaskWithHttpInfo(dagId, taskId);
        return resp.getData();
    }

    /**
     * Get simplified representation of a task
     * 
     * @param dagId The DAG ID. (required)
     * @param taskId The task ID. (required)
     * @return ApiResponse&lt;Task&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Task> getTaskWithHttpInfo(String dagId, String taskId) throws ApiException {
        com.squareup.okhttp.Call call = getTaskValidateBeforeCall(dagId, taskId, null, null);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get simplified representation of a task (asynchronously)
     * 
     * @param dagId The DAG ID. (required)
     * @param taskId The task ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskAsync(String dagId, String taskId, final ApiCallback<Task> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getTaskValidateBeforeCall(dagId, taskId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTasks
     * @param dagId The DAG ID. (required)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTasksCall(String dagId, String orderBy, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/tasks"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
    private com.squareup.okhttp.Call getTasksValidateBeforeCall(String dagId, String orderBy, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling getTasks(Async)");
        }
        
        com.squareup.okhttp.Call call = getTasksCall(dagId, orderBy, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get tasks for DAG
     * 
     * @param dagId The DAG ID. (required)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @return TaskCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskCollection getTasks(String dagId, String orderBy) throws ApiException {
        ApiResponse<TaskCollection> resp = getTasksWithHttpInfo(dagId, orderBy);
        return resp.getData();
    }

    /**
     * Get tasks for DAG
     * 
     * @param dagId The DAG ID. (required)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @return ApiResponse&lt;TaskCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TaskCollection> getTasksWithHttpInfo(String dagId, String orderBy) throws ApiException {
        com.squareup.okhttp.Call call = getTasksValidateBeforeCall(dagId, orderBy, null, null);
        Type localVarReturnType = new TypeToken<TaskCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get tasks for DAG (asynchronously)
     * 
     * @param dagId The DAG ID. (required)
     * @param orderBy The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTasksAsync(String dagId, String orderBy, final ApiCallback<TaskCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getTasksValidateBeforeCall(dagId, orderBy, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for patchDag
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param updateMask The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call patchDagCall(DAG body, String dagId, List<String> updateMask, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}"
            .replaceAll("\\{" + "dag_id" + "\\}", apiClient.escapeString(dagId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (updateMask != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "update_mask", updateMask));

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
    private com.squareup.okhttp.Call patchDagValidateBeforeCall(DAG body, String dagId, List<String> updateMask, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling patchDag(Async)");
        }
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling patchDag(Async)");
        }
        
        com.squareup.okhttp.Call call = patchDagCall(body, dagId, updateMask, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a DAG
     * 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param updateMask The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  (optional)
     * @return DAG
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAG patchDag(DAG body, String dagId, List<String> updateMask) throws ApiException {
        ApiResponse<DAG> resp = patchDagWithHttpInfo(body, dagId, updateMask);
        return resp.getData();
    }

    /**
     * Update a DAG
     * 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param updateMask The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  (optional)
     * @return ApiResponse&lt;DAG&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAG> patchDagWithHttpInfo(DAG body, String dagId, List<String> updateMask) throws ApiException {
        com.squareup.okhttp.Call call = patchDagValidateBeforeCall(body, dagId, updateMask, null, null);
        Type localVarReturnType = new TypeToken<DAG>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update a DAG (asynchronously)
     * 
     * @param body  (required)
     * @param dagId The DAG ID. (required)
     * @param updateMask The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call patchDagAsync(DAG body, String dagId, List<String> updateMask, final ApiCallback<DAG> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = patchDagValidateBeforeCall(body, dagId, updateMask, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAG>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for patchDags
     * @param body  (required)
     * @param dagIdPattern If set, only update DAGs with dag_ids matching this pattern.  (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param tags List of tags to filter results.  *New in version 2.2.0*  (optional)
     * @param updateMask The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  (optional)
     * @param onlyActive Only filter active DAGs.  *New in version 2.1.1*  (optional, default to true)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call patchDagsCall(DAG body, String dagIdPattern, Integer limit, Integer offset, List<String> tags, List<String> updateMask, Boolean onlyActive, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (tags != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "tags", tags));
        if (updateMask != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "update_mask", updateMask));
        if (onlyActive != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("only_active", onlyActive));
        if (dagIdPattern != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("dag_id_pattern", dagIdPattern));

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
    private com.squareup.okhttp.Call patchDagsValidateBeforeCall(DAG body, String dagIdPattern, Integer limit, Integer offset, List<String> tags, List<String> updateMask, Boolean onlyActive, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling patchDags(Async)");
        }
        // verify the required parameter 'dagIdPattern' is set
        if (dagIdPattern == null) {
            throw new ApiException("Missing the required parameter 'dagIdPattern' when calling patchDags(Async)");
        }
        
        com.squareup.okhttp.Call call = patchDagsCall(body, dagIdPattern, limit, offset, tags, updateMask, onlyActive, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update DAGs
     * Update DAGs of a given dag_id_pattern using UpdateMask. This endpoint allows specifying &#x60;~&#x60; as the dag_id_pattern to update all DAGs. *New in version 2.3.0* 
     * @param body  (required)
     * @param dagIdPattern If set, only update DAGs with dag_ids matching this pattern.  (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param tags List of tags to filter results.  *New in version 2.2.0*  (optional)
     * @param updateMask The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  (optional)
     * @param onlyActive Only filter active DAGs.  *New in version 2.1.1*  (optional, default to true)
     * @return DAGCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DAGCollection patchDags(DAG body, String dagIdPattern, Integer limit, Integer offset, List<String> tags, List<String> updateMask, Boolean onlyActive) throws ApiException {
        ApiResponse<DAGCollection> resp = patchDagsWithHttpInfo(body, dagIdPattern, limit, offset, tags, updateMask, onlyActive);
        return resp.getData();
    }

    /**
     * Update DAGs
     * Update DAGs of a given dag_id_pattern using UpdateMask. This endpoint allows specifying &#x60;~&#x60; as the dag_id_pattern to update all DAGs. *New in version 2.3.0* 
     * @param body  (required)
     * @param dagIdPattern If set, only update DAGs with dag_ids matching this pattern.  (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param tags List of tags to filter results.  *New in version 2.2.0*  (optional)
     * @param updateMask The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  (optional)
     * @param onlyActive Only filter active DAGs.  *New in version 2.1.1*  (optional, default to true)
     * @return ApiResponse&lt;DAGCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DAGCollection> patchDagsWithHttpInfo(DAG body, String dagIdPattern, Integer limit, Integer offset, List<String> tags, List<String> updateMask, Boolean onlyActive) throws ApiException {
        com.squareup.okhttp.Call call = patchDagsValidateBeforeCall(body, dagIdPattern, limit, offset, tags, updateMask, onlyActive, null, null);
        Type localVarReturnType = new TypeToken<DAGCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update DAGs (asynchronously)
     * Update DAGs of a given dag_id_pattern using UpdateMask. This endpoint allows specifying &#x60;~&#x60; as the dag_id_pattern to update all DAGs. *New in version 2.3.0* 
     * @param body  (required)
     * @param dagIdPattern If set, only update DAGs with dag_ids matching this pattern.  (required)
     * @param limit The numbers of items to return. (optional, default to 100)
     * @param offset The number of items to skip before starting to collect the result set. (optional)
     * @param tags List of tags to filter results.  *New in version 2.2.0*  (optional)
     * @param updateMask The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  (optional)
     * @param onlyActive Only filter active DAGs.  *New in version 2.1.1*  (optional, default to true)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call patchDagsAsync(DAG body, String dagIdPattern, Integer limit, Integer offset, List<String> tags, List<String> updateMask, Boolean onlyActive, final ApiCallback<DAGCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = patchDagsValidateBeforeCall(body, dagIdPattern, limit, offset, tags, updateMask, onlyActive, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DAGCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postClearTaskInstances
     * @param body Parameters of action (required)
     * @param dagId The DAG ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postClearTaskInstancesCall(ClearTaskInstances body, String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/clearTaskInstances"
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
    private com.squareup.okhttp.Call postClearTaskInstancesValidateBeforeCall(ClearTaskInstances body, String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling postClearTaskInstances(Async)");
        }
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling postClearTaskInstances(Async)");
        }
        
        com.squareup.okhttp.Call call = postClearTaskInstancesCall(body, dagId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Clear a set of task instances
     * Clears a set of task instances associated with the DAG for a specified date range. 
     * @param body Parameters of action (required)
     * @param dagId The DAG ID. (required)
     * @return TaskInstanceReferenceCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskInstanceReferenceCollection postClearTaskInstances(ClearTaskInstances body, String dagId) throws ApiException {
        ApiResponse<TaskInstanceReferenceCollection> resp = postClearTaskInstancesWithHttpInfo(body, dagId);
        return resp.getData();
    }

    /**
     * Clear a set of task instances
     * Clears a set of task instances associated with the DAG for a specified date range. 
     * @param body Parameters of action (required)
     * @param dagId The DAG ID. (required)
     * @return ApiResponse&lt;TaskInstanceReferenceCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TaskInstanceReferenceCollection> postClearTaskInstancesWithHttpInfo(ClearTaskInstances body, String dagId) throws ApiException {
        com.squareup.okhttp.Call call = postClearTaskInstancesValidateBeforeCall(body, dagId, null, null);
        Type localVarReturnType = new TypeToken<TaskInstanceReferenceCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Clear a set of task instances (asynchronously)
     * Clears a set of task instances associated with the DAG for a specified date range. 
     * @param body Parameters of action (required)
     * @param dagId The DAG ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postClearTaskInstancesAsync(ClearTaskInstances body, String dagId, final ApiCallback<TaskInstanceReferenceCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postClearTaskInstancesValidateBeforeCall(body, dagId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskInstanceReferenceCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postSetTaskInstancesState
     * @param body Parameters of action (required)
     * @param dagId The DAG ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postSetTaskInstancesStateCall(UpdateTaskInstancesState body, String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/dags/{dag_id}/updateTaskInstancesState"
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
    private com.squareup.okhttp.Call postSetTaskInstancesStateValidateBeforeCall(UpdateTaskInstancesState body, String dagId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling postSetTaskInstancesState(Async)");
        }
        // verify the required parameter 'dagId' is set
        if (dagId == null) {
            throw new ApiException("Missing the required parameter 'dagId' when calling postSetTaskInstancesState(Async)");
        }
        
        com.squareup.okhttp.Call call = postSetTaskInstancesStateCall(body, dagId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Set a state of task instances
     * Updates the state for multiple task instances simultaneously. 
     * @param body Parameters of action (required)
     * @param dagId The DAG ID. (required)
     * @return TaskInstanceReferenceCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TaskInstanceReferenceCollection postSetTaskInstancesState(UpdateTaskInstancesState body, String dagId) throws ApiException {
        ApiResponse<TaskInstanceReferenceCollection> resp = postSetTaskInstancesStateWithHttpInfo(body, dagId);
        return resp.getData();
    }

    /**
     * Set a state of task instances
     * Updates the state for multiple task instances simultaneously. 
     * @param body Parameters of action (required)
     * @param dagId The DAG ID. (required)
     * @return ApiResponse&lt;TaskInstanceReferenceCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TaskInstanceReferenceCollection> postSetTaskInstancesStateWithHttpInfo(UpdateTaskInstancesState body, String dagId) throws ApiException {
        com.squareup.okhttp.Call call = postSetTaskInstancesStateValidateBeforeCall(body, dagId, null, null);
        Type localVarReturnType = new TypeToken<TaskInstanceReferenceCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Set a state of task instances (asynchronously)
     * Updates the state for multiple task instances simultaneously. 
     * @param body Parameters of action (required)
     * @param dagId The DAG ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postSetTaskInstancesStateAsync(UpdateTaskInstancesState body, String dagId, final ApiCallback<TaskInstanceReferenceCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postSetTaskInstancesStateValidateBeforeCall(body, dagId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaskInstanceReferenceCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
