package leetCode._1400

object Solution_1362 {
  def closestDivisors(num: Int): Array[Int] = {
    val res = Array.fill(2)(0)
    val sqrt = math.sqrt(num + 2).toInt
    (1 to sqrt).reverse.foreach(i => {
      if ((num + 1) % i == 0) {
        res(0) = i
        res(1) = (num + 1) / i
        return res
      }
      if ((num + 2) % i == 0) {
        res(0) = i
        res(1) = (num + 2) / i
        return res
      }
    })
    res
  }
}
