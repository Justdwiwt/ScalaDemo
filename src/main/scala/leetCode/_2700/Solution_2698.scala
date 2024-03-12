package leetCode._2700

object Solution_2698 {
  def punishmentNumber(n: Int): Int = {
    def f(num: Int, target: Int): Boolean =
      if (target < 0 || num < target) false
      else if (num == target) true
      else Array(10, 100, 1000).exists(div => f(num / div, target - num % div))

    (1 to n).collect { case i if f(i * i, i) => i * i }.sum
  }
}
