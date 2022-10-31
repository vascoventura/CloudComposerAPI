# DagRunApi

All URIs are relative to */api/v1*

| Method                                                                | HTTP request                                                      | Description                      |
|-----------------------------------------------------------------------|-------------------------------------------------------------------|----------------------------------|
| [**clearDagRun**](DagRunApi.md#clearDagRun)                           | **POST** /dags/{dag_id}/dagRuns/{dag_run_id}/clear                | Clear a DAG run                  |
| [**deleteDagRun**](DagRunApi.md#deleteDagRun)                         | **DELETE** /dags/{dag_id}/dagRuns/{dag_run_id}                    | Delete a DAG run                 |
| [**getDagRun**](DagRunApi.md#getDagRun)                               | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}                       | Get a DAG run                    |
| [**getDagRuns**](DagRunApi.md#getDagRuns)                             | **GET** /dags/{dag_id}/dagRuns                                    | List DAG runs                    |
| [**getDagRunsBatch**](DagRunApi.md#getDagRunsBatch)                   | **POST** /dags/~/dagRuns/list                                     | List DAG runs (batch)            |
| [**getUpstreamDatasetEvents**](DagRunApi.md#getUpstreamDatasetEvents) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/upstreamDatasetEvents | Get dataset events for a DAG run |
| [**postDagRun**](DagRunApi.md#postDagRun)                             | **POST** /dags/{dag_id}/dagRuns                                   | Trigger a new DAG run            |
| [**updateDagRunState**](DagRunApi.md#updateDagRunState)               | **PATCH** /dags/{dag_id}/dagRuns/{dag_run_id}                     | Modify a DAG run                 |

<a name="clearDagRun"></a>
# **clearDagRun**
> DAGRun clearDagRun(body, dagId, dagRunId)

Clear a DAG run

Clear a DAG run.  *New in version 2.4.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagRunApi;


DagRunApi apiInstance = new DagRunApi();
ClearDagRun body = new ClearDagRun(); // ClearDagRun | 
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
try {
    DAGRun result = apiInstance.clearDagRun(body, dagId, dagRunId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagRunApi#clearDagRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ClearDagRun**](ClearDagRun.md)|  |
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |

### Return type

[**DAGRun**](DAGRun.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteDagRun"></a>
# **deleteDagRun**
> deleteDagRun(dagId, dagRunId)

Delete a DAG run

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagRunApi;


DagRunApi apiInstance = new DagRunApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
try {
    apiInstance.deleteDagRun(dagId, dagRunId);
} catch (ApiException e) {
    System.err.println("Exception when calling DagRunApi#deleteDagRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDagRun"></a>
# **getDagRun**
> DAGRun getDagRun(dagId, dagRunId)

Get a DAG run

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagRunApi;


DagRunApi apiInstance = new DagRunApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
try {
    DAGRun result = apiInstance.getDagRun(dagId, dagRunId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagRunApi#getDagRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |

### Return type

[**DAGRun**](DAGRun.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDagRuns"></a>
# **getDagRuns**
> DAGRunCollection getDagRuns(dagId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, state, orderBy)

List DAG runs

This endpoint allows specifying &#x60;~&#x60; as the dag_id to retrieve DAG runs for all DAGs. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagRunApi;


DagRunApi apiInstance = new DagRunApi();
String dagId = "dagId_example"; // String | The DAG ID.
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
OffsetDateTime executionDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period. 
OffsetDateTime executionDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period. 
OffsetDateTime startDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
OffsetDateTime startDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
OffsetDateTime endDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
OffsetDateTime endDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
List<String> state = Arrays.asList("state_example"); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    DAGRunCollection result = apiInstance.getDagRuns(dagId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, state, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagRunApi#getDagRuns");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [enum: ]
 **executionDateGte** | **OffsetDateTime**| Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  | [optional]
 **executionDateLte** | **OffsetDateTime**| Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  | [optional]
 **startDateGte** | **OffsetDateTime**| Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  | [optional]
 **startDateLte** | **OffsetDateTime**| Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  | [optional]
 **endDateGte** | **OffsetDateTime**| Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  | [optional]
 **endDateLte** | **OffsetDateTime**| Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  | [optional]
 **state** | [**List&lt;String&gt;**](String.md)| The value can be repeated to retrieve multiple matching values (OR condition). | [optional]
 **orderBy** | **String**| The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  | [optional]

### Return type

[**DAGRunCollection**](DAGRunCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDagRunsBatch"></a>
# **getDagRunsBatch**
> DAGRunCollection getDagRunsBatch(body)

List DAG runs (batch)

This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limit. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagRunApi;


DagRunApi apiInstance = new DagRunApi();
ListDagRunsForm body = new ListDagRunsForm(); // ListDagRunsForm | 
try {
    DAGRunCollection result = apiInstance.getDagRunsBatch(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagRunApi#getDagRunsBatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ListDagRunsForm**](ListDagRunsForm.md)|  |

### Return type

[**DAGRunCollection**](DAGRunCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUpstreamDatasetEvents"></a>
# **getUpstreamDatasetEvents**
> DatasetEventCollection getUpstreamDatasetEvents(dagId, dagRunId)

Get dataset events for a DAG run

Get datasets for a dag run.  *New in version 2.4.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagRunApi;


DagRunApi apiInstance = new DagRunApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
try {
    DatasetEventCollection result = apiInstance.getUpstreamDatasetEvents(dagId, dagRunId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagRunApi#getUpstreamDatasetEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |

### Return type

[**DatasetEventCollection**](DatasetEventCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postDagRun"></a>
# **postDagRun**
> DAGRun postDagRun(body, dagId)

Trigger a new DAG run

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagRunApi;


DagRunApi apiInstance = new DagRunApi();
DAGRun body = new DAGRun(); // DAGRun | 
String dagId = "dagId_example"; // String | The DAG ID.
try {
    DAGRun result = apiInstance.postDagRun(body, dagId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagRunApi#postDagRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DAGRun**](DAGRun.md)|  |
 **dagId** | **String**| The DAG ID. |

### Return type

[**DAGRun**](DAGRun.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateDagRunState"></a>
# **updateDagRunState**
> DAGRun updateDagRunState(body, dagId, dagRunId)

Modify a DAG run

Modify a DAG run.  *New in version 2.2.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DagRunApi;


DagRunApi apiInstance = new DagRunApi();
UpdateDagRunState body = new UpdateDagRunState(); // UpdateDagRunState | 
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
try {
    DAGRun result = apiInstance.updateDagRunState(body, dagId, dagRunId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DagRunApi#updateDagRunState");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UpdateDagRunState**](UpdateDagRunState.md)|  |
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |

### Return type

[**DAGRun**](DAGRun.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

