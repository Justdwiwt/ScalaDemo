package ml

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

object LabelDriver {

  def main(args: Array[String]): Unit = {

    val v1 = Vectors.dense(1, 2, 3)
    val l1 = LabeledPoint(5, v1)
    println(l1)
    println(l1.label)
    println(l1.features)

    val conf = new SparkConf().setMaster("local").setAppName("label")
    val sc = new SparkContext(conf)
    val data = sc.textFile("labeled.txt")

    val parseData = data.map {
      _.split(" ").map {
        _.toDouble
      }
    }.map { arr => Vectors.dense(arr) }
    parseData.foreach {
      println
    }

  }

}
