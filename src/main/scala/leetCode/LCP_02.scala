package leetCode

object LCP_02 {
  def fraction(cont: Array[Int]): Array[Int] = cont.length match {
    case 1 => Array(cont(0), 1)
    case _ =>
      val right = count(cont)
      Array(cont(0) * right(1) + right(0), right(1))
  }

  def count(cont: Array[Int]): Array[Int] = {
    val idx = cont.length - 1
    var a = 1
    var b = cont(idx)
    (idx - 1 to 1 by (-1)).foreach(i => {
      val t = a
      a = b
      b = b * cont(i) + t
    })
    Array(a, b)
  }
}
