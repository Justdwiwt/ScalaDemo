package ml

import org.apache.spark.mllib.classification.{LogisticRegressionWithLBFGS, LogisticRegressionWithSGD}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

object LogisticDriver {

  //noinspection ScalaDeprecation
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("logistic")

    val sc = new SparkContext(conf)

    val data = sc.textFile("../resources/logistic.txt")

    //--line->Array[String]-Array[Double]->LabeledPoint
    val pareseData = data.map(_.split("\t").map(_.toDouble)).map(arr => LabeledPoint(arr.last, Vectors.dense(arr.take(3))))

    val splits = pareseData.randomSplit(Array(0.7, 0.3), seed = 12)
    //--取出70%的数据用于训练模型
    val trainData = splits(0)
    //--取出30%的数据用于测试
    val testData = splits(1)
    //--建立逻辑回归模型，底层使用SGD来训练模型参数
    val model = LogisticRegressionWithSGD.train(trainData, 50)

    println(model.weights)
    println(model.intercept)

    //--代入测试集，进行分类
    val testResult = model.predict(testData.map(label => label.features))

    testResult.foreach {
      println
    }

    //--用牛顿法来训练模型
    //--牛顿法也是迭代算法，通过数值解取逼近真实解
    //--优势在于比随机梯度下降法迭代速度更快
    //--劣势在于会耗费更多的计算性能
    val model2 = new LogisticRegressionWithLBFGS().setNumClasses(2).run(trainData)
    val testResult2 = model2.predict(testData.map(label => label.features))

    testResult2.foreach {
      println
    }

  }

}
