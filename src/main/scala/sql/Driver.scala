package sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object Driver {

  //noinspection ScalaDeprecation
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("sql")

    val sc = new SparkContext(conf)

    val sqc = new SQLContext(sc)

    val r1 = sc.makeRDD(List((1, "111"), (2, "222"), (3, "333")))
    sqc.createDataFrame(r1).toDF("id", "name")

  }

}
