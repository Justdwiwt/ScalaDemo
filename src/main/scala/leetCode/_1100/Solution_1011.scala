package leetCode._1100

object Solution_1011 {
  def getDays(weights: Array[Int], capacity: Int, curr: Int = 0, idx: Int = 0): Int = {
    if (idx == weights.length) return if (curr > 0) 1 else 0
    val x = weights(idx)
    val remaining = capacity - curr
    if (x < remaining) getDays(weights, capacity, curr + x, idx + 1)
    else if (x > remaining) 1 + getDays(weights, capacity, x, idx + 1)
    else 1 + getDays(weights, capacity, 0, idx + 1)
  }

  @scala.annotation.tailrec
  def findCap(weights: Array[Int], capMn: Int, capMx: Int, d: Int): Int = {
    if (capMn >= capMx) return capMn
    val guessCap = (capMn + capMx) / 2
    val requiredDays = getDays(weights, guessCap)
    if (requiredDays > d) findCap(weights, guessCap + 1, capMx, d)
    else findCap(weights, capMn, guessCap, d)
  }

  def shipWithinDays(weights: Array[Int], D: Int): Int = {
    findCap(weights, weights.max, weights.sum, D)
  }
}
