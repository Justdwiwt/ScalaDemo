package algorithm

import scala.io.Source
import scala.util.Random

//noinspection ScalaUnusedSymbol
object LocalKMeans {

  def main(args: Array[String]) {
    val fileName = "D:\\BIG\\BIG_Project_Web_idea\\ScalaProject\\src\\main\\scala\\algorithm\\kmeans_data.txt"
    val knumbers = 3
    val rand = new Random()

    //  读取文本数据
    val lines = Source.fromFile(fileName).getLines.toArray
    //noinspection RedundantCollectionConversion
    val points = lines.map(line => {
      val parts = line.split("\t").map(_.toDouble)
      new Point(parts(0), parts(1))
    }).toArray

    //  随机初始化k个质心
    val centroids = new Array[Point](knumbers)
    for (i <- 0 until knumbers) {
      centroids(i) = points(new Random().nextInt(points.length))
    }
    val startTime = System.currentTimeMillis()
    println("initialize centroids:\n" + centroids.mkString("\n") + "\n")
    println("test points: \n" + points.mkString("\n") + "\n")

    val resultCentroids = kmeans(points, centroids, 0.001)

    val endTime = System.currentTimeMillis()
    val runTime = endTime - startTime
    println("run Time: " + runTime + "\nFinal centroids: \n" + resultCentroids.mkString("\n"))
  }

  //  算法的核心函数
  def kmeans(points: Seq[Point], centroids: Seq[Point], epsilon: Double): Seq[Point] = {
    //  最近质心为key值，将数据集分簇
    val clusters = points.groupBy(closestCentroid(centroids, _))
    println("clusters: \n" + clusters.mkString("\n") + "\n")
    //  分别计算簇中数据集的平均数，得到每个簇的新质心
    val newCentroids = centroids.map(oldCentroid => {
      clusters.get(oldCentroid) match {
        case Some(pointsInCluster) => pointsInCluster.reduceLeft(_ + _) / pointsInCluster.length
        case None => oldCentroid
      }
    })
    //  计算新质心相对与旧质心的偏移量
    val movement = (centroids zip newCentroids).map({ case (a, b) => a distance b })
    println("Centroids changed by\n" + movement.map(d => "%3f".format(d)).mkString("(", ", ", ")")
      + "\nto\n" + newCentroids.mkString(", ") + "\n")
    //  根据偏移值大小决定是否继续迭代，epsilon为最小偏移值
    //noinspection RemoveRedundantReturn
    if (movement.exists(_ > epsilon))
      kmeans(points, newCentroids, epsilon)
    else
      return newCentroids
  }

  //  计算最近质心
  def closestCentroid(centroids: Seq[Point], point: Point): Point = {
    centroids.reduceLeft((a, b) => if ((point distance a) < (point distance b)) a else b)
  }

}
