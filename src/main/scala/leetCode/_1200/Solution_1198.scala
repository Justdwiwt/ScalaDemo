package leetCode._1200

object Solution_1198 {
  def smallestCommonElement(mat: Array[Array[Int]]): Int = {
    def f(arr1: Array[Int], arr2: Array[Int]): Array[Int] =
      arr1.intersect(arr2)

    val dp = mat.tail.foldLeft(mat.head)(f)

    if (dp.nonEmpty) dp.head else -1
  }
}
