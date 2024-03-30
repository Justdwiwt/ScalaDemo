package leetCode._1100

object Solution_1089 {
  def duplicateZeros(arr: Array[Int]): Unit = {
    val lastIndex = arr.lastIndexWhere(_ => true)
    (lastIndex until -1 by -1).foreach(i => if (arr(i).equals(0)) f(arr, i, lastIndex))
  }

  @scala.annotation.tailrec
  private def f(arr: Array[Int], lIndex: Int, rIndex: Int): Unit =
    if (rIndex > lIndex) {
      arr(rIndex) = arr(rIndex - 1)
      f(arr, lIndex, rIndex - 1)
    }
}
