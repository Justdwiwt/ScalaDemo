package leetCode._3600

object Solution_3514 {
  def uniqueXorTriplets(nums: Array[Int]): Int = {
    val st = nums.toSet
    if (st.size == 1) return 1
    val pairXors = collection.mutable.HashSet[Int]()
    val tripletXors = collection.mutable.HashSet[Int]()
    st.foreach(x => st.withFilter(x != _).foreach(y => pairXors += (x ^ y)))
    pairXors.foreach(pairXor => st.foreach(z => tripletXors += (pairXor ^ z)))
    tripletXors.size
  }
}
