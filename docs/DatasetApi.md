# DatasetApi

All URIs are relative to */api/v1*

| Method                                                                 | HTTP request                                                      | Description                      |
|------------------------------------------------------------------------|-------------------------------------------------------------------|----------------------------------|
| [**getDataset**](DatasetApi.md#getDataset)                             | **GET** /datasets/{uri}                                           | Get a dataset                    |
| [**getDatasetEvents**](DatasetApi.md#getDatasetEvents)                 | **GET** /datasets/events                                          | Get dataset events               |
| [**getDatasets**](DatasetApi.md#getDatasets)                           | **GET** /datasets                                                 | List datasets                    |
| [**getUpstreamDatasetEvents**](DatasetApi.md#getUpstreamDatasetEvents) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/upstreamDatasetEvents | Get dataset events for a DAG run |

<a name="getDataset"></a>
# **getDataset**
> Dataset getDataset(uri)

Get a dataset

Get a dataset by uri.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DatasetApi;


DatasetApi apiInstance = new DatasetApi();
String uri = "uri_example"; // String | The encoded Dataset URI
try {
    Dataset result = apiInstance.getDataset(uri);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DatasetApi#getDataset");
    e.printStackTrace();
}
```

### Parameters

| Name    | Type       | Description             | Notes |
|---------|------------|-------------------------|-------|
| **uri** | **String** | The encoded Dataset URI |       |

### Return type

[**Dataset**](Dataset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDatasetEvents"></a>
# **getDatasetEvents**
> DatasetEventCollection getDatasetEvents(limit, offset, orderBy, datasetId, sourceDagId, sourceTaskId, sourceRunId, sourceMapIndex)

Get dataset events

Get dataset events

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DatasetApi;


DatasetApi apiInstance = new DatasetApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
Integer datasetId = 56; // Integer | The Dataset ID that updated the dataset.
String sourceDagId = "sourceDagId_example"; // String | The DAG ID that updated the dataset.
String sourceTaskId = "sourceTaskId_example"; // String | The task ID that updated the dataset.
String sourceRunId = "sourceRunId_example"; // String | The DAG run ID that updated the dataset.
Integer sourceMapIndex = 56; // Integer | The map index that updated the dataset.
try {
    DatasetEventCollection result = apiInstance.getDatasetEvents(limit, offset, orderBy, datasetId, sourceDagId, sourceTaskId, sourceRunId, sourceMapIndex);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DatasetApi#getDatasetEvents");
    e.printStackTrace();
}
```

### Parameters

| Name               | Type        | Description                                                                                                                              | Notes                       |
|--------------------|-------------|------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| **limit**          | **Integer** | The numbers of items to return.                                                                                                          | [optional] [default to 100] |
| **offset**         | **Integer** | The number of items to skip before starting to collect the result set.                                                                   | [optional] [enum: ]         |
| **orderBy**        | **String**  | The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0* | [optional]                  |
| **datasetId**      | **Integer** | The Dataset ID that updated the dataset.                                                                                                 | [optional]                  |
| **sourceDagId**    | **String**  | The DAG ID that updated the dataset.                                                                                                     | [optional]                  |
| **sourceTaskId**   | **String**  | The task ID that updated the dataset.                                                                                                    | [optional]                  |
| **sourceRunId**    | **String**  | The DAG run ID that updated the dataset.                                                                                                 | [optional]                  |
| **sourceMapIndex** | **Integer** | The map index that updated the dataset.                                                                                                  | [optional]                  |

### Return type

[**DatasetEventCollection**](DatasetEventCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDatasets"></a>
# **getDatasets**
> DatasetCollection getDatasets(limit, offset, orderBy, uriPattern)

List datasets

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DatasetApi;


DatasetApi apiInstance = new DatasetApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
String uriPattern = "uriPattern_example"; // String | If set, only return datasets with uris matching this pattern. 
try {
    DatasetCollection result = apiInstance.getDatasets(limit, offset, orderBy, uriPattern);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DatasetApi#getDatasets");
    e.printStackTrace();
}
```

### Parameters

| Name           | Type        | Description                                                                                                                              | Notes                       |
|----------------|-------------|------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| **limit**      | **Integer** | The numbers of items to return.                                                                                                          | [optional] [default to 100] |
| **offset**     | **Integer** | The number of items to skip before starting to collect the result set.                                                                   | [optional] [enum: ]         |
| **orderBy**    | **String**  | The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0* | [optional]                  |
| **uriPattern** | **String**  | If set, only return datasets with uris matching this pattern.                                                                            | [optional]                  |

### Return type

[**DatasetCollection**](DatasetCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
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
//import io.swagger.client.api.DatasetApi;


DatasetApi apiInstance = new DatasetApi();
String dagId = "dagId_example"; // String | The DAG ID.
String dagRunId = "dagRunId_example"; // String | The DAG run ID.
try {
    DatasetEventCollection result = apiInstance.getUpstreamDatasetEvents(dagId, dagRunId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DatasetApi#getUpstreamDatasetEvents");
    e.printStackTrace();
}
```

### Parameters

| Name         | Type       | Description     | Notes |
|--------------|------------|-----------------|-------|
| **dagId**    | **String** | The DAG ID.     |       |
| **dagRunId** | **String** | The DAG run ID. |       |

### Return type

[**DatasetEventCollection**](DatasetEventCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

