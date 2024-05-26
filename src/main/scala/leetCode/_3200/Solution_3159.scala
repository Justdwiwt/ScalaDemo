package leetCode._3200

object Solution_3159 {
  def occurrencesOfElement(nums: Array[Int], queries: Array[Int], x: Int): Array[Int] = {
    val pos = nums.zipWithIndex.collect { case (num, idx) if num == x => idx }
    queries.map(query => if (query > pos.length) -1 else pos(query - 1))
  }
}
