# ConfigApi

All URIs are relative to */api/v1*

| Method                                  | HTTP request    | Description               |
|-----------------------------------------|-----------------|---------------------------|
| [**getConfig**](ConfigApi.md#getConfig) | **GET** /config | Get current configuration |

<a name="getConfig"></a>
# **getConfig**
> Config getConfig()

Get current configuration

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConfigApi;


ConfigApi apiInstance = new ConfigApi();
try {
    Config result = apiInstance.getConfig();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigApi#getConfig");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Config**](Config.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

