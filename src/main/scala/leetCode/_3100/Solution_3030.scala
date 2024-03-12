package leetCode._3100

object Solution_3030 {
  private case class C(i: Int, j: Int)

  def resultGrid(image: Array[Array[Int]], threshold: Int): Array[Array[Int]] = {
    val avgs = image.indices.tail.init
      .flatMap(i => image.head.indices.tail.init.flatMap(j => listAvgs(image, threshold, C(i, j)).map(avg => avg)))
      .groupBy(_._1)
      .mapValues(_.map(_._2))

    image.indices.toArray.map(i => image(i).indices.toArray.map(j => avgs.get(C(i, j)).fold(image(i)(j))(nel => nel.sum / nel.size)))
  }

  private def listAvgs(image: Array[Array[Int]], threshold: Int, center: C): List[(C, Int)] = {
    val region = neighbor9(center)
    val inThreshold = region.forall(c1 => neighbor4(c1).filter(region.contains).forall(c2 => (image(c1.i)(c1.j) - image(c2.i)(c2.j)).abs <= threshold))
    val avg = region.map(c => image(c.i)(c.j)).sum / 9
    if (inThreshold) region.map(_ -> avg) else List.empty
  }

  private def neighbor9(c: C): List[C] = List(
    C(c.i - 1, c.j - 1), C(c.i - 1, c.j), C(c.i - 1, c.j + 1),
    C(c.i, c.j - 1), C(c.i, c.j), C(c.i, c.j + 1),
    C(c.i + 1, c.j - 1), C(c.i + 1, c.j), C(c.i + 1, c.j + 1),
  )

  private def neighbor4(c: C): List[C] = List(
    C(c.i - 1, c.j),
    C(c.i + 1, c.j),
    C(c.i, c.j - 1),
    C(c.i, c.j + 1)
  )
}
