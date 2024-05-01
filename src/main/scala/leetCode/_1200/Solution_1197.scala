package leetCode._1200

object Solution_1197 {
  def minKnightMoves(x: Int, y: Int): Int = {
    var res = Int.MaxValue
    var arr = Array(Array(2, -1), Array(2, 1), Array(1, 2), Array(-1, 2))

    (0 until 4).foreach(_ => {
      (-3 to 3).foreach(i => (-3 to 3).foreach(j => {
        val x2 = arr(0)(0) * i + arr(1)(0) * j + x
        val y2 = arr(0)(1) * i + arr(1)(1) * j + y

        val a = arr(3)(1) * x2 - arr(3)(0) * y2
        val b = -arr(2)(1) * x2 + arr(2)(0) * y2
        val det = arr(2)(0) * arr(3)(1) - arr(2)(1) * arr(3)(0)

        if (a % det == 0 && b % det == 0) res = res.min(i.abs + j.abs + (a / det).abs + (b / det).abs)
      }))
      arr :+= arr.head
      arr = arr.tail
    })

    res
  }
}
