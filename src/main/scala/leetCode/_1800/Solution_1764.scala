package leetCode._1800

object Solution_1764 {
  def canChoose(groups: Array[Array[Int]], nums: Array[Int]): Boolean = {
    val matchIdx = groups./:(0)((pos, group) => {
      if (pos != -1) {
        val idx = nums.indexOfSlice(group, pos)
        if (idx == -1) -1 else idx + group.length
      } else -1
    })
    matchIdx != -1
  }
}
