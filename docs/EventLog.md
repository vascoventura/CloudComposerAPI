# EventLog

## Properties
| Name              | Type                                    | Description                                                                                 | Notes      |
|-------------------|-----------------------------------------|---------------------------------------------------------------------------------------------|------------|
| **eventLogId**    | **Integer**                             | The event log ID                                                                            | [optional] |
| **when**          | [**OffsetDateTime**](OffsetDateTime.md) | The time when these events happened.                                                        | [optional] |
| **dagId**         | **String**                              | The DAG ID                                                                                  | [optional] |
| **taskId**        | **String**                              | The DAG ID                                                                                  | [optional] |
| **event**         | **String**                              | A key describing the type of event.                                                         | [optional] |
| **executionDate** | [**OffsetDateTime**](OffsetDateTime.md) | When the event was dispatched for an object having execution_date, the value of this field. | [optional] |
| **owner**         | **String**                              | Name of the user who triggered these events a.                                              | [optional] |
| **extra**         | **String**                              | Other information that was not included in the other fields, e.g. the complete CLI command. | [optional] |
