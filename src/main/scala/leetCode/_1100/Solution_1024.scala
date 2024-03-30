package leetCode._1100

object Solution_1024 {
  def videoStitching(clips: Array[Array[Int]], time: Int): Int = {
    lazy val sorted = clips.sortWith { case (a, b) =>
      a.head < b.head || (a.head == b.head && a.last > b.last)
    }.toIndexedSeq

    @scala.annotation.tailrec
    def f(seq: Seq[Array[Int]], last: Array[Int], count: Int): Int = {
      lazy val (take, drop) = seq.span(_.head <= last.last)
      if (last.last >= time) count
      else if (seq.isEmpty || take.isEmpty) -1
      else f(drop, take.maxBy(_.last), count + 1)
    }

    if (sorted.head.head > 0) -1
    else f(sorted.tail, sorted.head, 1)
  }
}
