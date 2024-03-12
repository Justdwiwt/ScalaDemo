package leetCode._1000

object Solution_913 {
  sealed trait Player {
    def start: Int
  }

  case object Cat extends Player {
    override def start: Int = 2
  }

  case object Mouse extends Player {
    override def start: Int = 1
  }

  sealed trait Result {
    def toInt: Int
  }

  case object Draw extends Result {
    override def toInt: Int = 0
  }

  final case class Win(player: Player) extends Result {
    override def toInt: Int = player match {
      case Cat => 2
      case Mouse => 1
    }
  }

  class Lazy[+A](f: => A) {
    private lazy val elem = f

    def get: A = elem
  }

  object Lazy {
    def apply[A](f: => A) = new Lazy(f)
  }

  private val Hole = 0

  def catMouseGame(graph: Array[Array[Int]]): Int = {
    lazy val res: IndexedSeq[IndexedSeq[IndexedSeq[Lazy[Result]]]] = IndexedSeq
      .tabulate(2 * graph.length + 1, graph.length, graph.length) {
        case (turn, _, _) if turn == 2 * graph.length => Lazy(Draw)
        case (_, cat, mouse) if cat == mouse => Lazy(Win(Cat))
        case (_, _, Hole) => Lazy(Win(Mouse))
        case (turn, cat, mouse) if turn % 2 == 0 =>
          @scala.annotation.tailrec
          def playOptimally(moves: Seq[Int], result: Result = Win(Cat)): Result = moves match {
            case Seq(head, tail@_*) => res(turn + 1)(cat)(head).get match {
              case Win(Mouse) => Win(Mouse)
              case Draw => playOptimally(tail, Draw)
              case _ => playOptimally(tail, result)
            }
            case _ => result
          }

          Lazy(playOptimally(graph(mouse).toSeq))

        case (turn, cat, mouse) =>
          @scala.annotation.tailrec
          def playOptimally(moves: Seq[Int], result: Result = Win(Mouse)): Result = moves match {
            case Seq(Hole, tail@_*) => playOptimally(tail, result)
            case Seq(head, tail@_*) => res(turn + 1)(head)(mouse).get match {
              case Win(Cat) => Win(Cat)
              case Draw => playOptimally(tail, Draw)
              case _ => playOptimally(tail, result)
            }
            case _ => result
          }

          Lazy(playOptimally(graph(cat).toSeq))
      }

    res.head(Cat.start)(Mouse.start).get.toInt
  }
}
