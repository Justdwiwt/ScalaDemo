package ml

import org.apache.spark.mllib.recommendation.{ALS, Rating}
import org.apache.spark.{SparkConf, SparkContext}

object RecDriver {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("rec")
    val sc = new SparkContext(conf)

    val data = sc.textFile("../resources/als.txt", 2)

    //--接下来要建立推荐系统模型
    //--line->Rating(userId(int),productId(int),score(double))
    val parseData = data.map { line =>
      val info = line.split(" ")
      val userId = info(0).toInt
      val productId = info(1).toInt
      val rating = info(2).toDouble
      //--mllib.recommendation
      Rating(userId, productId, rating)
    }

    //--①参:数据集 ②参:隐藏因子数,生产环境下50~200
    //--③参:ALS算法最大的迭代次数
    //--④参:λ 正则化参数，防止模型过拟合
    val model = ALS.train(parseData, 3, 10, 0.01)

    //--下面表示为用户4推荐两件商品
    val u4Result = model.recommendProducts(4, 2)
    u4Result.foreach {
      println
    }

    //--下面表示为13号商品推荐两个用户
    val i13Result = model.recommendUsers(13, 2)
    i13Result.foreach {
      println
    }

  }

}
