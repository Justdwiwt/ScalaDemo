package spark

import org.apache.spark.{SparkConf, SparkContext}

object Driver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setMaster("spark://hadoop01:7077")
      .setAppName("wordcount")
    val sc = new SparkContext(conf)
    val data = sc.textFile("hdfs://hadoop01:9000/word.txt", 3)
    val result = data.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    result.saveAsTextFile("hdfs://hadoop01:9000/r2")
  }

}
