package streaming

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object Driver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("stream")

    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))

    val data = ssc.textFileStream("hdfs://hadoop01:9000/stream")

    data.print()
    ssc.start()
    ssc.awaitTermination()

  }

}
