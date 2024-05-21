package leetCode.LCP

object LCP_63 {
  private val dir = Array((0, 1), (1, 0), (0, -1), (-1, 0))

  def ballGame(num: Int, plate: Array[String]): Array[Array[Int]] = {
    val m = plate.length
    val n = plate.head.length

    def check(x: Int, y: Int, d: Int): Boolean = {
      var left = num
      var cx = x
      var cy = y
      var cd = d
      while (plate(cx)(cy) != 'O') {
        if (left == 0) return false
        plate(cx)(cy) match {
          case 'W' => cd = (cd + 3) % 4
          case 'E' => cd = (cd + 1) % 4
          case _ =>
        }
        cx += dir(cd)._1
        cy += dir(cd)._2
        if (!(0 <= cx && cx < m && 0 <= cy && cy < n)) return false
        left -= 1
      }
      true
    }

    var res = Array.empty[Array[Int]]
    plate.head.indices.drop(1).dropRight(1).foreach(j => {
      if (plate.head(j) == '.' && check(0, j, 1)) res :+= Array(0, j)
      if (plate(m - 1)(j) == '.' && check(m - 1, j, 3)) res :+= Array(m - 1, j)
    })
    plate.indices.drop(1).dropRight(1).foreach(i => {
      if (plate(i).head == '.' && check(i, 0, 0)) res :+= Array(i, 0)
      if (plate(i)(n - 1) == '.' && check(i, n - 1, 2)) res :+= Array(i, n - 1)
    })
    res
  }
}
