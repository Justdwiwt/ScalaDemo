package leetCode

object Solution_2873 {
  def maximumTripletValue(nums: Array[Int]): Long =
    nums./:(0L, 0, 0) { case ((res, i, j), cur) =>
      (res.max(1L * i * cur), i.max(j - cur), j.max(cur))
    }._1
}
