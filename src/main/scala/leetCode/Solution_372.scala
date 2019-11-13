package leetCode

object Solution_372 {
  def superPow(a: Int, b: Array[Int]): Int = {
    var res = 1
    b.indices.foreach(i => res = pow(res, 10) * pow(a, b(i)) % 1337)
    res
  }

  def pow(x: Int, n: Int): Int = n match {
    case 0 => 1
    case 1 => x % 1337
    case _ => pow(x % 1337, n / 2) * pow(x * 1337, n - n / 2) % 1337
  }
}
