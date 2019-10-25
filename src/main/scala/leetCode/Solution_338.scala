package leetCode

object Solution_338 {
  def countBits(num: Int): Array[Int] = {
    val res = new Array[Int](num + 1)
    res.foreach(i => res(i) = 0)
    (1 to num).foreach(i => res(i) = res(i >> 1) + (i & 1))
    res
  }
}
