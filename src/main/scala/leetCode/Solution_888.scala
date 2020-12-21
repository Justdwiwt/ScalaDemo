package leetCode

object Solution_888 {
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    val delta = A.sum - B.sum
    val st = B.toSet
    A.foreach(x => if (st.contains(x - delta / 2)) return Array(x, x - delta / 2))
    Array.empty
  }
}
