package leetCode._2900

object Solution_2832 {
  def maximumLengthOfRanges(nums: Array[Int]): Array[Int] = {
    val arr = Array.fill(nums.length)(Array(-1, nums.length))
    val st = collection.mutable.Stack[Int]()

    nums.zipWithIndex.foreach { case (v, i) =>
      while (st.nonEmpty && nums(st.top) < v) arr(st.pop())(1) = i
      if (st.nonEmpty) arr(i)(0) = st.top
      st.push(i)
    }

    arr.map { case Array(start, end) => end - start - 1 }
  }
}
