package leetCode._1700

object Solution_1641 {
  def countVowelStrings(n: Int): Int = Stream.iterate(Vector.range(1, n + 2))(_.scan(0)(_ + _).tail)(3).last
}
