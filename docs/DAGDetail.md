# DAGDetail

## Properties
| Name                          | Type                                    | Description                                                                             | Notes      |
|-------------------------------|-----------------------------------------|-----------------------------------------------------------------------------------------|------------|
| **timezone**                  | **String**                              |                                                                                         | [optional] |
| **catchup**                   | **Boolean**                             |                                                                                         | [optional] |
| **orientation**               | **String**                              |                                                                                         | [optional] |
| **concurrency**               | [**BigDecimal**](BigDecimal.md)         |                                                                                         | [optional] |
| **startDate**                 | [**OffsetDateTime**](OffsetDateTime.md) | The DAG&#x27;s start date.  *Changed in version 2.0.1*&amp;#58; Field becomes nullable. | [optional] |
| **dagRunTimeout**             | [**TimeDelta**](TimeDelta.md)           |                                                                                         | [optional] |
| **docMd**                     | **String**                              |                                                                                         | [optional] |
| **defaultView**               | **String**                              |                                                                                         | [optional] |
| **params**                    | **Object**                              | User-specified DAG params.  *New in version 2.0.1*                                      | [optional] |
| **endDate**                   | [**OffsetDateTime**](OffsetDateTime.md) | The DAG&#x27;s end date.  *New in version 2.3.0*.                                       | [optional] |
| **isPausedUponCreation**      | **Boolean**                             | Whether the DAG is paused upon creation.  *New in version 2.3.0*                        | [optional] |
| **lastParsed**                | [**OffsetDateTime**](OffsetDateTime.md) | The last time the DAG was parsed.  *New in version 2.3.0*                               | [optional] |
| **templateSearchPath**        | **List&lt;String&gt;**                  | The template search path.  *New in version 2.3.0*                                       | [optional] |
| **renderTemplateAsNativeObj** | **Boolean**                             | Whether to render templates as native Python objects.  *New in version 2.3.0*           | [optional] |
