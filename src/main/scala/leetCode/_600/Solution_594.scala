package leetCode._600

object Solution_594 {
  def findLHS(nums: Array[Int]): Int = {
    var res = 0
    val m = nums.groupBy(i => i).mapValues(_.length)
    m.foreach(x => if (m.isDefinedAt(x._1 + 1) && x._2 + m(x._1 + 1) > res) res = x._2 + m(x._1 + 1))
    res
  }
}
