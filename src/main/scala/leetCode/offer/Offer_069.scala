package leetCode.offer

object Offer_069 {
  def peakIndexInMountainArray(A: Array[Int]): Int = A./:((-1, Int.MinValue))((lager, cur) => {
    if (cur < lager._2) return lager._1 else (lager._1 + 1, cur)
  })._1
}
