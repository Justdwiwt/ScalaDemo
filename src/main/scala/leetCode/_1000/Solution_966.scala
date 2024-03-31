package leetCode._1000

object Solution_966 {
  case class Trie(idx: Option[Int], child: Map[Char, Trie])

  private def insert(string: List[Char], index: Int, trie: Trie): Trie = string match {
    case Nil =>
      trie.idx match {
        case None => Trie(Some(index), trie.child)
        case s@Some(j) => if (j < index) Trie(s, trie.child) else Trie(Some(index), trie.child)
      }
    case x :: xs =>
      val sub = trie.child.getOrElse(x, Trie(None, Map()))
      Trie(trie.idx, trie.child + (x -> insert(xs, index, sub)))
  }

  sealed abstract class SearchState

  private case object PerfectMatch extends SearchState

  private case object Capitalization extends SearchState

  private case object VowelError extends SearchState

  implicit object SearchStateOrdering extends Ordering[SearchState] {
    def compare(a: SearchState, b: SearchState): Int = (a, b) match {
      case (PerfectMatch, PerfectMatch) => 0
      case (PerfectMatch, _) => -1
      case (Capitalization, PerfectMatch) => 1
      case (Capitalization, Capitalization) => 0
      case (Capitalization, _) => -1
      case (VowelError, VowelError) => 0
      case (VowelError, _) => 1
    }
  }

  sealed abstract class SearchResult

  private final case class Found(state: SearchState, idx: Int) extends SearchResult

  private case object NotFound extends SearchResult

  implicit def searchResultOrdering(implicit ss: Ordering[SearchState]): Ordering[SearchResult] = (a: SearchResult, b: SearchResult) => (a, b) match {
    case (NotFound, NotFound) => 0
    case (Found(s1, i1), Found(s2, i2)) => ss.compare(s1, s2) match {
      case x if x != 0 => x
      case _ => i1 - i2
    }
    case (NotFound, _) => -1
    case (Found(_, _), _) => 1
  }

  private val vowelSet = Set('a', 'e', 'i', 'o', 'u')
  private val vowelList = List('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

  private def candidate(ch: Char): List[(Char, SearchState)] =
    capitalize(ch) ++ vowelError(ch) ++ List((ch, PerfectMatch))

  private def capitalize(ch: Char): List[(Char, SearchState)] =
    if (ch.isLower) List((ch.toUpper, Capitalization))
    else List((ch.toLower, Capitalization))

  private def vowelError(ch: Char): List[(Char, SearchState)] =
    if (vowelSet(ch.toLower)) vowelList
      .map { v => val pair = (v, VowelError); (v, pair) }
      .withFilter { case (v, _) => v != ch }
      .map { case (_, pair) => pair }
    else Nil

  private def search(string: List[Char], s: SearchState, trie: Trie, currentSolution: List[SearchResult])(implicit o: Ordering[SearchState]): List[SearchResult] = string match {
    case Nil => trie.idx match {
      case None => currentSolution
      case Some(i) => Found(s, i) :: currentSolution
    }
    case x :: xs =>
      val candidates = candidate(x)
      candidates.foldLeft(currentSolution) {
        case (acc, (ch, st)) => trie.child.get(ch) match {
          case None => acc
          case Some(t) => search(xs, if (o.compare(st, s) > 0) st else s, t, acc)
        }
      }
  }

  def spellchecker(wordlist: Array[String], queries: Array[String]): Array[String] = {
    val words = wordlist.zipWithIndex
    val trie = words.foldLeft(Trie(None, Map())) { case (acc, (s, i)) => insert(s.toList, i, acc) }

    queries.map(query => {
      val answers = search(query.toList, PerfectMatch, trie, Nil).sorted
      answers.headOption.getOrElse(NotFound) match {
        case NotFound => ""
        case Found(_, i) => wordlist(i)
      }
    })
  }
}
