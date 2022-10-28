# ConnectionApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteConnection**](ConnectionApi.md#deleteConnection) | **DELETE** /connections/{connection_id} | Delete a connection
[**getConnection**](ConnectionApi.md#getConnection) | **GET** /connections/{connection_id} | Get a connection
[**getConnections**](ConnectionApi.md#getConnections) | **GET** /connections | List connections
[**patchConnection**](ConnectionApi.md#patchConnection) | **PATCH** /connections/{connection_id} | Update a connection
[**postConnection**](ConnectionApi.md#postConnection) | **POST** /connections | Create a connection
[**testConnection**](ConnectionApi.md#testConnection) | **POST** /connections/test | Test a connection

<a name="deleteConnection"></a>
# **deleteConnection**
> deleteConnection(connectionId)

Delete a connection

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConnectionApi;


ConnectionApi apiInstance = new ConnectionApi();
String connectionId = "connectionId_example"; // String | The connection ID.
try {
    apiInstance.deleteConnection(connectionId);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectionApi#deleteConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectionId** | **String**| The connection ID. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getConnection"></a>
# **getConnection**
> Connection getConnection(connectionId)

Get a connection

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConnectionApi;


ConnectionApi apiInstance = new ConnectionApi();
String connectionId = "connectionId_example"; // String | The connection ID.
try {
    Connection result = apiInstance.getConnection(connectionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectionApi#getConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **connectionId** | **String**| The connection ID. |

### Return type

[**Connection**](Connection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getConnections"></a>
# **getConnections**
> ConnectionCollection getConnections(limit, offset, orderBy)

List connections

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConnectionApi;


ConnectionApi apiInstance = new ConnectionApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    ConnectionCollection result = apiInstance.getConnections(limit, offset, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectionApi#getConnections");
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

[**ConnectionCollection**](ConnectionCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchConnection"></a>
# **patchConnection**
> Connection patchConnection(body, connectionId, updateMask)

Update a connection

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConnectionApi;


ConnectionApi apiInstance = new ConnectionApi();
Connection body = new Connection(); // Connection | 
String connectionId = "connectionId_example"; // String | The connection ID.
List<String> updateMask = Arrays.asList("updateMask_example"); // List<String> | The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields. 
try {
    Connection result = apiInstance.patchConnection(body, connectionId, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectionApi#patchConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Connection**](Connection.md)|  |
 **connectionId** | **String**| The connection ID. |
 **updateMask** | [**List&lt;String&gt;**](String.md)| The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  | [optional]

### Return type

[**Connection**](Connection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postConnection"></a>
# **postConnection**
> Connection postConnection(body)

Create a connection

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConnectionApi;


ConnectionApi apiInstance = new ConnectionApi();
Connection body = new Connection(); // Connection | 
try {
    Connection result = apiInstance.postConnection(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectionApi#postConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Connection**](Connection.md)|  |

### Return type

[**Connection**](Connection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="testConnection"></a>
# **testConnection**
> ConnectionTest testConnection(body)

Test a connection

Test a connection.  *New in version 2.2.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConnectionApi;


ConnectionApi apiInstance = new ConnectionApi();
Connection body = new Connection(); // Connection | 
try {
    ConnectionTest result = apiInstance.testConnection(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectionApi#testConnection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Connection**](Connection.md)|  |

### Return type

[**ConnectionTest**](ConnectionTest.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

