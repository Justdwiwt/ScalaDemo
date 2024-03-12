package leetCode._700

object Solution_688 {

  class Lazy[T](expr: => T) {
    lazy val V: T = expr

    def apply(): T = V
  }

  object Lazy {
    def apply[T](expr: => T) = new Lazy(expr)
  }

  def knightProbability(N: Int, K: Int, r: Int, c: Int): Double = {
    val f = (x: Int, y: Int) => x < 0 || y < 0 || x >= N || y >= N

    def g(x: Int, y: Int, k: Int): Lazy[Double] = Lazy {
      if (k == 0) if (x == r && y == c) 1 else 0
      else ((if (f(x + 1, y + 2)) 0 else arr(x + 1)(y + 2)(k - 1)()) +
        (if (f(x + 2, y + 1)) 0 else arr(x + 2)(y + 1)(k - 1)()) +
        (if (f(x + 1, y - 2)) 0 else arr(x + 1)(y - 2)(k - 1)()) +
        (if (f(x + 2, y - 1)) 0 else arr(x + 2)(y - 1)(k - 1)()) +
        (if (f(x - 1, y + 2)) 0 else arr(x - 1)(y + 2)(k - 1)()) +
        (if (f(x - 2, y + 1)) 0 else arr(x - 2)(y + 1)(k - 1)()) +
        (if (f(x - 1, y - 2)) 0 else arr(x - 1)(y - 2)(k - 1)()) +
        (if (f(x - 2, y - 1)) 0 else arr(x - 2)(y - 1)(k - 1)())) / 8
    }

    lazy val arr = Array.tabulate[Lazy[Double]](N, N, K)(g)
    (0 until N).flatMap(x => (0 until N).map(y => g(x, y, K)())).sum
  }

}
