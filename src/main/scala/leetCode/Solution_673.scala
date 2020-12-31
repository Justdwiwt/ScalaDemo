package leetCode

object Solution_673 {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    val lengthMap = Map.empty[Int, List[Int]]
    val finalMap = nums.toList.zipWithIndex./:(lengthMap)((lengthMap, idx) => f(lengthMap, idx._2 + 1, idx._1))
    if (finalMap.isEmpty) 0 else finalMap(finalMap.keySet.max).size
  }

  @scala.annotation.tailrec
  def f(lengthMap: Map[Int, List[Int]], length: Int, num: Int): Map[Int, List[Int]] = {
    if (length == 0) lengthMap.updated(1, lengthMap.getOrElse(1, Nil) :+ num)
    else if (lengthMap.isDefinedAt(length)) {
      val cnt = lengthMap.getOrElse(length, Nil)./:(0)((cur, v) => if (v < num) cur + 1 else cur)
      if (cnt > 0) {
        val cur = lengthMap.getOrElse(length + 1, Nil) ::: List.fill(cnt)(num)
        lengthMap.updated(length + 1, cur)
      }
      else f(lengthMap, length - 1, num)
    } else f(lengthMap, length - 1, num)
  }
}
