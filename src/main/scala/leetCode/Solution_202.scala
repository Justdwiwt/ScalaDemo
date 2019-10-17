package leetCode

object Solution_202 {
  def isHappy(n: Int): Boolean = {
    var slow = n
    var fast = process(n)
    while (slow != fast) {
      slow = process(slow)
      fast = process(fast)
      fast = process(fast)
    }
    slow == 1
  }

  def process(n: Int): Int = {
    var sum = 0
    var N = n
    while (N > 0) {
      val k = N % 10
      sum += (k * k)
      N = N / 10
    }
    sum
  }
}
