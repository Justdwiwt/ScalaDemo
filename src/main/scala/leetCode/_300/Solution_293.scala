package leetCode._300

object Solution_293 {
  def generatePossibleNextMoves(s: String): List[String] = s
    .indices
    .dropRight(1)
    .flatMap(i => {
      if (s(i) == s(i + 1) && s(i) == '+') {
        val updatedString = s.updated(i, '-').updated(i + 1, '-')
        Some(updatedString)
      } else None
    })
    .toList
}
