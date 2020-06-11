package leetCode

object Solution_1331 {
  def arrayRankTransform(arr: Array[Int]): Array[Int] = {
    var mn = Int.MaxValue
    var mx = Int.MinValue
    arr.foreach(i => {
      if (i < mn) mn = i
      if (i > mx) mx = i
    })
    val cnt = Array.fill(mx - mn + 1)(0)
    arr.foreach(i => cnt(i - mn) = 1)
    var idx = 1
    cnt.indices.foreach(i => {
      if (cnt(i) != 0) {
        cnt(i) = idx
        idx += 1
      } else cnt(i) = 0
    })
    arr.indices.foreach(i => arr(i) = cnt(arr(i) - mn))
    arr
  }
}
