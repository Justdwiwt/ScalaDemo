package leetCode

object Solution_3017 {
  def countOfPairs(n: Int, _x: Int, _y: Int): Array[Long] = {
    var x = _x
    var y = _y
    if (_x > _y) {
      val t = _x
      x = _y
      y = t
    }
    val res = Array.fill(n)(0L)
    (1 to n).foreach(i => {
      res(0) += 2
      res((i - 1).min((i - y).abs + x)) -= 1
      res((n - i).min((i - x).abs + 1 + n - y)) -= 1
      res((i - x).abs.min((y - i).abs + 1)) += 1
      res(((i - x).abs + 1).min((y - i).abs)) += 1
      val r = 0.max(x - i) + 0.max(i - y)
      res(r + (y - x + 0) / 2) -= 1
      res(r + (y - x + 1) / 2) -= 1
    })
    (1 until n).foreach(i => res(i) += res(i - 1))
    res
  }
}
