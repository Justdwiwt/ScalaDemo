package leetCode._2800

object Solution_2766 {
  def relocateMarbles(nums: Array[Int], moveFrom: Array[Int], moveTo: Array[Int]): List[Int] = {
    val arr = moveFrom.zip(moveTo)
    val res = arr./:(nums.toSet) { case (st, (from, to)) => if (st.contains(from)) st - from + to else st }
    res.toList.sorted
  }
}
