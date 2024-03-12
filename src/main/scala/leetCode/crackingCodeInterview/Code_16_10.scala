package leetCode.crackingCodeInterview

object Code_16_10 {
  def maxAliveYear(birth: Array[Int], death: Array[Int]): Int = {
    val arr = Array.fill(2001)(0)
    (1900 to 2000).foreach(i => {
      birth.foreach(j => if (i >= j) arr(i) += 1)
      death.foreach(k => if (i > k) arr(i) -= 1)
    })
    arr.indexOf(arr.max)
  }
}
