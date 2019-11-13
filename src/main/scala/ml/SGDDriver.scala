package ml

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}

object SGDDriver {

  //noinspection ScalaDeprecation
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("SGD")
    val sc = new SparkContext(conf)
    val data = sc.textFile("E://workspace//idea//ScalaDemo//src//main//resources/testSGD.txt")

    //--接下来要通过SparkMLlib提供的SGD(随机梯度下降法)建模
    //--要求:RDD里元素类型是LabeledPoint类型
    //--line->LabeledPoint
    val parseData = data.map { line =>
      val info = line.split(",")
      val Y = info(0).toDouble
      val X1 = info(1).split(" ")(0).toDouble
      val X2 = info(1).split(" ")(1).toDouble
      LabeledPoint(Y, Vectors.dense(X1, X2))
    }
    //--通过随机梯度下降法来建立线性回归模型
    val model = LinearRegressionWithSGD
      .train(parseData, 20, 1)
    //--Y=0.99X1+1.002X2
    println(model.weights) //获取自变量系数
    println(model.intercept) //获取截距项系数

    val result = model.predict(parseData.map(_.features))
    result.foreach {
      println
    }

  }

}
