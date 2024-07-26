package leetCode._3300

object Solution_3226 {
  def minChanges(n: Int, k: Int): Int = {
    def binary(x: Int): String =
      ("0" * 30 + x.toBinaryString).takeRight(30)

    binary(n).zip(binary(k)).foldLeft(0) {
      case (-1, _) => -1
      case (_, ('0', '1')) => -1
      case (s, ('1', '0')) => s + 1
      case (s, _) => s
    }
  }
}
