package leetCode

object Solution_387 {
  def firstUniqChar(s: String): Int = {
    val res: Array[Int] = new Array[Int](26)
    (0 until s.length).foreach(i => res(s(i) - 'a') += 1)
    (0 until s.length).foreach(j => if (res(s(j) - 'a') == 1) return j)
    -1
  }
}
