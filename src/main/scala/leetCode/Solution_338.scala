package leetCode

object Solution_338 {
  def countBits(num: Int): Array[Int] = {
    val res = Array.fill(num + 1)(0)
    (1 to num).foreach(i => res(i) = res(i >> 1) + (i & 1))
    res
  }
}
