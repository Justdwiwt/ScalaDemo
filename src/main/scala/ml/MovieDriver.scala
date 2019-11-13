package ml

import org.apache.spark.mllib.recommendation.{ALS, Rating}
import org.apache.spark.{SparkConf, SparkContext}

object MovieDriver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("movie")
    val sc = new SparkContext(conf)

    val data = sc.textFile("E://workspace//idea//ScalaDemo//src//main//resources/u.data", 5)
    //--电影文件数据
    val movieData = sc.textFile("E://workspace//idea//ScalaDemo//src//main//resources/u.item", 4)
    //--把电影文件数据封装成一个Map[movieId,movieName]
    //--collectAsMap此方法要求数据类型:(k,v)
    //--最后转成一个Map
    val movieMap = movieData.map { line =>
      val info = line.split("\\|")
      val movieId = info(0).toInt
      val movieName = info(1)
      (movieId, movieName)
    }.collectAsMap

    val parseData = data.map { line =>
      val info = line.split("\t")
      val userId = info(0).toInt
      val productId = info(1).toInt
      val rating = info(2).toDouble
      Rating(userId, productId, rating)
    }

    val model = ALS.train(parseData, 50, 10, 0.01)
    //--为789号用户推荐10部电影
    val user789 = model.recommendProducts(789, 10)

    val parseUser789 = user789.map { x =>
      val userId = x.user
      val productId = x.product
      val rating = x.rating
      (userId, movieMap(productId), rating)
    }

    //--接下来做模型验证
    //--首先获取到789号用户最喜爱的10部电影
    //--然后和推荐的10部电影做比对，看是否有相似的题材电影

    //--获取到789号用户所有打分的电影
    val u789AllMovies = parseData.keyBy(x => x.user).lookup(789)

    //--获取789号用户最喜爱的前10部电影
    val u789Top10 = u789AllMovies.sortBy(x => -x.rating).take(10).map(x => {
      val userId = x.user
      val productId = x.product
      val rating = x.rating
      (userId, movieMap(productId), rating)
    })

    u789Top10.foreach {
      println
    }

    println("------------------")
    parseUser789.foreach {
      println
    }

  }

}
