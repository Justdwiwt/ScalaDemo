package leetCode

object Solution_1291 {
  def sequentialDigits(low: Int, high: Int): List[Int] = {
    var res = List.empty[Int]
    (1 to 9).foreach(i => {
      var t = i
      (i + 1 to 9).foreach(j => {
        t = t * 10 + j
        if (t >= low && t <= high) res :+= t
      })
    })
    res.sorted
  }
}
