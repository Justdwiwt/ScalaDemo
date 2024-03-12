package leetCode._1500

object Solution_1472 {

  class BrowserHistory(_homepage: String) {
    private var cur = -1
    private var end = -1
    private var arr = Array.empty[String]
    visit(_homepage)

    def visit(url: String) {
      cur += 1
      if (arr.length <= cur) arr :+= url
      else arr(cur) = url
      end = cur
    }

    def back(steps: Int): String = {
      cur = if (cur - steps < 0) 0 else cur - steps
      arr(cur)
    }

    def forward(steps: Int): String = {
      cur = if (cur + steps > end) end else cur + steps
      arr(cur)
    }

  }

}
