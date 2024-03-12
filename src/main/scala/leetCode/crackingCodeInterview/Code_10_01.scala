package leetCode.crackingCodeInterview

object Code_10_01 {
  def merge(A: Array[Int], m: Int, B: Array[Int], n: Int): Unit = {
    (0 until n).foreach(i => A(i + m) = B(i))
    java.util.Arrays.sort(A)
  }
}
