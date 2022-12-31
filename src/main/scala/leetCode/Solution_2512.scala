package leetCode

object Solution_2512 {
  def topStudents(pos1: Array[String], neg1: Array[String], reps: Array[String], ids: Array[Int], k: Int): List[Int] = {
    val (pos, neg) = (pos1.toSet, neg1.toSet)
    reps
      .zip(ids)
      .map { case (rep, id) => rep.split(' ').count(pos.contains) * 3 - rep.split(' ').count(neg.contains) -> id }
      .sortBy { case (score, id) => (-score, id) }
      .take(k)
      .map { case (_, id) => id }
      .toList
  }
}
