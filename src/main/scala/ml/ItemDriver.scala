package ml

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.recommendation.{ALS, Rating}

/**
  * 实现基于物品的推荐
  */
object ItemDriver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("movie")
    val sc = new SparkContext(conf)

    val data = sc.textFile("../resources/u.data", 5)

    val movieData = sc.textFile("../resources/u.item", 4)

    val movieMap = movieData.map(line => {
      val info = line.split("\\|")
      val movieId = info(0).toInt
      val movieName = info(1)
      (movieId, movieName)
    }).collectAsMap

    val parseData = data.map(line => {
      val info = line.split("\t")
      val userId = info(0).toInt
      val productId = info(1).toInt
      val rating = info(2).toDouble
      Rating(userId, productId, rating)
    })
    //--当前模型没有 基于物品来推荐物品的方法，需要自己实现
    val model = ALS.train(parseData, 50, 10, 0.01)

    //--模型存储，目的是避免每次推荐时重新去训练模型
    //--模型存储完之后，用的时候再加载
    model.save(sc, "../resources")
    //--实现思路
    //--某用户看了123号电影，要求我们的模型推荐10部电影
    //--①计算123号电影和所有电影的相似度
    //--②按相似度做降序排序，取前10部
    //--核心是获取物品(电影)因子矩阵
    //--[(Int, Array[Double])]
    val product123Feature = model.productFeatures.lookup(123).head
    val cosResults = model.productFeatures map { case (id, fatcor) =>
      //--计算123号电影和当前电影的余弦距离
      val cosResult = cos(product123Feature, fatcor)
      (movieMap(id), cosResult)
    }

    val product123Top10 = cosResults.sortBy(x => -x._2).take(10)

    product123Top10.foreach {
      println
    }

  }

  def cos(a1: Array[Double], a2: Array[Double]): Double = {
    val a12 = a1 zip a2
    val a12Fenzi = a12.map(x => x._1 * x._2).sum
    val a1Fenmu = Math.sqrt(a1.map(x => x * x).sum)
    val a2Fenmu = Math.sqrt(a2.map(x => x * x).sum)
    val a12cos = a12Fenzi / (a1Fenmu * a2Fenmu)
    a12cos
  }

}
