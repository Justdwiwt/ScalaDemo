package leetCode

object Solution_3015 {
  def countOfPairs(n: Int, x: Int, y: Int): Array[Int] = {
    val res = Array.fill(n)(0)
    (1 to n).foreach(i => (i + 1 to n).foreach(j => {
      val dist1 = j - i
      val dist2 = (i - x).abs + (j - y).abs + 1
      val dist3 = (i - y).abs + (j - x).abs + 1
      val distance = dist1.min(dist2).min(dist3)
      res(distance - 1) += 2
    }))
    res
  }
}
