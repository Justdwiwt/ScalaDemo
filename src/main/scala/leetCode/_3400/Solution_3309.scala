package leetCode._3400

object Solution_3309 {
  def maxGoodNumber(nums: Array[Int]): Int = {
    val integerNums = nums.map(identity)

    val sorted = integerNums.sortWith((a, b) => {
      val binA = a.toBinaryString
      val binB = b.toBinaryString
      (binA + binB).compareTo(binB + binA) > 0
    })

    val binaryConcatenation = sorted.map(_.toBinaryString).mkString

    BigInt(binaryConcatenation, 2).toInt
  }
}
