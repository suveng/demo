这是一个flink的流式处理的demo程序

source: kafka
sink: print

从kafka读取topic为`flink_kafka_source`的数据, 然后flink程序将数据打印出来

kafka的topic的数据从一个junit测试产生, 所以要先运行 WebControllerTest

然后在运行flink程序


