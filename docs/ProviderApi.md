# ProviderApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProviders**](ProviderApi.md#getProviders) | **GET** /providers | List providers

<a name="getProviders"></a>
# **getProviders**
> InlineResponse200 getProviders()

List providers

Get a list of providers.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProviderApi;


ProviderApi apiInstance = new ProviderApi();
try {
    InlineResponse200 result = apiInstance.getProviders();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProviderApi#getProviders");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

