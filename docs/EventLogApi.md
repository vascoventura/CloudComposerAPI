# EventLogApi

All URIs are relative to */api/v1*

| Method                                          | HTTP request                      | Description      |
|-------------------------------------------------|-----------------------------------|------------------|
| [**getEventLog**](EventLogApi.md#getEventLog)   | **GET** /eventLogs/{event_log_id} | Get a log entry  |
| [**getEventLogs**](EventLogApi.md#getEventLogs) | **GET** /eventLogs                | List log entries |

<a name="getEventLog"></a>
# **getEventLog**
> EventLog getEventLog(eventLogId)

Get a log entry

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EventLogApi;


EventLogApi apiInstance = new EventLogApi();
Integer eventLogId = 56; // Integer | The event log ID.
try {
    EventLog result = apiInstance.getEventLog(eventLogId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventLogApi#getEventLog");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **eventLogId** | **Integer**| The event log ID. |

### Return type

[**EventLog**](EventLog.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getEventLogs"></a>
# **getEventLogs**
> EventLogCollection getEventLogs(limit, offset, orderBy)

List log entries

List log entries from event log.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EventLogApi;


EventLogApi apiInstance = new EventLogApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    EventLogCollection result = apiInstance.getEventLogs(limit, offset, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventLogApi#getEventLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [enum: ]
 **orderBy** | **String**| The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0*  | [optional]

### Return type

[**EventLogCollection**](EventLogCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

