package leetCode.LCP

object LCP_72 {
  def supplyWagon(supplies: Array[Int]): Array[Int] = {
    val m = supplies.length / 2
    var n = supplies.length
    while (n > m) {
      var j = 1
      (1 until n).foreach(i => if (supplies(i) + supplies(i - 1) < supplies(j) + supplies(j - 1)) j = i)
      supplies(j - 1) += supplies(j)
      System.arraycopy(supplies, j + 1, supplies, j, n - 1 - j)
      n -= 1
    }
    java.util.Arrays.copyOf(supplies, m)
  }
}
