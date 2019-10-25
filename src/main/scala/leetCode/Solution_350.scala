package leetCode

object Solution_350 {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val n1 = nums1.groupBy[Int](x => x)
    val n2 = nums2.groupBy[Int](x => x)
    val n3 = n1.keySet intersect n2.keySet
    var res = List[Int]()
    n3.foreach(i => {
      val n = n1(i).length min n2(i).length
      (1 to n).foreach(_ => res = i :: res)
    })
    res.toArray
  }
}
