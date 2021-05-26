package leetCode

object Solution_1861 {
  def rotateTheBox(box: Array[Array[Char]]): Array[Array[Char]] = {
    val res = Array.fill[Char](box.head.length, box.length)('.')
    box.indices.reverse
      .map({ i => val k = box.length - 1 - i; (i, k) })
      .foreach { case (i, k) =>
        var t = box.head.length - 1
        box.head.indices.reverse.foreach(j => box(i)(j) match {
          case '*' => res(j)(k) = '*'; t = j
          case '.' => if (res(t)(k) != '.') t = j
          case '#' => if (res(t)(k) != '.') res(j)(k) = '#' else {
            res(t)(k) = '#'
            t -= 1
          }
        })
      }
    res
  }
}
