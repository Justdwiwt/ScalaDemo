package leetCode._2400

object Solution_2310 {
  def minimumNumbers(num: Int, k: Int): Int =
    if (num == 0) 0
    else (1 to 10).find(i => i * k % 10 == num % 10 && i * k <= num).getOrElse(-1)
}
