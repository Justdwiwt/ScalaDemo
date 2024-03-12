package leetCode._800

object Solution_795 {
  def numSubarrayBoundedMax(A: Array[Int], L: Int, R: Int): Int = func(A, R) - func(A, L - 1)

  def func(A: Array[Int], bound: Int): Int = {
    var res = 0
    var cur = 0
    A.foreach(i => {
      cur = if (i <= bound) cur + 1 else 0
      res += cur
    })
    res
  }
}
