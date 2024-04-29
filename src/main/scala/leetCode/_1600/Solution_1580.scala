package leetCode._1600

object Solution_1580 {
  def maxBoxesInWarehouse(boxes: Array[Int], warehouse: Array[Int]): Int = {
    val len = warehouse.length
    val left = Array.fill(len)(0)
    var minIndex = -1

    warehouse.indices.reverse.foreach(i => {
      if (minIndex == -1 || warehouse(minIndex) > warehouse(i)) minIndex = i
      if (i == warehouse.length - 1) left(i) = warehouse(i)
      else if (warehouse(i) < left(i + 1)) left(i) = warehouse(i)
      else left(i) = left(i + 1)
    })

    val right = Array.fill(len)(0)

    warehouse.indices.foreach(i =>
      if (i == 0) right(i) = warehouse(i)
      else if (warehouse(i) < right(i - 1)) right(i) = warehouse(i)
      else right(i) = right(i - 1)
    )

    val wareLimit = Array.fill(len)(0)
    wareLimit(minIndex) = left(minIndex)

    (0 until minIndex).foreach(i => wareLimit(i) = left(i).max(right(i)))

    (minIndex + 1 until warehouse.length).foreach(i => wareLimit(i) = left(i).max(right(i)))

    val boxesSorted = boxes.sorted
    val wareLimitSorted = wareLimit.sorted
    var containCount = 0
    var wareIndex = 0

    var canSet = true

    boxesSorted
      .indices
      .withFilter(_ => canSet)
      .foreach(i => {
        while (wareIndex < wareLimitSorted.length && wareLimitSorted(wareIndex) < boxesSorted(i)) wareIndex += 1
        if (wareIndex >= wareLimitSorted.length) canSet = false
        else {
          containCount += 1
          wareIndex += 1
        }
      })

    containCount
  }
}
