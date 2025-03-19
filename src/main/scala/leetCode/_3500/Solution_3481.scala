package leetCode._3500

import scala.collection.mutable

object Solution_3481 {
  def applySubstitutions(replacements: List[List[String]], text: String): String = {
    val mappedReplacements = replacements.collect { case List(k, v) => s"%$k%" -> v }.toMap

    val adjacencyList = mutable.Map.empty[String, List[String]].withDefaultValue(Nil)

    mappedReplacements.foreach { case (k, v) =>
      adjacencyList(k) = mappedReplacements.keys.filter(v.contains).toList
    }

    def resolve(key: String, cache: mutable.Map[String, String]): String = {
      cache.getOrElseUpdate(key, adjacencyList(key).foldLeft(mappedReplacements(key)) {
        (acc, placeholder) => acc.replace(placeholder, resolve(placeholder, cache))
      })
    }

    val resolvedValues = mutable.Map.empty[String, String]
    mappedReplacements.keys.foreach(resolve(_, resolvedValues))

    resolvedValues.foldLeft(text) { case (acc, (k, v)) => acc.replace(k, v) }
  }
}
