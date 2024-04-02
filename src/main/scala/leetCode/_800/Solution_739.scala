package leetCode._800

object Solution_739 {
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    @scala.annotation.tailrec
    def f(i: Int, queue: List[Int], outputs: List[Int]): List[Int] =
      if (i < 0) outputs
      else if (queue == Nil) f(i - 1, i :: queue, 0 :: outputs)
      else if (temperatures(i) < temperatures(queue.head)) f(i - 1, i :: queue, queue.head - i :: outputs)
      else f(i, queue.tail, outputs)

    f(temperatures.length - 1, Nil, Nil).toArray
  }
}
