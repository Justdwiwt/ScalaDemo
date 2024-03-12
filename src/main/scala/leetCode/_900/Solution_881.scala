package leetCode._900

object Solution_881 {
  def numRescueBoats(people: Array[Int], limit: Int): Int = f(people.sorted, limit, 0, people.length - 1, 0)

  @scala.annotation.tailrec
  def f(p: Array[Int], l: Int, i: Int, j: Int, r: Int): Int = {
    if (i == j) r + 1
    else if (i > j) r
    else if (p(i) + p(j) > l) f(p, l, i, j - 1, r + 1)
    else f(p, l, i + 1, j - 1, r + 1)
  }
}
