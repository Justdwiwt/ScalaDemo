package leetCode._3100

object Solution_3074 {
  def minimumBoxes(apple: Array[Int], capacity: Array[Int]): Int = {
    val sorted = capacity.sorted.reverse

    @scala.annotation.tailrec
    def f(cap: Array[Int], res: Int, s: Int): Int =
      if (s <= 0) res
      else f(cap.tail, res + 1, s - cap.head)

    f(sorted, 0, apple.sum)
  }
}
