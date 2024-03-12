package leetCode.offer

object Offer_40 {
  def getLeastNumbers(arr: Array[Int], k: Int): Array[Int] = {
    val res = Array.fill(k)(0)
    val t = arr.sorted
    (0 until k).foreach(i => res(i) = t(i))
    res
  }
}
