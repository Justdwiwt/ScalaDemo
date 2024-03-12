package leetCode.crackingCodeInterview

object Code_16_21 {
  def findSwapValues(array1: Array[Int], array2: Array[Int]): Array[Int] = {
    val st = array2.toSet
    val s1 = array1.sum
    val s2 = array2.sum
    var diff = s1 - s2
    if (diff % 2 != 0) return Array.empty
    diff /= 2
    array1.foreach(n => if (st.contains(n - diff)) return Array(n, n - diff))
    Array.empty
  }
}
