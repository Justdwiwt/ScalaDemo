package leetCode

object Solution_509 {
  def fib(N: Int): Int = {
    var curr = 0
    var next = 1
    var n = N
    while (n > 0) {
      next = next + curr
      curr = next - curr
      n -= 1
    }
    curr
  }
}
