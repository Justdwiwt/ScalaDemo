package leetCode._200

object Solution_140 {
  def f[T, S](func: (T => S) => T => S, cache: scala.collection.mutable.HashMap[T, S]): T => S = n => {
    if (cache.contains(n)) cache(n)
    else {
      val t = func(f(func, cache))(n)
      cache(n) = t
      t
    }
  }

  def wordBreak(s: String, wordDict: List[String]): List[String] = {
    val word: (String => List[String]) => String => List[String] = f => {
      case "" => List[String]("")
      case r => wordDict./:(List[String]()) { (l, w) =>
        if (r.endsWith(w) && f(r.dropRight(w.length)).nonEmpty) l ::: f(r.dropRight(w.length)).map(str => if (str.nonEmpty) str + " " + w else w) else l
      }
    }
    val m = f(word, new scala.collection.mutable.HashMap[String, List[String]])
    m(s)
  }
}
