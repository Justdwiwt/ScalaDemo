package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_17_05 {
  def findLongestSubarray(array: Array[String]): Array[String] = {
    var start = 0
    var end = 0
    val m = mutable.HashMap.empty[Int, Int]
    var pre = 0
    m += (0 -> -1)
    array.indices.foreach(i => {
      pre += (if (Character.isDigit(array(i).head)) 1 else -1)
      if (!m.contains(pre)) m += pre -> i
      else {
        val idx = m(pre)
        if (i - idx > end - start) {
          start = idx
          end = i
        }
      }
    })
    java.util.Arrays.copyOfRange(array, start + 1, end + 1)
  }
}
