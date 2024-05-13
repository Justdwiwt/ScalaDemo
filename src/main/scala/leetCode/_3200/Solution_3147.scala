package leetCode._3200

object Solution_3147 {
  def maximumEnergy(energy: Array[Int], k: Int): Int = {
    val sums1 = Array.fill(k)(0)
    val sums2 = Array.fill(k)(0)
    var i = 0
    while (i < energy.length) {
      sums1(i % k) = sums1(i % k) + energy(i)
      i = i + 1
    }
    i = 0
    var res = Int.MinValue
    while (i < energy.length) {
      res = res.max(sums1(i % k) - sums2(i % k))
      sums2(i % k) = sums2(i % k) + energy(i)
      i = i + 1
    }
    res
  }
}
