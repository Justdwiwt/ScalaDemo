package leetCode._1800

import scala.collection.mutable

object Solution_1772 {
  def sortFeatures(features: Array[String], responses: Array[String]): Array[String] = {
    val st = features.toSet
    val order = features.zipWithIndex.toMap
    val freq = mutable.Map[String, Int]().withDefaultValue(0)
    responses.foreach(_.split(' ').toSet.foreach((word: String) => if (st.contains(word)) freq(word) += 1))
    features.sortBy(x => (-freq(x), order(x)))
  }
}
