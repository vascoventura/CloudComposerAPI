# TaskInstanceApi

All URIs are relative to */api/v1*

| Method                                                                  | HTTP request                                                                               | Description                 |
|-------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|-----------------------------|
| [**getExtraLinks**](TaskInstanceApi.md#getExtraLinks)                   | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/links                  | List extra links            |
| [**getLog**](TaskInstanceApi.md#getLog)                                 | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/logs/{task_try_number} | Get logs                    |
| [**getMappedTaskInstance**](TaskInstanceApi.md#getMappedTaskInstance)   | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/{map_index}            | Get a mapped task instance  |
| [**getMappedTaskInstances**](TaskInstanceApi.md#getMappedTaskInstances) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/listMapped             | List mapped task instances  |
| [**getTaskInstance**](TaskInstanceApi.md#getTaskInstance)               | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}                        | Get a task instance         |
| [**getTaskInstances**](TaskInstanceApi.md#getTaskInstances)             | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances                                  | List task instances         |
| [**getTaskInstancesBatch**](TaskInstanceApi.md#getTaskInstancesBatch)   | **POST** /dags/~/dagRuns/~/taskInstances/list                                              | List task instances (batch) |

<a name="getExtraLinks"></a>
# **getExtraLinks**
> ExtraLinkCollection getExtraLinks(dagId, dagRunId, taskId)

List extra links

List extra links for task instance. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskInstanceApi;


TaskInstanceApi apiInstance = new TaskInstanceApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
String taskId = "taskId_example"; // String | The task ID.
try {
    ExtraLinkCollection result = apiInstance.getExtraLinks(dagId, dagRunId, taskId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskInstanceApi#getExtraLinks");
    e.printStackTrace();
}
```

### Parameters

| Name         | Type       | Description     | Notes |
|--------------|------------|-----------------|-------|
| **dagId**    | **String** | The DAG ID.     |       |
| **dagRunId** | **String** | The DAG run ID. |       |
| **taskId**   | **String** | The task ID.    |       |

### Return type

[**ExtraLinkCollection**](ExtraLinkCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLog"></a>
# **getLog**
> InlineResponse2001 getLog(dagId, dagRunId, taskId, taskTryNumber, fullContent, mapIndex, token)

Get logs

Get logs for a specific task instance and its try number.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskInstanceApi;


TaskInstanceApi apiInstance = new TaskInstanceApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
String taskId = "taskId_example"; // String | The task ID.
Integer taskTryNumber = 56; // Integer | The task try number.
Boolean fullContent = true; // Boolean | A full content will be returned. By default, only the first fragment will be returned. 
Integer mapIndex = 56; // Integer | Filter on map index for mapped task.
String token = "token_example"; // String | A token that allows you to continue fetching logs. If passed, it will specify the location from which the download should be continued. 
try {
    InlineResponse2001 result = apiInstance.getLog(dagId, dagRunId, taskId, taskTryNumber, fullContent, mapIndex, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskInstanceApi#getLog");
    e.printStackTrace();
}
```

### Parameters

| Name              | Type        | Description                                                                                                                             | Notes      |
|-------------------|-------------|-----------------------------------------------------------------------------------------------------------------------------------------|------------|
| **dagId**         | **String**  | The DAG ID.                                                                                                                             |            |
| **dagRunId**      | **String**  | The DAG run ID.                                                                                                                         |            |
| **taskId**        | **String**  | The task ID.                                                                                                                            |            |
| **taskTryNumber** | **Integer** | The task try number.                                                                                                                    |            |
| **fullContent**   | **Boolean** | A full content will be returned. By default, only the first fragment will be returned.                                                  | [optional] |
| **mapIndex**      | **Integer** | Filter on map index for mapped task.                                                                                                    | [optional] |
| **token**         | **String**  | A token that allows you to continue fetching logs. If passed, it will specify the location from which the download should be continued. | [optional] |

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getMappedTaskInstance"></a>
# **getMappedTaskInstance**
> TaskInstance getMappedTaskInstance(dagId, dagRunId, taskId, mapIndex)

Get a mapped task instance

Get details of a mapped task instance.  *New in version 2.3.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskInstanceApi;


TaskInstanceApi apiInstance = new TaskInstanceApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
String taskId = "taskId_example"; // String | The task ID.
Integer mapIndex = 56; // Integer | The map index.
try {
    TaskInstance result = apiInstance.getMappedTaskInstance(dagId, dagRunId, taskId, mapIndex);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskInstanceApi#getMappedTaskInstance");
    e.printStackTrace();
}
```

### Parameters

| Name         | Type        | Description     | Notes |
|--------------|-------------|-----------------|-------|
| **dagId**    | **String**  | The DAG ID.     |       |
| **dagRunId** | **String**  | The DAG run ID. |       |
| **taskId**   | **String**  | The task ID.    |       |
| **mapIndex** | **Integer** | The map index.  |       |

### Return type

[**TaskInstance**](TaskInstance.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMappedTaskInstances"></a>
# **getMappedTaskInstances**
> TaskInstanceCollection getMappedTaskInstances(dagId, dagRunId, taskId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, orderBy)

List mapped task instances

Get details of all mapped task instances.  *New in version 2.3.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskInstanceApi;


TaskInstanceApi apiInstance = new TaskInstanceApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
String taskId = "taskId_example"; // String | The task ID.
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
OffsetDateTime executionDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period. 
OffsetDateTime executionDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period. 
OffsetDateTime startDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
OffsetDateTime startDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
OffsetDateTime endDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
OffsetDateTime endDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
BigDecimal durationGte = new BigDecimal(); // BigDecimal | Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period. 
BigDecimal durationLte = new BigDecimal(); // BigDecimal | Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range. 
List<String> state = Arrays.asList("state_example"); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
List<String> pool = Arrays.asList("pool_example"); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
List<String> queue = Arrays.asList("queue_example"); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    TaskInstanceCollection result = apiInstance.getMappedTaskInstances(dagId, dagRunId, taskId, limit, offset, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskInstanceApi#getMappedTaskInstances");
    e.printStackTrace();
}
```

### Parameters

| Name                 | Type                                | Description                                                                                                                                            | Notes                       |
|----------------------|-------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| **dagId**            | **String**                          | The DAG ID.                                                                                                                                            |                             |
| **dagRunId**         | **String**                          | The DAG run ID.                                                                                                                                        |                             |
| **taskId**           | **String**                          | The task ID.                                                                                                                                           |                             |
| **limit**            | **Integer**                         | The numbers of items to return.                                                                                                                        | [optional] [default to 100] |
| **offset**           | **Integer**                         | The number of items to skip before starting to collect the result set.                                                                                 | [optional] [enum: ]         |
| **executionDateGte** | **OffsetDateTime**                  | Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.   | [optional]                  |
| **executionDateLte** | **OffsetDateTime**                  | Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period. | [optional]                  |
| **startDateGte**     | **OffsetDateTime**                  | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.          | [optional]                  |
| **startDateLte**     | **OffsetDateTime**                  | Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.             | [optional]                  |
| **endDateGte**       | **OffsetDateTime**                  | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.          | [optional]                  |
| **endDateLte**       | **OffsetDateTime**                  | Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.     | [optional]                  |
| **durationGte**      | **BigDecimal**                      | Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  | [optional]                  |
| **durationLte**      | **BigDecimal**                      | Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.      | [optional]                  |
| **state**            | [**List&lt;String&gt;**](String.md) | The value can be repeated to retrieve multiple matching values (OR condition).                                                                         | [optional]                  |
| **pool**             | [**List&lt;String&gt;**](String.md) | The value can be repeated to retrieve multiple matching values (OR condition).                                                                         | [optional]                  |
| **queue**            | [**List&lt;String&gt;**](String.md) | The value can be repeated to retrieve multiple matching values (OR condition).                                                                         | [optional]                  |
| **orderBy**          | **String**                          | The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*               | [optional]                  |

### Return type

[**TaskInstanceCollection**](TaskInstanceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTaskInstance"></a>
# **getTaskInstance**
> TaskInstance getTaskInstance(dagId, dagRunId, taskId)

Get a task instance

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskInstanceApi;


TaskInstanceApi apiInstance = new TaskInstanceApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
String taskId = "taskId_example"; // String | The task ID.
try {
    TaskInstance result = apiInstance.getTaskInstance(dagId, dagRunId, taskId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskInstanceApi#getTaskInstance");
    e.printStackTrace();
}
```

### Parameters

| Name         | Type       | Description     | Notes |
|--------------|------------|-----------------|-------|
| **dagId**    | **String** | The DAG ID.     |       |
| **dagRunId** | **String** | The DAG run ID. |       |
| **taskId**   | **String** | The task ID.    |       |

### Return type

[**TaskInstance**](TaskInstance.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTaskInstances"></a>
# **getTaskInstances**
> TaskInstanceCollection getTaskInstances(dagId, dagRunId, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, limit, offset)

List task instances

This endpoint allows specifying &#x60;~&#x60; as the dag_id, dag_run_id to retrieve DAG runs for all DAGs and DAG runs. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskInstanceApi;


TaskInstanceApi apiInstance = new TaskInstanceApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
OffsetDateTime executionDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period. 
OffsetDateTime executionDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period. 
OffsetDateTime startDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
OffsetDateTime startDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
OffsetDateTime endDateGte = new OffsetDateTime(); // OffsetDateTime | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
OffsetDateTime endDateLte = new OffsetDateTime(); // OffsetDateTime | Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
BigDecimal durationGte = new BigDecimal(); // BigDecimal | Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period. 
BigDecimal durationLte = new BigDecimal(); // BigDecimal | Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range. 
List<String> state = Arrays.asList("state_example"); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
List<String> pool = Arrays.asList("pool_example"); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
List<String> queue = Arrays.asList("queue_example"); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
try {
    TaskInstanceCollection result = apiInstance.getTaskInstances(dagId, dagRunId, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskInstanceApi#getTaskInstances");
    e.printStackTrace();
}
```

### Parameters

| Name                 | Type                                | Description                                                                                                                                            | Notes                       |
|----------------------|-------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| **dagId**            | **String**                          | The DAG ID.                                                                                                                                            |                             |
| **dagRunId**         | **String**                          | The DAG run ID.                                                                                                                                        |                             |
| **executionDateGte** | **OffsetDateTime**                  | Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.   | [optional]                  |
| **executionDateLte** | **OffsetDateTime**                  | Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period. | [optional]                  |
| **startDateGte**     | **OffsetDateTime**                  | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.          | [optional]                  |
| **startDateLte**     | **OffsetDateTime**                  | Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.             | [optional]                  |
| **endDateGte**       | **OffsetDateTime**                  | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.          | [optional]                  |
| **endDateLte**       | **OffsetDateTime**                  | Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.     | [optional]                  |
| **durationGte**      | **BigDecimal**                      | Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  | [optional]                  |
| **durationLte**      | **BigDecimal**                      | Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.      | [optional]                  |
| **state**            | [**List&lt;String&gt;**](String.md) | The value can be repeated to retrieve multiple matching values (OR condition).                                                                         | [optional]                  |
| **pool**             | [**List&lt;String&gt;**](String.md) | The value can be repeated to retrieve multiple matching values (OR condition).                                                                         | [optional]                  |
| **queue**            | [**List&lt;String&gt;**](String.md) | The value can be repeated to retrieve multiple matching values (OR condition).                                                                         | [optional]                  |
| **limit**            | **Integer**                         | The numbers of items to return.                                                                                                                        | [optional] [default to 100] |
| **offset**           | **Integer**                         | The number of items to skip before starting to collect the result set.                                                                                 | [optional] [enum: ]         |

### Return type

[**TaskInstanceCollection**](TaskInstanceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTaskInstancesBatch"></a>
# **getTaskInstancesBatch**
> TaskInstanceCollection getTaskInstancesBatch(body)

List task instances (batch)

List task instances from all DAGs and DAG runs. This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limits. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskInstanceApi;


TaskInstanceApi apiInstance = new TaskInstanceApi();
ListTaskInstanceForm body = new ListTaskInstanceForm(); // ListTaskInstanceForm | 
try {
    TaskInstanceCollection result = apiInstance.getTaskInstancesBatch(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskInstanceApi#getTaskInstancesBatch");
    e.printStackTrace();
}
```

### Parameters

| Name     | Type                                                | Description | Notes |
|----------|-----------------------------------------------------|-------------|-------|
| **body** | [**ListTaskInstanceForm**](ListTaskInstanceForm.md) |             |       |

### Return type

[**TaskInstanceCollection**](TaskInstanceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

