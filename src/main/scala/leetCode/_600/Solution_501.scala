package leetCode._600

import leetCode.TreeNode

object Solution_501 {

  class Window(val last: Int, val count: Int) {

    def addItem(newVal: Int): Window =
      if (newVal == last) new Window(last, count + 1)
      else new Window(newVal, 1)

  }

  class Modes(val items: List[Int], val count: Int) {

    def combine(item: Modes): Modes =
      if (count > item.count) this
      else if (count < item.count) item
      else new Modes(items ::: item.items, count)

  }

  class Result(val modes: Modes, val window: Window) {

    def addValue(value: Int): Result =
      addValue(value, window.addItem(value))

    def addValue(value: Int, curWindow: Window): Result =
      combine(Result(
        modes = new Modes(value :: Nil, curWindow.count),
        window = curWindow
      ))

    def combine(item: Result): Result =
      Result(modes.combine(item.modes), item.window)

  }

  object Result {
    def empty(): Result =
      Result(new Modes(Nil, 0), new Window(0, 0))

    def apply(modes: Modes, window: Window) =
      new Result(modes, window)
  }


  def findMode(root: TreeNode): Array[Int] =
    find(root, Result.empty())
      .modes
      .items
      .toArray

  def find(root: TreeNode, parent: Result): Result =
    if (root == null) parent
    else {
      val left = find(root.left, parent)
      val center = left.addValue(root.value)
      val right = find(root.right, center)
      right
    }

}
