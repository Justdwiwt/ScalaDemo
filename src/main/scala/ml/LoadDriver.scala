package ml

import org.apache.spark.mllib.recommendation.MatrixFactorizationModel
import org.apache.spark.{SparkConf, SparkContext}

object LoadDriver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("load")
    val sc = new SparkContext(conf)

    val model = MatrixFactorizationModel.load(sc, "../resources")
    val result = model.recommendProducts(789, 10)
    result.foreach {
      println
    }

  }

}
