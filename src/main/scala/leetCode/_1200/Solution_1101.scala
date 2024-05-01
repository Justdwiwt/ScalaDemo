package leetCode._1200

object Solution_1101 {
  def earliestAcq(logs: Array[Array[Int]], n: Int): Int = {
    val arr = Array.tabulate(n)(identity)
    val sorted = logs.sortBy(_.head)

    @scala.annotation.tailrec
    def find(x: Int, p: Array[Int]): Int =
      if (x != p(x)) find(p(x), p)
      else p(x)

    @scala.annotation.tailrec
    def f(logs: Array[Array[Int]], N: Int): Int = {
      if (logs.isEmpty) -1
      else {
        val log = logs.head
        val time = log.head
        val person1 = log(1)
        val person2 = log(2)
        val p1 = find(person1, arr)
        val p2 = find(person2, arr)
        if (p1 == p2) f(logs.tail, N)
        else {
          arr(p1) = p2
          val updatedN = N - 1
          if (updatedN == 1) time
          else f(logs.tail, updatedN)
        }
      }
    }

    f(sorted, n)
  }
}
