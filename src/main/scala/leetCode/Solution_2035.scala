package leetCode

object Solution_2035 {
  def calCombinations(nums: Array[Int]): collection.mutable.Map[Int, java.util.TreeSet[java.lang.Integer]] = {
    val res = collection.mutable.Map[Int, java.util.TreeSet[java.lang.Integer]]()
    1.until(math.pow(2, nums.length).asInstanceOf[Int]).foreach(i => {
      val comb = nums.indices.filter(j => (i & 1 << j) != 0).map(j => nums(j))
      res.getOrElseUpdate(comb.length, new java.util.TreeSet[java.lang.Integer]()).add(comb.sum)
    })
    res
  }

  def minimumDifference(nums: Array[Int]): Int = {
    val left = nums.slice(0, nums.length / 2)
    val right = nums.slice(nums.length / 2, nums.length)
    var res = left.sum
    val leftComb = calCombinations(left)
    val rightComb = calCombinations(right)
    val half = nums.sum.asInstanceOf[Double] / 2
    1.until(nums.length / 2).foreach(i => {
      leftComb(i).forEach(num1 => {
        val target = (half - num1).asInstanceOf[Int]
        val n1 = rightComb(nums.length / 2 - i).ceiling(target)
        val n2 = rightComb(nums.length / 2 - i).floor(target)
        if (n1 != null && (half - res).abs > (half - (num1 + n1)).abs)
          res = num1 + n1
        if (n2 != null && (half - res).abs > (half - (num1 + n2)).abs)
          res = num1 + n2
      })
    })
    (nums.sum - 2 * res).abs
  }
}
