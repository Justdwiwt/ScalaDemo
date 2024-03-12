package leetCode._1400

object Solution_1375 {
  def numTimesAllBlue(light: Array[Int]): Int = light.indices./:((0, 0))((b, a) => {
    if (b._2.max(light(a)) == a + 1) (b._1 + 1, a + 1)
    else (b._1, b._2.max(light(a)))
  })._1
}
