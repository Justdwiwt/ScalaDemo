package leetCode

object Solution_2948 {
  def lexicographicallySmallestArray(nums: Array[Int], limit: Int): Array[Int] = {
    val t = nums.sorted.drop(1).zip(nums.sorted).map(n => if ((n._2 - n._1).abs <= limit) 1 else 0)
    val arr = Array.fill(nums.length)(0)
    nums.indices.drop(1).foreach(i => arr(i) = if (t(i - 1) == 1) arr(i - 1) else arr(i - 1) + 1)
    val map = nums.sorted.zip(arr).toMap
    val p = nums.map(n => map.getOrElse(n, 0))
    val group2nums = nums.zip(p).groupBy(_._2).map(n => (n._1, n._2.map(n => n._1).sorted.toList))
    val group2pos = p.zipWithIndex.groupBy(_._1).map(n => (n._1, n._2.map(n => n._2).toList))
    val res = group2nums.keys.map(n => group2pos.getOrElse(n, Nil).zip(group2nums.getOrElse(n, Nil)))
    res.toList.flatten.sortBy(_._1).map(_._2).toArray
  }
}
