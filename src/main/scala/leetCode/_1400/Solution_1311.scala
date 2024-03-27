package leetCode._1400

object Solution_1311 {
  def watchedVideosByFriends(watchedVideos: List[List[String]], friends: Array[Array[Int]], id: Int, level: Int): List[String] = {
    lazy val group = friends.iterator.zipWithIndex.map { case (fs, i) => i -> fs.toSet }.toMap

    @scala.annotation.tailrec
    def f(lvl: Int, prev: Set[Int], visited: Set[Int]): Set[Int] = {
      def reducer(a: Set[Int], b: Set[Int]): Set[Int] =
        a ++ b

      lazy val next = prev.map(group(_) -- visited)./:(Set.empty[Int])(reducer)
      if (lvl == level) next
      else f(lvl + 1, next, visited ++ next)
    }

    lazy val x0 = f(1, Set(id), Set(id))

    watchedVideos
      .zipWithIndex
      .filter { case (_, i) => x0.contains(i) }
      .flatMap(_._1)
      .groupBy(identity)
      .mapValues(_.size)
      .map { case (x, y) => (y, x) }
      .toList
      .sorted
      .map(_._2)
  }
}
