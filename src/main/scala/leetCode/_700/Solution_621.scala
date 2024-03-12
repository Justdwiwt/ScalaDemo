package leetCode._700

object Solution_621 {
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val seq = tasks./:(Seq.fill(26)(0)) { case (acc, ch) => acc.updated(ch - 'A', acc(ch - 'A') + 1) }
    tasks.length.max((seq.max - 1) * (n + 1) + seq.count(_ == seq.max))
  }
}
