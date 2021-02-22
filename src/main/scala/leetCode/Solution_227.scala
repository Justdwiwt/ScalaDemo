package leetCode

object Solution_227 {
  private val Additive = Array('+', '-')
  private val Multiplicative = Array('*', '/')

  def calculate(s: String): Int = {
    val evals = s.split(Additive).map(t => {
      val ints = t.split(Multiplicative).map(_.trim.toInt)
      t.filter(Multiplicative.contains).zip(ints.tail)./:(ints.head) {
        case (left, ('*', right)) => left * right
        case (left, ('/', right)) => left / right
      }
    })
    s.filter(Additive.contains).zip(evals.tail)./:(evals.head) {
      case (left, ('+', right)) => left + right
      case (left, ('-', right)) => left - right
    }
  }
}
