package leetCode._400

object Solution_350 {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
    nums2./:((nums1.groupBy(identity).mapValues(_.length), Array.empty[Int]))((acc, e) => {
      if (acc._1.contains(e) && acc._1(e) > 0)
        (acc._1 + (e -> (acc._1(e) - 1)), acc._2 :+ e)
      else acc
    })._2
}
