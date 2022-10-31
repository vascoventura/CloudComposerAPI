# VariableApi

All URIs are relative to */api/v1*

| Method                                              | HTTP request                         | Description       |
|-----------------------------------------------------|--------------------------------------|-------------------|
| [**deleteVariable**](VariableApi.md#deleteVariable) | **DELETE** /variables/{variable_key} | Delete a variable |
| [**getVariable**](VariableApi.md#getVariable)       | **GET** /variables/{variable_key}    | Get a variable    |
| [**getVariables**](VariableApi.md#getVariables)     | **GET** /variables                   | List variables    |
| [**patchVariable**](VariableApi.md#patchVariable)   | **PATCH** /variables/{variable_key}  | Update a variable |
| [**postVariables**](VariableApi.md#postVariables)   | **POST** /variables                  | Create a variable |

<a name="deleteVariable"></a>
# **deleteVariable**
> deleteVariable(variableKey)

Delete a variable

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VariableApi;


VariableApi apiInstance = new VariableApi();
String variableKey = "variableKey_example"; // String | The variable Key.
try {
    apiInstance.deleteVariable(variableKey);
} catch (ApiException e) {
    System.err.println("Exception when calling VariableApi#deleteVariable");
    e.printStackTrace();
}
```

### Parameters

| Name            | Type       | Description       | Notes |
|-----------------|------------|-------------------|-------|
| **variableKey** | **String** | The variable Key. |       |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getVariable"></a>
# **getVariable**
> Variable getVariable(variableKey)

Get a variable

Get a variable by key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VariableApi;


VariableApi apiInstance = new VariableApi();
String variableKey = "variableKey_example"; // String | The variable Key.
try {
    Variable result = apiInstance.getVariable(variableKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariableApi#getVariable");
    e.printStackTrace();
}
```

### Parameters

| Name            | Type       | Description       | Notes |
|-----------------|------------|-------------------|-------|
| **variableKey** | **String** | The variable Key. |       |

### Return type

[**Variable**](Variable.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getVariables"></a>
# **getVariables**
> VariableCollection getVariables(limit, offset, orderBy)

List variables

The collection does not contain data. To get data, you must get a single entity.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VariableApi;


VariableApi apiInstance = new VariableApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    VariableCollection result = apiInstance.getVariables(limit, offset, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariableApi#getVariables");
    e.printStackTrace();
}
```

### Parameters

| Name        | Type        | Description                                                                                                                              | Notes                       |
|-------------|-------------|------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
| **limit**   | **Integer** | The numbers of items to return.                                                                                                          | [optional] [default to 100] |
| **offset**  | **Integer** | The number of items to skip before starting to collect the result set.                                                                   | [optional] [enum: ]         |
| **orderBy** | **String**  | The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  *New in version 2.1.0* | [optional]                  |

### Return type

[**VariableCollection**](VariableCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchVariable"></a>
# **patchVariable**
> Variable patchVariable(body, variableKey, updateMask)

Update a variable

Update a variable by key.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VariableApi;


VariableApi apiInstance = new VariableApi();
Variable body = new Variable(); // Variable | 
String variableKey = "variableKey_example"; // String | The variable Key.
List<String> updateMask = Arrays.asList("updateMask_example"); // List<String> | The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields. 
try {
    Variable result = apiInstance.patchVariable(body, variableKey, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariableApi#patchVariable");
    e.printStackTrace();
}
```

### Parameters

| Name            | Type                                | Description                                                                                                                                             | Notes      |
|-----------------|-------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|------------|
| **body**        | [**Variable**](Variable.md)         |                                                                                                                                                         |            |
| **variableKey** | **String**                          | The variable Key.                                                                                                                                       |            |
| **updateMask**  | [**List&lt;String&gt;**](String.md) | The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields. | [optional] |

### Return type

[**Variable**](Variable.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postVariables"></a>
# **postVariables**
> Variable postVariables(body)

Create a variable

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VariableApi;


VariableApi apiInstance = new VariableApi();
Variable body = new Variable(); // Variable | 
try {
    Variable result = apiInstance.postVariables(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VariableApi#postVariables");
    e.printStackTrace();
}
```

### Parameters

| Name     | Type                        | Description | Notes |
|----------|-----------------------------|-------------|-------|
| **body** | [**Variable**](Variable.md) |             |       |

### Return type

[**Variable**](Variable.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

