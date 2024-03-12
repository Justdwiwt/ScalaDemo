package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_16_24 {
  def pairSums(nums: Array[Int], target: Int): List[List[Int]] = {
    val m = mutable.HashMap(nums.groupBy(i => i).mapValues(_.length).toSeq: _*)
    val res = mutable.ArrayBuffer.empty[List[Int]]
    m.keys.foreach(i => if (m.contains(i) && m.contains(target - i)) {
      if (i == target - i) {
        res ++= List.fill(m(i) / 2)(List(i, i))
        m.remove(i)
      } else {
        res ++= List.fill(m(i).min(m(target - i)))(List(i, target - i))
        m.remove(i)
        m.remove(target - i)
      }
    })
    res.toList
  }
}
