package leetCode._100

object Solution_70 {
  val fib: Stream[Int] = 0 #:: 1 #:: fib.zip(fib.tail).map({ case (a, b) => a + b })

  def climbStairs(n: Int): Int = fib(n + 1)
}
