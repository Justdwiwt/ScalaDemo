package leetCode._4000

object Solution_3912 {
  def findValidElements(nums: Array[Int]): List[Int] =
    (nums.indices.foldLeft(Array.empty[(Int, Int)])((res, i) =>
      if (res.isEmpty || nums(i) > res.last._1) res :+ (nums(i), i) else res).map(_._2) ++
      nums.indices.foldRight(Array.empty[(Int, Int)])((i, res) =>
        if (res.isEmpty || nums(i) > res.last._1) res :+ (nums(i), i) else res).map(_._2)).toSet.toList.sorted.map(nums)
}
