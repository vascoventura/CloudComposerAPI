# UserCollectionItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**firstName** | **String** | The user&#x27;s first name.  *Changed in version 2.4.0*&amp;#58; The requirement for this to be non-empty was removed.  |  [optional]
**lastName** | **String** | The user&#x27;s last name.  *Changed in version 2.4.0*&amp;#58; The requirement for this to be non-empty was removed.  |  [optional]
**username** | **String** | The username.  *Changed in version 2.2.0*&amp;#58; A minimum character length requirement (&#x27;minLength&#x27;) is added.  |  [optional]
**email** | **String** | The user&#x27;s email.  *Changed in version 2.2.0*&amp;#58; A minimum character length requirement (&#x27;minLength&#x27;) is added.  |  [optional]
**active** | **Boolean** | Whether the user is active |  [optional]
**lastLogin** | **String** | The last user login |  [optional]
**loginCount** | **Integer** | The login count |  [optional]
**failedLoginCount** | **Integer** | The number of times the login failed |  [optional]
**roles** | [**List&lt;UserCollectionItemRoles&gt;**](UserCollectionItemRoles.md) | User roles.  *Changed in version 2.2.0*&amp;#58; Field is no longer read-only.  |  [optional]
**createdOn** | **String** | The date user was created |  [optional]
**changedOn** | **String** | The date user was changed |  [optional]
