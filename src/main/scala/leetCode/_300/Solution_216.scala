package leetCode._300

import scala.collection.mutable

object Solution_216 {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    val m = mutable.Map[(Int, Int), List[List[Int]]]()
    m ++= (1 to n).map(i => ((1, i), List(List(i)))).toMap
    (2 to k).foreach(i => {
      (1 to n).foreach(j => {
        val all = (1 until j).flatMap(k => {
          m((i - 1, k)).flatMap(v => {
            if (v.last < j - k && j - k < 10) Some(v :+ (j - k)) else None
          })
        }).toList
        m += (i, j) -> all
      })
    })
    m((k, n))
  }
}
