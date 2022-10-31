# Pool

## Properties
| Name              | Type        | Description                                                                                      | Notes      |
|-------------------|-------------|--------------------------------------------------------------------------------------------------|------------|
| **name**          | **String**  | The name of pool.                                                                                | [optional] |
| **slots**         | **Integer** | The maximum number of slots that can be assigned to tasks. One job may occupy one or more slots. | [optional] |
| **occupiedSlots** | **Integer** | The number of slots used by running/queued tasks at the moment.                                  | [optional] |
| **usedSlots**     | **Integer** | The number of slots used by running tasks at the moment.                                         | [optional] |
| **queuedSlots**   | **Integer** | The number of slots used by queued tasks at the moment.                                          | [optional] |
| **openSlots**     | **Integer** | The number of free slots at the moment.                                                          | [optional] |
| **description**   | **String**  | The description of the pool.  *New in version 2.3.0*                                             | [optional] |
