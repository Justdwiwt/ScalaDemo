package leetCode._1100

object Solution_1053 {
  def prevPermOpt1(A: Array[Int]): Array[Int] = {
    var left = 0
    var right = 0
    val t = A
    (0 until t.length - 1).foreach(i => {
      if (t(i) > t(i + 1)) {
        left = i
        right = i + 1
      } else if (left != right && t(i) < t(i + 1) && t(left) > t(i + 1)) right = i + 1
    })
    val v = t(left)
    t(left) = t(right)
    t(right) = v
    t
  }
}
