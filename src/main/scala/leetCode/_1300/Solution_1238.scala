package leetCode._1300

object Solution_1238 {
  def circularPermutation(n: Int, start: Int): List[Int] = (0 until 1 << n)
    ./:(List[Int]())((acc, i) => (start ^ i ^ i >> 1) +: acc)
    .reverse
}
