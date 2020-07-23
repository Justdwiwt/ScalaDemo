package leetCode

object Solution_1471 {
  def getStrongest(arr: Array[Int], k: Int): Array[Int] = {
    val t = arr.sorted
    val m = t((t.length - 1) / 2)
    val sorted = t.sorted((a: Int, b: Int) => {
      val x = (a - m).abs
      val y = (b - m).abs
      if (x > y) -1
      else if (x == y && a > b) -1
      else 1
    })
    val res = Array.fill(k)(0)
    (0 until k).foreach(i => res(i) = sorted(i))
    res
  }
}
