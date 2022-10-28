# XComApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getXcomEntries**](XComApi.md#getXcomEntries) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/xcomEntries | List XCom entries
[**getXcomEntry**](XComApi.md#getXcomEntry) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/xcomEntries/{xcom_key} | Get an XCom entry

<a name="getXcomEntries"></a>
# **getXcomEntries**
> XComCollection getXcomEntries(dagId, dagRunId, taskId, limit, offset)

List XCom entries

This endpoint allows specifying &#x60;~&#x60; as the dag_id, dag_run_id, task_id to retrieve XCOM entries for for all DAGs, DAG runs and task instances. XCom values won&#x27;t be returned as they can be large. Use this endpoint to get a list of XCom entries and then fetch individual entry to get value.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.XComApi;


XComApi apiInstance = new XComApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
String taskId = "taskId_example"; // String | The task ID.
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
try {
    XComCollection result = apiInstance.getXcomEntries(dagId, dagRunId, taskId, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling XComApi#getXcomEntries");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |
 **taskId** | **String**| The task ID. |
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [enum: ]

### Return type

[**XComCollection**](XComCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getXcomEntry"></a>
# **getXcomEntry**
> XCom getXcomEntry(dagId, dagRunId, taskId, xcomKey, deserialize)

Get an XCom entry

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.XComApi;


XComApi apiInstance = new XComApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
String taskId = "taskId_example"; // String | The task ID.
String xcomKey = "xcomKey_example"; // String | The XCom key.
Boolean deserialize = false; // Boolean | Whether to deserialize an XCom value when using a custom XCom backend.  The XCom API endpoint calls `orm_deserialize_value` by default since an XCom may contain value that is potentially expensive to deserialize in the web server. Setting this to true overrides the consideration, and calls `deserialize_value` instead.  This parameter is not meaningful when using the default XCom backend.  *New in version 2.4.0* 
try {
    XCom result = apiInstance.getXcomEntry(dagId, dagRunId, taskId, xcomKey, deserialize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling XComApi#getXcomEntry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |
 **taskId** | **String**| The task ID. |
 **xcomKey** | **String**| The XCom key. |
 **deserialize** | **Boolean**| Whether to deserialize an XCom value when using a custom XCom backend.  The XCom API endpoint calls &#x60;orm_deserialize_value&#x60; by default since an XCom may contain value that is potentially expensive to deserialize in the web server. Setting this to true overrides the consideration, and calls &#x60;deserialize_value&#x60; instead.  This parameter is not meaningful when using the default XCom backend.  *New in version 2.4.0*  | [optional] [default to false]

### Return type

[**XCom**](XCom.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

