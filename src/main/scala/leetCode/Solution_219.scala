package leetCode

object Solution_219 {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    val s = new collection.mutable.HashSet[Int]()
    nums.indices.foreach(i => {
      if (s.contains(nums(i))) return true
      s.add(nums(i))
      if (s.size > k) s.remove(nums(i - k))
    })
    false
  }
}
