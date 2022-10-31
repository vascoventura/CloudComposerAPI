# MonitoringApi

All URIs are relative to */api/v1*

| Method                                        | HTTP request     | Description             |
|-----------------------------------------------|------------------|-------------------------|
| [**getHealth**](MonitoringApi.md#getHealth)   | **GET** /health  | Get instance status     |
| [**getVersion**](MonitoringApi.md#getVersion) | **GET** /version | Get version information |

<a name="getHealth"></a>
# **getHealth**
> HealthInfo getHealth()

Get instance status

Get the status of Airflow&#x27;s metadatabase and scheduler. It includes info about metadatabase and last heartbeat of scheduler. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MonitoringApi;


MonitoringApi apiInstance = new MonitoringApi();
try {
    HealthInfo result = apiInstance.getHealth();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MonitoringApi#getHealth");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**HealthInfo**](HealthInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getVersion"></a>
# **getVersion**
> VersionInfo getVersion()

Get version information

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MonitoringApi;


MonitoringApi apiInstance = new MonitoringApi();
try {
    VersionInfo result = apiInstance.getVersion();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MonitoringApi#getVersion");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**VersionInfo**](VersionInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

