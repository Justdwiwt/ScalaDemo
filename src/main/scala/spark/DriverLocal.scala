package spark

import org.apache.spark.{SparkConf, SparkContext}

object DriverLocal {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val data = sc.textFile("D://data/word.txt", 2)
    val result = data.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    result.foreach {
      println
    }
  }

}
