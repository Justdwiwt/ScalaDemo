package leetCode._2300

object Solution_2244 {
  def minimumRounds(tasks: Array[Int]): Int = {
    val grouped = tasks.groupBy(identity).toList

    @scala.annotation.tailrec
    def f(list: List[(Int, Array[Int])], acc: Int): Int = list match {
      case Nil => acc
      case (_, arr) :: _ if arr.length < 2 => -1
      case (_, arr) :: tail =>
        val a = arr.length / 3
        val b = arr.length % 3
        val c = if (b != 0) 1 else 0
        f(tail, acc + a + c)
    }

    f(grouped, 0)
  }
}
