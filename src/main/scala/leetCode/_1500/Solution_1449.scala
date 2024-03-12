package leetCode._1500

object Solution_1449 {
  def largestNumber(cost: Array[Int], target: Int): String = {
    val arr = Array.fill(target + 1)("#")
    arr(0) = ""
    (0 to 8).reverse.foreach(i => (cost(i) to target).foreach(j => {
      val t = arr(j - cost(i)) + ('0' + i + 1).toChar
      if (check(t, arr(j))) arr(j) = t
    }))
    if (arr(target)(0).toString == "#") return "0"

    def check(a: String, b: String): Boolean = (a.head.toString, b.head.toString) match {
      case ("#", _) => false
      case (_, "#") => true
      case _ =>
        if (a.length != b.length) return a.length > b.length
        a.indices.foreach(i => if (a(i) != b(i)) return a(i) > b(i))
        true
    }

    arr(target)
  }
}
