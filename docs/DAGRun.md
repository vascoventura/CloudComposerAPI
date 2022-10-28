# DAGRun

## Properties
| Name                       | Type                                    | Description                                                                                                                                                                                                                                                                                                                                                                                      | Notes      |
|----------------------------|-----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------|
| **dagRunId**               | **String**                              | Run ID.  The value of this field can be set only when creating the object. If you try to modify the field of an existing object, the request fails with an BAD_REQUEST error.  If not provided, a value will be generated based on execution_date.  If the specified dag_run_id is in use, the creation request fails with an ALREADY_EXISTS error.  This together with DAG_ID are a unique key. | [optional] |
| **dagId**                  | **String**                              |                                                                                                                                                                                                                                                                                                                                                                                                  | [optional] |
| **logicalDate**            | [**OffsetDateTime**](OffsetDateTime.md) | The logical date (previously called execution date). This is the time or interval covered by this DAG run, according to the DAG definition.  The value of this field can be set only when creating the object. If you try to modify the field of an existing object, the request fails with an BAD_REQUEST error.  This together with DAG_ID are a unique key.  *New in version 2.2.0*           | [optional] |
| **executionDate**          | [**OffsetDateTime**](OffsetDateTime.md) | The execution date. This is the same as logical_date, kept for backwards compatibility. If both this field and logical_date are provided but with different values, the request will fail with an BAD_REQUEST error.  *Changed in version 2.2.0*&amp;#58; Field becomes nullable.  *Deprecated since version 2.2.0*&amp;#58; Use &#x27;logical_date&#x27; instead.                               | [optional] |
| **startDate**              | [**OffsetDateTime**](OffsetDateTime.md) | The start time. The time when DAG run was actually created.  *Changed in version 2.1.3*&amp;#58; Field becomes nullable.                                                                                                                                                                                                                                                                         | [optional] |
| **endDate**                | [**OffsetDateTime**](OffsetDateTime.md) |                                                                                                                                                                                                                                                                                                                                                                                                  | [optional] |
| **dataIntervalStart**      | [**OffsetDateTime**](OffsetDateTime.md) |                                                                                                                                                                                                                                                                                                                                                                                                  | [optional] |
| **dataIntervalEnd**        | [**OffsetDateTime**](OffsetDateTime.md) |                                                                                                                                                                                                                                                                                                                                                                                                  | [optional] |
| **lastSchedulingDecision** | [**OffsetDateTime**](OffsetDateTime.md) |                                                                                                                                                                                                                                                                                                                                                                                                  | [optional] |
| **runType**                | [**RunTypeEnum**](#RunTypeEnum)         |                                                                                                                                                                                                                                                                                                                                                                                                  | [optional] |
| **state**                  | [**DagState**](DagState.md)             |                                                                                                                                                                                                                                                                                                                                                                                                  | [optional] |
| **externalTrigger**        | **Boolean**                             |                                                                                                                                                                                                                                                                                                                                                                                                  | [optional] |
| **conf**                   | **Object**                              | JSON object describing additional configuration parameters.  The value of this field can be set only when creating the object. If you try to modify the field of an existing object, the request fails with an BAD_REQUEST error.                                                                                                                                                                | [optional] |

<a name="RunTypeEnum"></a>
## Enum: RunTypeEnum
| Name              | Value                         |
|-------------------|-------------------------------|
| BACKFILL          | &quot;backfill&quot;          |
| MANUAL            | &quot;manual&quot;            |
| SCHEDULED         | &quot;scheduled&quot;         |
| DATASET_TRIGGERED | &quot;dataset_triggered&quot; |