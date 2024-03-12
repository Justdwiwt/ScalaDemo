package leetCode.crackingCodeInterview

object Code_05_08 {
  def drawLine(length: Int, w: Int, x1: Int, x2: Int, y: Int): Array[Int] = {
    val res = Array.fill(length)(0)
    (x1 to x2).foreach(i => res(i / 32 + y * w / 32) |= (1 << (31 - i % 32)))
    res
  }
}
