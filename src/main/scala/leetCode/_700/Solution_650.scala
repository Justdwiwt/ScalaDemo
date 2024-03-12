package leetCode._700

object Solution_650 {
  def M[I, O](f: I => O): I => O = new collection.mutable.HashMap[I, O]() {
    self =>
    override def apply(key: I): O = self.synchronized(getOrElseUpdate(key, f(key)))
  }

  def minSteps(n: Int): Int = {
    if (n == 1) return 0
    lazy val f: ((Int, Int, Int)) => Int = M {
      case (i, _, _) if i > n => Int.MaxValue
      case (i, _, cnt) if i == n => cnt
      case (i, c, cnt) if i == c => f(i + c, c, cnt + 1)
      case (i, c, cnt) => f(i + c, c, cnt + 1).min(f(i, i, cnt + 1))
    }
    f(1, 1, 1)
  }
}
