package leetCode._2400

object Solution_2318 {
  private val M = 1000000007

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  private val transitions = (1 to 6)
    .flatMap(i => (1 to 6).map(j => i -> j))
    .filter { case (i, j) => i != j && gcd(i, j) == 1 }
    .groupBy(_._1)
    .map { case (k, v) => k -> v.map(_._2).toArray }

  def distinctSequences(n: Int): Int = {
    var roll: Array[(Int, Int, Long)] = (1 to 6).map((-1, _, 1L)).toArray

    var ni = 1

    while (ni < n) {
      roll = roll
        .flatMap { case (f, t, c) => transitions(t).filter(_ != f).map((t, _, c)) }
        .groupBy { case (f, t, _) => (f, t) }
        .map { case ((f, t), cs) => (f, t, cs.map(_._3).sum % M) }
        .toArray

      ni += 1
    }

    (roll.map(_._3).sum % M).toInt

  }
}
