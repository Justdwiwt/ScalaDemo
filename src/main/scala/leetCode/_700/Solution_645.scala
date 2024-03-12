package leetCode._700

object Solution_645 {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    var xor, xor1, xor2 = 0
    nums.foreach(n => xor ^= n)
    (1 to nums.length).foreach(n => xor ^= n)
    val rightBit = xor & ~(xor - 1)
    nums.foreach(n => if ((rightBit & n) == 0) xor1 ^= n else xor2 ^= n)
    (1 to nums.length).foreach(n => if ((rightBit & n) == 0) xor1 ^= n else xor2 ^= n)
    nums.foreach(n => if (n == xor1) return Array(xor1, xor2) else if (n == xor2) return Array(xor2, xor1))
    Array(xor1, xor2)
  }
}
