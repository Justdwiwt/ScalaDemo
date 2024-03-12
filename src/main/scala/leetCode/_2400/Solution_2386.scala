package leetCode._2400

object Solution_2386 {
  def kSum(nums: Array[Int], k: Int): Long = {
    var a = Array(0L)
    nums.foreach(num => {
      val b = Array.fill((a.length << 1).min(k))(0L)
      var i = 0
      var j = 0
      var x = 0
      while (x < b.length) {
        if (i == a.length) {
          b(x) = a(j)
          x += 1
          j += 1
        } else if (j == a.length) {
          b(x) = a(i) + num
          x += 1
          i += 1
        } else if (a(i) + num >= a(j)) {
          b(x) = a(i) + num
          x += 1
          i += 1
        } else {
          b(x) = a(j)
          x += 1
          j += 1
        }
      }
      a = b
    })
    a(k - 1)
  }
}
