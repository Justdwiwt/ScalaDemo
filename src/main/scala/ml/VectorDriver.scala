package ml

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

object VectorDriver {

  def main(args: Array[String]): Unit = {

    val v1 = Vectors.dense(1, 2, 3.5)
    println(v1)

    val a1 = Array[Double](1, 2, 3.5)
    val v2 = Vectors.dense(a1)
    println(v2)

    val conf = new SparkConf().setMaster("local").setAppName("Vector")
    val sc = new SparkContext(conf)
    val data = sc.textFile("D://data/labeled-parse.txt")

    val parseData = data.map(_.split(" ").map(_.toDouble)).map(arr => Vectors.dense(arr))
    parseData.foreach {
      println
    }

    val v3 = Vectors.sparse(6, Array(0, 2, 5), Array[Double](2.1, 3, 5))
    println(v3(0))
    println(v3(2))
    println(v3(3))


  }

}
