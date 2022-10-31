# DagApi

All URIs are relative to */api/v1*

| Method                                                               | HTTP request                                     | Description                             |
|----------------------------------------------------------------------|--------------------------------------------------|-----------------------------------------|
| [**deleteDag**](DagApi.md#deleteDag)                                 | **DELETE** /dags/{dag_id}                        | Delete a DAG                            |
| [**getDag**](DagApi.md#getDag)                                       | **GET** /dags/{dag_id}                           | Get basic information about a DAG       |
| [**getDagDetails**](DagApi.md#getDagDetails)                         | **GET** /dags/{dag_id}/details                   | Get a simplified representation of DAG  |
| [**getDagSource**](DagApi.md#getDagSource)                           | **GET** /dagSources/{file_token}                 | Get a source code                       |
| [**getDags**](DagApi.md#getDags)                                     | **GET** /dags                                    | List DAGs                               |
| [**getTask**](DagApi.md#getTask)                                     | **GET** /dags/{dag_id}/tasks/{task_id}           | Get simplified representation of a task |
| [**getTasks**](DagApi.md#getTasks)                                   | **GET** /dags/{dag_id}/tasks                     | Get tasks for DAG                       |
| [**patchDag**](DagApi.md#patchDag)                                   | **PATCH** /dags/{dag_id}                         | Update a DAG                            |
| [**patchDags**](DagApi.md#patchDags)                                 | **PATCH** /dags                                  | Update DAGs                             |
| [**postClearTaskInstances**](DagApi.md#postClearTaskInstances)       | **POST** /dags/{dag_id}/clearTaskInstances       | Clear a set of task instances           |
| [**postSetTaskInstancesState**](DagApi.md#postSetTaskInstancesState) | **POST** /dags/{dag_id}/updateTaskInstancesState | Set a state of task instances           |

<a name="deleteDag"></a>
# **deleteDag**
> deleteDag(dagId)

Delete a DAG

Deletes all metadata related to the DAG, including finished DAG Runs and Tasks. Logs are not deleted. This action cannot be undone.  *New in version 2.2.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
String dagId = "dagId_example"; // String | The DAG ID.
try {
    apiInstance.deleteDag(dagId);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#deleteDag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDag"></a>
# **getDag**
> DAG getDag(dagId)

Get basic information about a DAG

Presents only information available in database (DAGModel). If you need detailed information, consider using GET /dags/{dag_id}/details. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
String dagId = "dagId_example"; // String | The DAG ID.
try {
    DAG result = apiInstance.getDag(dagId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#getDag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |

### Return type

[**DAG**](DAG.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDagDetails"></a>
# **getDagDetails**
> DAGDetail getDagDetails(dagId)

Get a simplified representation of DAG

The response contains many DAG attributes, so the response can be large. If possible, consider using GET /dags/{dag_id}. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
String dagId = "dagId_example"; // String | The DAG ID.
try {
    DAGDetail result = apiInstance.getDagDetails(dagId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#getDagDetails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |

### Return type

[**DAGDetail**](DAGDetail.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDagSource"></a>
# **getDagSource**
> InlineResponse2002 getDagSource(fileToken)

Get a source code

Get a source code using file token. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
String fileToken = "fileToken_example"; // String | The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change. 
try {
    InlineResponse2002 result = apiInstance.getDagSource(fileToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#getDagSource");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileToken** | **String**| The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change.  |

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, plain/text

<a name="getDags"></a>
# **getDags**
> DAGCollection getDags(limit, offset, orderBy, tags, onlyActive, dagIdPattern)

List DAGs

List DAGs in the database. &#x60;dag_id_pattern&#x60; can be set to match dags of a specific pattern 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
List<String> tags = Arrays.asList("tags_example"); // List<String> | List of tags to filter results.  *New in version 2.2.0* 
Boolean onlyActive = true; // Boolean | Only filter active DAGs.  *New in version 2.1.1* 
String dagIdPattern = "dagIdPattern_example"; // String | If set, only return DAGs with dag_ids matching this pattern. 
try {
    DAGCollection result = apiInstance.getDags(limit, offset, orderBy, tags, onlyActive, dagIdPattern);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#getDags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [enum: ]
 **orderBy** | **String**| The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| List of tags to filter results.  *New in version 2.2.0*  | [optional]
 **onlyActive** | **Boolean**| Only filter active DAGs.  *New in version 2.1.1*  | [optional] [default to true]
 **dagIdPattern** | **String**| If set, only return DAGs with dag_ids matching this pattern.  | [optional]

### Return type

[**DAGCollection**](DAGCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTask"></a>
# **getTask**
> Task getTask(dagId, taskId)

Get simplified representation of a task

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
String dagId = "dagId_example"; // String | The DAG ID.
String taskId = "taskId_example"; // String | The task ID.
try {
    Task result = apiInstance.getTask(dagId, taskId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#getTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **taskId** | **String**| The task ID. |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTasks"></a>
# **getTasks**
> TaskCollection getTasks(dagId, orderBy)

Get tasks for DAG

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
String dagId = "dagId_example"; // String | The DAG ID.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    TaskCollection result = apiInstance.getTasks(dagId, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#getTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **orderBy** | **String**| The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  | [optional]

### Return type

[**TaskCollection**](TaskCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchDag"></a>
# **patchDag**
> DAG patchDag(body, dagId, updateMask)

Update a DAG

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
DAG body = new DAG(); // DAG | 
String dagId = "dagId_example"; // String | The DAG ID.
List<String> updateMask = Arrays.asList("updateMask_example"); // List<String> | The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields. 
try {
    DAG result = apiInstance.patchDag(body, dagId, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#patchDag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DAG**](DAG.md)|  |
 **dagId** | **String**| The DAG ID. |
 **updateMask** | [**List&lt;String&gt;**](String.md)| The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  | [optional]

### Return type

[**DAG**](DAG.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="patchDags"></a>
# **patchDags**
> DAGCollection patchDags(body, dagIdPattern, limit, offset, tags, updateMask, onlyActive)

Update DAGs

Update DAGs of a given dag_id_pattern using UpdateMask. This endpoint allows specifying &#x60;~&#x60; as the dag_id_pattern to update all DAGs. *New in version 2.3.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
DAG body = new DAG(); // DAG | 
String dagIdPattern = "dagIdPattern_example"; // String | If set, only update DAGs with dag_ids matching this pattern. 
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
List<String> tags = Arrays.asList("tags_example"); // List<String> | List of tags to filter results.  *New in version 2.2.0* 
List<String> updateMask = Arrays.asList("updateMask_example"); // List<String> | The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields. 
Boolean onlyActive = true; // Boolean | Only filter active DAGs.  *New in version 2.1.1* 
try {
    DAGCollection result = apiInstance.patchDags(body, dagIdPattern, limit, offset, tags, updateMask, onlyActive);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#patchDags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DAG**](DAG.md)|  |
 **dagIdPattern** | **String**| If set, only update DAGs with dag_ids matching this pattern.  |
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [enum: ]
 **tags** | [**List&lt;String&gt;**](String.md)| List of tags to filter results.  *New in version 2.2.0*  | [optional]
 **updateMask** | [**List&lt;String&gt;**](String.md)| The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  | [optional]
 **onlyActive** | **Boolean**| Only filter active DAGs.  *New in version 2.1.1*  | [optional] [default to true]

### Return type

[**DAGCollection**](DAGCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postClearTaskInstances"></a>
# **postClearTaskInstances**
> TaskInstanceReferenceCollection postClearTaskInstances(body, dagId)

Clear a set of task instances

Clears a set of task instances associated with the DAG for a specified date range. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
ClearTaskInstances body = new ClearTaskInstances(); // ClearTaskInstances | Parameters of action
String dagId = "dagId_example"; // String | The DAG ID.
try {
    TaskInstanceReferenceCollection result = apiInstance.postClearTaskInstances(body, dagId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#postClearTaskInstances");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ClearTaskInstances**](ClearTaskInstances.md)| Parameters of action |
 **dagId** | **String**| The DAG ID. |

### Return type

[**TaskInstanceReferenceCollection**](TaskInstanceReferenceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postSetTaskInstancesState"></a>
# **postSetTaskInstancesState**
> TaskInstanceReferenceCollection postSetTaskInstancesState(body, dagId)

Set a state of task instances

Updates the state for multiple task instances simultaneously. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagApi;


DagApi apiInstance = new DagApi();
UpdateTaskInstancesState body = new UpdateTaskInstancesState(); // UpdateTaskInstancesState | Parameters of action
String dagId = "dagId_example"; // String | The DAG ID.
try {
    TaskInstanceReferenceCollection result = apiInstance.postSetTaskInstancesState(body, dagId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagApi#postSetTaskInstancesState");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UpdateTaskInstancesState**](UpdateTaskInstancesState.md)| Parameters of action |
 **dagId** | **String**| The DAG ID. |

### Return type

[**TaskInstanceReferenceCollection**](TaskInstanceReferenceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

