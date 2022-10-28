# RoleApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteRole**](RoleApi.md#deleteRole) | **DELETE** /roles/{role_name} | Delete a role
[**getRole**](RoleApi.md#getRole) | **GET** /roles/{role_name} | Get a role
[**getRoles**](RoleApi.md#getRoles) | **GET** /roles | List roles
[**patchRole**](RoleApi.md#patchRole) | **PATCH** /roles/{role_name} | Update a role
[**postRole**](RoleApi.md#postRole) | **POST** /roles | Create a role

<a name="deleteRole"></a>
# **deleteRole**
> deleteRole(roleName)

Delete a role

Delete a role.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RoleApi;


RoleApi apiInstance = new RoleApi();
String roleName = "roleName_example"; // String | The role name
try {
    apiInstance.deleteRole(roleName);
} catch (ApiException e) {
    System.err.println("Exception when calling RoleApi#deleteRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleName** | **String**| The role name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRole"></a>
# **getRole**
> Role getRole(roleName)

Get a role

Get a role.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RoleApi;


RoleApi apiInstance = new RoleApi();
String roleName = "roleName_example"; // String | The role name
try {
    Role result = apiInstance.getRole(roleName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoleApi#getRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleName** | **String**| The role name |

### Return type

[**Role**](Role.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRoles"></a>
# **getRoles**
> RoleCollection getRoles(limit, offset, orderBy)

List roles

Get a list of roles.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RoleApi;


RoleApi apiInstance = new RoleApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    RoleCollection result = apiInstance.getRoles(limit, offset, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoleApi#getRoles");
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

[**RoleCollection**](RoleCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchRole"></a>
# **patchRole**
> Role patchRole(body, roleName, updateMask)

Update a role

Update a role.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RoleApi;


RoleApi apiInstance = new RoleApi();
Role body = new Role(); // Role | 
String roleName = "roleName_example"; // String | The role name
List<String> updateMask = Arrays.asList("updateMask_example"); // List<String> | The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields. 
try {
    Role result = apiInstance.patchRole(body, roleName, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoleApi#patchRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Role**](Role.md)|  |
 **roleName** | **String**| The role name |
 **updateMask** | [**List&lt;String&gt;**](String.md)| The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  | [optional]

### Return type

[**Role**](Role.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postRole"></a>
# **postRole**
> Role postRole(body)

Create a role

Create a new role.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RoleApi;


RoleApi apiInstance = new RoleApi();
Role body = new Role(); // Role | 
try {
    Role result = apiInstance.postRole(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoleApi#postRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Role**](Role.md)|  |

### Return type

[**Role**](Role.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

