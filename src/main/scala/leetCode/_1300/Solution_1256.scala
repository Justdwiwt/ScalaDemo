package leetCode._1300

object Solution_1256 {
  def encode(num: Int): String =
    Integer.toBinaryString(num + 1).substring(1)
}
