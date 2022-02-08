package leetCode

object Solution_1424 {
  def findDiagonalOrder(nums: List[List[Int]]): Array[Int] = {
    val m = nums.zipWithIndex./:(Map.empty[Int, List[Int]].withDefaultValue(Nil)) { case (m1, (row, rowIdx)) =>
      row.zipWithIndex./:(m1) { case (m2, (v, colIdx)) =>
        val k = rowIdx + colIdx
        m2 + (k -> (v +: m2(k)))
      }
    }
    m.keys.toList.sorted.flatMap(m.apply).toArray
  }
}
