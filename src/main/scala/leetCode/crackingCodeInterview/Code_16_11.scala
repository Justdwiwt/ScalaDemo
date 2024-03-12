package leetCode.crackingCodeInterview

object Code_16_11 {
  def divingBoard(shorter: Int, longer: Int, k: Int): Array[Int] = {
    if (k == 0) return Array.empty
    if (shorter == longer) return Array(shorter * k)
    val res = Array.fill(k + 1)(0)
    val start = shorter * k
    (0 to k).foreach(i => res(i) = start + (longer - shorter) * i)
    res
  }
}
