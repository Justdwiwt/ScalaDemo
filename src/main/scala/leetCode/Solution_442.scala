package leetCode

import scala.collection.mutable

object Solution_442 {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    var res = List[Int]()
    nums.indices.foreach(i => {
      val idx = nums(i).abs - 1
      if (nums(idx) < 0) res :+= (idx + 1)
      nums(idx) = -nums(idx)
    })
    res
  }

  def findDuplicates2(nums: Array[Int]): List[Int] = {
    var res = List[Int]()
    val s = new mutable.HashSet[Int]()
    nums.foreach(i => if (!s.add(i)) res :+= i)
    res
  }

  def findDuplicates3(nums: Array[Int]): List[Int] = {
    var res = List[Int]()
    nums.indices.foreach(i => nums((nums(i) - 1) % nums.length) += nums.length)
    nums.indices.foreach(i => if (nums(i) > 2 * nums.length) res :+= (i + 1))
    res
  }

  def findDuplicates4(nums: Array[Int]): List[Int] = {
    var res = List.empty[Int]
    nums.indices.foreach(i => {
      if (nums(nums(i).abs - 1) < 0) res ::= nums(i).abs
      nums(nums(i).abs - 1) *= -1
    })
    res
  }
}
