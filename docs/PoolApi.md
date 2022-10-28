# PoolApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletePool**](PoolApi.md#deletePool) | **DELETE** /pools/{pool_name} | Delete a pool
[**getPool**](PoolApi.md#getPool) | **GET** /pools/{pool_name} | Get a pool
[**getPools**](PoolApi.md#getPools) | **GET** /pools | List pools
[**patchPool**](PoolApi.md#patchPool) | **PATCH** /pools/{pool_name} | Update a pool
[**postPool**](PoolApi.md#postPool) | **POST** /pools | Create a pool

<a name="deletePool"></a>
# **deletePool**
> deletePool(poolName)

Delete a pool

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PoolApi;


PoolApi apiInstance = new PoolApi();
String poolName = "poolName_example"; // String | The pool name.
try {
    apiInstance.deletePool(poolName);
} catch (ApiException e) {
    System.err.println("Exception when calling PoolApi#deletePool");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolName** | **String**| The pool name. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPool"></a>
# **getPool**
> Pool getPool(poolName)

Get a pool

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PoolApi;


PoolApi apiInstance = new PoolApi();
String poolName = "poolName_example"; // String | The pool name.
try {
    Pool result = apiInstance.getPool(poolName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PoolApi#getPool");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolName** | **String**| The pool name. |

### Return type

[**Pool**](Pool.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPools"></a>
# **getPools**
> PoolCollection getPools(limit, offset, orderBy)

List pools

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PoolApi;


PoolApi apiInstance = new PoolApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    PoolCollection result = apiInstance.getPools(limit, offset, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PoolApi#getPools");
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

[**PoolCollection**](PoolCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchPool"></a>
# **patchPool**
> Pool patchPool(body, poolName, updateMask)

Update a pool

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PoolApi;


PoolApi apiInstance = new PoolApi();
Pool body = new Pool(); // Pool | 
String poolName = "poolName_example"; // String | The pool name.
List<String> updateMask = Arrays.asList("updateMask_example"); // List<String> | The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields. 
try {
    Pool result = apiInstance.patchPool(body, poolName, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PoolApi#patchPool");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Pool**](Pool.md)|  |
 **poolName** | **String**| The pool name. |
 **updateMask** | [**List&lt;String&gt;**](String.md)| The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  | [optional]

### Return type

[**Pool**](Pool.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postPool"></a>
# **postPool**
> Pool postPool(body)

Create a pool

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PoolApi;


PoolApi apiInstance = new PoolApi();
Pool body = new Pool(); // Pool | 
try {
    Pool result = apiInstance.postPool(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PoolApi#postPool");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Pool**](Pool.md)|  |

### Return type

[**Pool**](Pool.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

