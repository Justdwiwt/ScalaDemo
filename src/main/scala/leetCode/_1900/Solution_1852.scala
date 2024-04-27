package leetCode._1900

object Solution_1852 {
  def distinctNumbers(nums: Array[Int], k: Int): Array[Int] = {
    val m = nums.take(k).groupBy(identity).mapValues(_.length)
    val res = (k until nums.length).foldLeft((m, collection.mutable.ArrayBuffer(m.size))) { case ((map, acc), i) =>
      val f = nums(i - k)
      val l = nums(i)
      val updatedMap = if (map(f) == 1) map - f else map.updated(f, map(f) - 1)
      (updatedMap + (l -> (updatedMap.getOrElse(l, 0) + 1)), acc += (updatedMap + (l -> (updatedMap.getOrElse(l, 0) + 1))).size)
    }._2.toArray
    res
  }
}
