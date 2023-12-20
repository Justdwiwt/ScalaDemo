package leetCode

object Solution_661 {
  def imageSmoother(img: Array[Array[Int]]): Array[Array[Int]] = {
    def f(x: Int, y: Int): Int = {
      val elements = (x - 1 to x + 1).flatMap(_x => (y - 1 to y + 1)
        .withFilter(_y => _x >= 0 && _x < img.head.length && _y >= 0 && _y < img.length)
        .map(_y => img(_y)(_x)))

      (elements.sum.toDouble / elements.length).floor.toInt
    }

    img.indices.map(ri => img.head.indices.map(ci => f(ci, ri)).toArray).toArray
  }
}
