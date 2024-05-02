package leetCode._800

object Solution_723 {
  @scala.annotation.tailrec
  def candyCrush(board: Array[Array[Int]]): Array[Array[Int]] = {
    var flag = false

    board.indices.foreach(r => board
      .head
      .indices
      .dropRight(2)
      .map { c => val v = board(r)(c).abs; (c, v) }
      .withFilter { case (c, v) => v != 0 && v == board(r)(c + 1).abs && v == board(r)(c + 2).abs }
      .foreach { case (c, v) =>
        board(r)(c) = -v
        board(r)(c + 1) = -v
        board(r)(c + 2) = -v
        flag = true
      }
    )

    board.indices.dropRight(2).foreach(r => board
      .head
      .indices
      .map { c => val v = board(r)(c).abs; (c, v) }
      .withFilter { case (c, v) => v != 0 && v == board(r + 1)(c).abs && v == board(r + 2)(c).abs }
      .foreach { case (c, v) =>
        board(r)(c) = -v
        board(r + 1)(c) = -v
        board(r + 2)(c) = -v
        flag = true
      }
    )

    board.head.indices.foreach(c => {
      var wr = board.length - 1
      board.indices.reverse.withFilter(board(_)(c) > 0).foreach(r => {
        board(wr)(c) = board(r)(c)
        wr -= 1
      })
      while (wr >= 0) {
        board(wr)(c) = 0
        wr -= 1
      }
    })

    if (flag) candyCrush(board) else board
  }
}
