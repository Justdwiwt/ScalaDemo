package leetCode._800

object Solution_722 {
  @scala.annotation.tailrec
  private def processLine(line: List[Char], processed: List[Char], res: List[(List[Char], Boolean)], hasBlock: Boolean = false, toAppend: Boolean = false): (List[(List[Char], Boolean)], Boolean) =
    if (hasBlock) line match {
      case '*' :: '/' :: tail => processLine(tail, processed, res, toAppend = true)
      case _ :: tail => processLine(tail, processed, res, hasBlock = true, toAppend)
      case Nil => (res, hasBlock)
    } else line match {
      case '/' :: '/' :: _ => ((processed, toAppend) :: res, hasBlock)
      case '/' :: '*' :: tail => processLine(tail, Nil, (processed, toAppend) :: res, hasBlock = true, toAppend)
      case c :: tail => processLine(tail, c :: processed, res, toAppend = toAppend)
      case Nil => ((processed, toAppend) :: res, hasBlock)
    }

  @scala.annotation.tailrec
  private def processLines(lines: List[(List[Char], Boolean)], processedLines: List[List[Char]] = Nil, prefix: List[Char] = Nil): List[List[Char]] = lines match {
    case l :: tail => l match {
      case (s, true) => processLines(tail, processedLines, prefix ++ s)
      case (s, false) => processLines(tail, (prefix ++ s) :: processedLines)
    }
    case Nil => processedLines
  }

  private def reverseList[T](list: List[T]): List[T] = list match {
    case x :: xs => reverseList(xs) :+ x
    case Nil => Nil
  }

  def removeComments(source: Array[String]): List[String] = {
    val sourceList = source.toList
    val lines = sourceList.foldLeft((List[(List[Char], Boolean)](), false))((prev, line) => {
      val (pre, hasBlock) = prev
      pre match {
        case List() => processLine(line.toList, Nil, pre, hasBlock)
        case res :: _ =>
          val (_, _) = res
          processLine(line.toList, Nil, pre, hasBlock)
      }
    })
    val processedLines = processLines(lines._1)
    processedLines.filter(_.nonEmpty).map(reverseList).map(_.mkString(""))
  }
}
