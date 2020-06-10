package leetCode

object Solution_1356 {
  def sortByBits(arr: Array[Int]): Array[Int] = {
    val nums = Array.fill(arr.length)(0)
    arr.indices.foreach(i => nums(i) = arr(i))
    val t = nums.sorted((o1: Int, o2: Int) => {
      val _o1 = Integer.bitCount(o1)
      val _o2 = Integer.bitCount(o2)
      if (_o1 == _o2) o1 - o2 else _o1 - _o2
    })
    arr.indices.foreach(i => arr(i) = t(i))
    arr
  }
}
