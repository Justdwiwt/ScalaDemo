package leetCode.offer

object Offer_075 {
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = arr1
    .map(x => arr2.zipWithIndex.toMap.getOrElse(x, 1000 + x))
    .zip(arr1)
    .sortBy(_._1)
    .map(_._2)
}
