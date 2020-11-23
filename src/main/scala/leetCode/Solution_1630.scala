package leetCode

object Solution_1630 {
  def checkArithmeticSubarrays(nums: Array[Int], l: Array[Int], r: Array[Int]): List[Boolean] = {
    l.zip(r)./:(List.empty[Boolean]) { (res, t) => isArithmetic(nums.slice(t._1, t._2 + 1)) :: res }.reverse
  }

  def isArithmetic(arr: Array[Int]): Boolean = {
    val mn = arr.min
    val mx = arr.max
    if (mn == mx) true
    else if ((mx - mn) % (arr.length - 1) != 0) false
    else (mn to mx by ((mx - mn) / (arr.length - 1))).forall(e => arr.contains(e))
  }
}
