package leetCode

object Solution_1702 {
  def maximumBinaryString(binary: String): String = {
    val idx = binary.indexOf('0')
    if (idx == -1) binary
    else {
      val cnt = binary.substring(idx).count(_ == '0')
      (Seq.fill(idx)('1') ++ Seq.fill(cnt - 1)('1') ++ Seq('0') ++ Seq.fill(binary.length - idx - cnt)('1')).mkString("")
    }
  }
}
