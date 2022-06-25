package leetCode

object Solution_2310 {
  def minimumNumbers(num: Int, k: Int): Int = {
    if (num == 0) return 0
    (1 to 10).foreach(i => if ((num - k * i) >= 0 && (num - k * i) % 10 == 0) return i)
    -1
  }
}
