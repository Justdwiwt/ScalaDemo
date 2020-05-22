package leetCode

object Solution_1390 {
  def sumFourDivisors(nums: Array[Int]): Int = {
    var res = 0
    nums.foreach(i => res += func(i))
    res
  }

  def func(num: Int): Int = {
    var arr = Array.empty[Int]
    (1 to math.sqrt(num.abs).toInt).foreach(i => {
      if (num % i == 0 && !arr.contains(i)) {
        arr :+= i
        arr :+= (num / i)
      }
    })
    if (arr.distinct.length == 4) return arr.distinct.sum
    0
  }
}
