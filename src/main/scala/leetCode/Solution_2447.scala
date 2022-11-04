package leetCode

object Solution_2447 {
  def subarrayGCD(nums: Array[Int], k: Int): Int = {
    var res = 0
    nums.zipWithIndex.foreach(v => {
      var tmp = 0
      (v._2 until nums.length).foreach(j => {
        tmp = BigInt(tmp).gcd(nums(j)).toInt
        if (tmp == k) res = res + 1
      })
    })
    res
  }
}
