package ml

import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object Driver {

  //noinspection ScalaDeprecation
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("lritem")
    val sc = new SparkContext(conf)
    val sqc = new SQLContext(sc)

    val data = sc.textFile("D://BIG//BIG_Project_Web_idea//ScalaProject//src//main//resources/lritem.txt", 2)
    val parseData = data.map { line =>
      val info = line.split("\\|")
      val Y = info(0).toDouble
      val X1 = info(1).split(" ")(0).toDouble
      val X2 = info(1).split(" ")(1).toDouble
      (X1, X2, Y)
    }

    val df = sqc.createDataFrame(parseData).toDF("X1", "X2", "Y")

    val featureColum = Array("X1", "X2")

    val ass = new VectorAssembler().setInputCols(featureColum).setOutputCol("features")

    val vectors = ass.transform(df)

    val model = new LinearRegression().setFeaturesCol("features").setLabelCol("Y").setFitIntercept(true).fit(vectors)

    println(model.coefficients) // [-6.497089660950155,0.01631790530613281]
    println(model.intercept) // 106.36879716406025

    // Y = -6.49X1 + 0.016X2 + 106.36

    println(model.summary.r2) // 0.9107147177285084

    val result = model.transform(vectors)
    result.show
    val prediction = result.select("prediction")
    prediction.show

    val testRDD = sc.makeRDD(List((10, 400, 0)))
    val testDF = sqc.createDataFrame(testRDD).toDF("X1", "X2", "Y")
    val testVector = ass.transform(testDF)
    val testResult = model.transform(testVector)
    testResult.show

    val testData2 = sc.textFile("D://BIG//BIG_Project_Web_idea//ScalaProject//src//main//resources/lritem-demo.txt", 2)
    val parseData2 = testData2.map { line =>
      val info = line.split(" ")
      val X1 = info(0).toDouble
      val X2 = info(1).toDouble
      val Y = info(2).toDouble
      (X1, X2, Y)
    }

    val testDF2 = sqc.createDataFrame(parseData2).toDF("X1", "X2", "Y")
    val testVector2 = ass.transform(testDF2)
    val testResult2 = model.transform(testVector2)
    testResult2.show

  }

}
