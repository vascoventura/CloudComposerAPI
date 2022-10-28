# PermissionApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPermissions**](PermissionApi.md#getPermissions) | **GET** /permissions | List permissions

<a name="getPermissions"></a>
# **getPermissions**
> ActionCollection getPermissions(limit, offset)

List permissions

Get a list of permissions.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PermissionApi;


PermissionApi apiInstance = new PermissionApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
try {
    ActionCollection result = apiInstance.getPermissions(limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PermissionApi#getPermissions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [enum: ]

### Return type

[**ActionCollection**](ActionCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

