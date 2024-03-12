package leetCode._2100

object Solution_2009 {
  def minOperations(nums: Array[Int]): Int = {
    val sorted = nums.distinct.sorted
    sorted.indices./:(nums.length, 0) { case ((mn, end), start) =>
      val newEnd = (end until sorted.length).find(i => sorted(i) >= sorted(start) + nums.length).getOrElse(sorted.length)
      val need = nums.length - (newEnd - start)
      (mn.min(need), newEnd)
    }._1
  }
}
