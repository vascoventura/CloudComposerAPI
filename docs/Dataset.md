# Dataset

## Properties
| Name               | Type                                                                          | Description               | Notes      |
|--------------------|-------------------------------------------------------------------------------|---------------------------|------------|
| **id**             | **Integer**                                                                   | The dataset id            | [optional] |
| **uri**            | **String**                                                                    | The dataset uri           | [optional] |
| **extra**          | **Object**                                                                    | The dataset extra         | [optional] |
| **createdAt**      | **String**                                                                    | The dataset creation time | [optional] |
| **updatedAt**      | **String**                                                                    | The dataset update time   | [optional] |
| **consumingDags**  | [**List&lt;DagScheduleDatasetReference&gt;**](DagScheduleDatasetReference.md) |                           | [optional] |
| **producingTasks** | [**List&lt;TaskOutletDatasetReference&gt;**](TaskOutletDatasetReference.md)   |                           | [optional] |
