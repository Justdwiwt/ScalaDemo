package leetCode._800

object Solution_734 {
  def areSentencesSimilar(sentence1: Array[String], sentence2: Array[String], similarPairs: List[List[String]]): Boolean =
    sentence1.length == sentence2.length && {
      val st = similarPairs.flatMap(pair => Set(pair.head + "#" + pair(1))).toSet
      sentence1.indices.forall(i =>
        sentence1(i) == sentence2(i) ||
          st.contains(sentence1(i) + "#" + sentence2(i)) ||
          st.contains(sentence2(i) + "#" + sentence1(i))
      )
    }
}
