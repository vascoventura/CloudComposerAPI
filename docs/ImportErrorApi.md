# ImportErrorApi

All URIs are relative to */api/v1*

| Method                                                   | HTTP request                            | Description         |
|----------------------------------------------------------|-----------------------------------------|---------------------|
| [**getImportError**](ImportErrorApi.md#getImportError)   | **GET** /importErrors/{import_error_id} | Get an import error |
| [**getImportErrors**](ImportErrorApi.md#getImportErrors) | **GET** /importErrors                   | List import errors  |

<a name="getImportError"></a>
# **getImportError**
> ImportError getImportError(importErrorId)

Get an import error

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImportErrorApi;


ImportErrorApi apiInstance = new ImportErrorApi();
Integer importErrorId = 56; // Integer | The import error ID.
try {
    ImportError result = apiInstance.getImportError(importErrorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImportErrorApi#getImportError");
    e.printStackTrace();
}
```

### Parameters

| Name              | Type        | Description          | Notes |
|-------------------|-------------|----------------------|-------|
| **importErrorId** | **Integer** | The import error ID. |       |

### Return type

[**ImportError**](ImportError.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getImportErrors"></a>
# **getImportErrors**
> ImportErrorCollection getImportErrors(limit, offset, orderBy)

List import errors

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImportErrorApi;


ImportErrorApi apiInstance = new ImportErrorApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    ImportErrorCollection result = apiInstance.getImportErrors(limit, offset, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImportErrorApi#getImportErrors");
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

[**ImportErrorCollection**](ImportErrorCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

