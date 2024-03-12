package leetCode.crackingCodeInterview

object Code_17_01 {
  @scala.annotation.tailrec
  def add(a: Int, b: Int): Int = b match {
    case 0 => a
    case _ => add(a ^ b, (a & b) << 1)
  }
}
