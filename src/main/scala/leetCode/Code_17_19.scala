package leetCode

object Code_17_19 {
  def missingTwo(nums: Array[Int]): Array[Int] = {
    var xor = 0
    nums.foreach(n => xor ^= n)
    (1 to nums.length + 2).foreach(i => xor ^= i)
    var idx = 0
    while ((xor >> idx & 1) != 1) idx += 1
    var a = 0
    var b = 0
    nums.foreach(n => if ((n >> idx & 1) == 1) a = a ^ n else b = b ^ n)
    (1 to nums.length + 2).foreach(i => if ((i >> idx & 1) == 1) a = a ^ i else b = b ^ i)
    if (a < b) Array(a, b) else Array(b, a)
  }
}
