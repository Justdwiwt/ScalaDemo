package ml

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

object StatisticDriver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("Statistic")
    val sc = new SparkContext(conf)

    val r1 = sc.makeRDD(List(1, 2, 3, 4, 5))
    val r2 = r1.map { num => Vectors.dense(num) }

    val reusult = Statistics.colStats(r2)
    println(reusult.max)
    println(reusult.min)
    println(reusult.mean)
    println(reusult.variance)
    println(reusult.numNonzeros)
    println(reusult.normL1)
    println(reusult.normL2)

  }

}
