package leetCode._1600

object Solution_1564 {
  def maxBoxesInWarehouse(boxes: Array[Int], warehouse: Array[Int]): Int = {
    val sorted = boxes.sorted
    warehouse.indices.drop(1).foreach(i => if (warehouse(i) > warehouse(i - 1)) warehouse(i) = warehouse(i - 1))

    @scala.annotation.tailrec
    def f(pw: Int, pb: Int, res: Int): Int =
      if (pb < boxes.length && pw >= 0) {
        if (sorted(pb) <= warehouse(pw)) f(pw - 1, pb + 1, res + 1)
        else f(pw - 1, pb, res)
      } else res

    f(warehouse.length - 1, 0, 0)
  }
}
