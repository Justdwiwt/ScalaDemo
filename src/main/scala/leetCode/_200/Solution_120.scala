package leetCode._200

object Solution_120 {
  def minimumTotal(triangle: List[List[Int]]): Int = triangle
    .reduceRight((a, b) => (a, b, b.tail).zipped.map { case (x, y, z) => x + y.min(z) })
    .head
}
