# PluginApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPlugins**](PluginApi.md#getPlugins) | **GET** /plugins | Get a list of loaded plugins

<a name="getPlugins"></a>
# **getPlugins**
> PluginCollection getPlugins(limit, offset)

Get a list of loaded plugins

Get a list of loaded plugins.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
try {
    PluginCollection result = apiInstance.getPlugins(limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#getPlugins");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [enum: ]

### Return type

[**PluginCollection**](PluginCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

