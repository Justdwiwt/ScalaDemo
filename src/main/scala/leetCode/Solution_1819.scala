package leetCode

object Solution_1819 {
  def countDifferentSubsequenceGCDs(nums: Array[Int]): Int = {
    val vis = Array.fill(200005)(false)
    nums.foreach(vis(_) = true)
    var res = 0
    (1 to 200000).foreach(i => {
      var fst = -1
      (i to 200000 by i).foreach(j => {
        if (vis(j))
          if (fst == -1) fst = j
          else fst = gcd(fst, j)
      })
      if (fst == i) res += 1
    })
    res
  }

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
