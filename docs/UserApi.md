# UserApi

All URIs are relative to */api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteUser**](UserApi.md#deleteUser) | **DELETE** /users/{username} | Delete a user
[**getUser**](UserApi.md#getUser) | **GET** /users/{username} | Get a user
[**getUsers**](UserApi.md#getUsers) | **GET** /users | List users
[**patchUser**](UserApi.md#patchUser) | **PATCH** /users/{username} | Update a user
[**postUser**](UserApi.md#postUser) | **POST** /users | Create a user

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(username)

Delete a user

Delete a user with a specific username.  *New in version 2.2.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String username = "username_example"; // String | The username of the user.  *New in version 2.1.0* 
try {
    apiInstance.deleteUser(username);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The username of the user.  *New in version 2.1.0*  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUser"></a>
# **getUser**
> UserCollectionItem getUser(username)

Get a user

Get a user with a specific username.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String username = "username_example"; // String | The username of the user.  *New in version 2.1.0* 
try {
    UserCollectionItem result = apiInstance.getUser(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The username of the user.  *New in version 2.1.0*  |

### Return type

[**UserCollectionItem**](UserCollectionItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsers"></a>
# **getUsers**
> UserCollection getUsers(limit, offset, orderBy)

List users

Get a list of users.  *New in version 2.1.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
Integer limit = 100; // Integer | The numbers of items to return.
Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
String orderBy = "orderBy_example"; // String | The name of the field to order the results by. Prefix a field name with `-` to reverse the sort order.  *New in version 2.1.0* 
try {
    UserCollection result = apiInstance.getUsers(limit, offset, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getUsers");
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

[**UserCollection**](UserCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchUser"></a>
# **patchUser**
> Role patchUser(body, username, updateMask)

Update a user

Update fields for a user.  *New in version 2.2.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
User body = new User(); // User | 
String username = "username_example"; // String | The username of the user.  *New in version 2.1.0* 
List<String> updateMask = Arrays.asList("updateMask_example"); // List<String> | The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields. 
try {
    Role result = apiInstance.patchUser(body, username, updateMask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#patchUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**User**](User.md)|  |
 **username** | **String**| The username of the user.  *New in version 2.1.0*  |
 **updateMask** | [**List&lt;String&gt;**](String.md)| The fields to update on the resource. If absent or empty, all modifiable fields are updated. A comma-separated list of fully qualified names of fields.  | [optional]

### Return type

[**Role**](Role.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postUser"></a>
# **postUser**
> User postUser(body)

Create a user

Create a new user with unique username and email.  *New in version 2.2.0* 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
User body = new User(); // User | 
try {
    User result = apiInstance.postUser(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#postUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**User**](User.md)|  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

