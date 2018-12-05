package spark

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile(args(0))
    val wordCount = rdd.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)
    val wordSort = wordCount.map(x => (x._2, x._1)).sortByKey(ascending = false).map(x => (x._2, x._1))
    wordSort.saveAsTextFile(args(1))
    sc.stop()
  }

}
