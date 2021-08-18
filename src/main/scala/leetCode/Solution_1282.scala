package leetCode

object Solution_1282 {
  def groupThePeople(groupSizes: Array[Int]): List[List[Int]] = groupSizes
    .zipWithIndex
    ./:(Map.empty[Int, List[Int]])((res, idx) => {
      val group = idx._2 :: res.getOrElse(idx._1, List.empty)
      res + (idx._1 -> group)
    })
    ./:(List.empty[List[Int]])((res, entry) => res ++ entry._2.grouped(entry._1))
}
