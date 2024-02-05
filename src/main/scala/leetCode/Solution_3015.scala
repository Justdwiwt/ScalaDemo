package leetCode

object Solution_3015 {
  def countOfPairs(n: Int, x: Int, y: Int): Array[Int] = {
    val w = Array.fill(n + 1, n + 1)(0)
    val INF = Int.MaxValue / 2

    (1 to n).foreach(i => (1 to n).foreach(j => w(i)(j) = if (i == j) 0 else INF))

    if (x != y) {
      w(x)(y) = 1
      w(y)(x) = 1
    }

    (1 until n).foreach(i => {
      w(i)(i + 1) = 1
      w(i + 1)(i) = 1
    })

    (1 to n).foreach(p => (1 to n).foreach(st => (1 to n).foreach(end => w(st)(end) = w(st)(end).min(w(st)(p) + w(p)(end)))))

    val t = Array.fill(n + 1)(0)
    (1 to n).foreach(i => (1 to n).foreach(j => if (w(i)(j) != INF) t(w(i)(j)) += 1))

    val res = Array.fill(n)(0)
    (0 until n).foreach(i => res(i) = t(i + 1))
    res
  }
}
