# Task

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**classRef** | [**ClassReference**](ClassReference.md) |  |  [optional]
**taskId** | **String** |  |  [optional]
**owner** | **String** |  |  [optional]
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**endDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**triggerRule** | [**TriggerRule**](TriggerRule.md) |  |  [optional]
**extraLinks** | [**List&lt;TaskExtraLinks&gt;**](TaskExtraLinks.md) |  |  [optional]
**dependsOnPast** | **Boolean** |  |  [optional]
**isMapped** | **Boolean** |  |  [optional]
**waitForDownstream** | **Boolean** |  |  [optional]
**retries** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**queue** | **String** |  |  [optional]
**pool** | **String** |  |  [optional]
**poolSlots** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**executionTimeout** | [**TimeDelta**](TimeDelta.md) |  |  [optional]
**retryDelay** | [**TimeDelta**](TimeDelta.md) |  |  [optional]
**retryExponentialBackoff** | **Boolean** |  |  [optional]
**priorityWeight** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**weightRule** | [**WeightRule**](WeightRule.md) |  |  [optional]
**uiColor** | **String** |  |  [optional]
**uiFgcolor** | **String** |  |  [optional]
**templateFields** | **List&lt;String&gt;** |  |  [optional]
**subDag** | [**DAG**](DAG.md) |  |  [optional]
**downstreamTaskIds** | **List&lt;String&gt;** |  |  [optional]
