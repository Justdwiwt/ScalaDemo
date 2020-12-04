package leetCode

object Solution_1546 {
  def maxNonOverlapping(nums: Array[Int], target: Int): Int = {
    var st = Set.empty[Int]
    var cur = 0
    var res = 0
    st += 0
    nums.foreach(n => {
      cur += n
      if (st.contains(cur - target)) {
        st = Set.empty[Int]
        st += 0
        cur = 0
        res += 1
      } else st += cur
    })
    res
  }
}
