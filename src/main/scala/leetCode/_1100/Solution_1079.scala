package leetCode._1100

object Solution_1079 {
  def numTilePossibilities(tiles: String): Int = List
    .range(1, tiles.length + 1)
    .map(tiles.toSeq.combinations(_).toList.map(_.permutations.toList.length).sum)
    .sum
}
