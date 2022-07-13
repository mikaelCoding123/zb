## 参考博客https://blog.csdn.net/langeldep/article/details/83342419
##启动指定配置文件启动broker
```mqbroker.cmd -c broker.conf -n localhost:9876 autoCreateTopicEnable=true```
## broker.conf
``brokerClusterName = DefaultCluster
brokerName = broker-a
brokerId = 0
deleteWhen = 04
fileReservedTime = 48
brokerRole = ASYNC_MASTER
flushDiskType = ASYNC_FLUSH
diskMaxUsedSpaceRatio=99
storePathRootDir=d:/logs/rocketmq/data/store
storePathCommitLog=d:/logs/rocketmq/data/store/commitlog
storePathIndex=d:/logs/rocketmq/data/store/index
storePathConsumeQueue=d:/logs/rocketmq/data/store/consumequeue``