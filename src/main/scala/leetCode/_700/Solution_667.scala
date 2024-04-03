package leetCode._700

object Solution_667 {
  def constructArray(n: Int, k: Int): Array[Int] =
    (1 to n - k).toArray ++ (0 until k).toArray.map(x => if (x % 2 == 0) n - x / 2 else n - k + (x + 1) / 2)
}
