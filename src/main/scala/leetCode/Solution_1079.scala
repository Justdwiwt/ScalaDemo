package leetCode

object Solution_1079 {
  def numTilePossibilities(tiles: String): Int = List
    .range(1, tiles.length + 1)
    .map(i => tiles.toSeq.combinations(i).toList.map(s => s.permutations.toList.length).sum)
    .sum
}
