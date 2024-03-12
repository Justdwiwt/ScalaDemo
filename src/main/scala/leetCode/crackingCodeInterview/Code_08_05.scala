package leetCode.crackingCodeInterview

object Code_08_05 {
  def multiply(A: Int, B: Int): Int = B match {
    case 0 => 0
    case _ => (multiply(A, B >> 1) << 1) + (if ((B & 1) == 1) A else 0)
  }
}
