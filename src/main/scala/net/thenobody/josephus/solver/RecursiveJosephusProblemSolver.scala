package net.thenobody.josephus.solver

import scala.annotation.tailrec

/**
  * Created by antonvanco on 29/10/2016.
  */
class RecursiveJosephusProblemSolver extends JosephusProblemSolver {

  /**
    * Recursive implementation of the solver
    *
    * Uses tail recursion carrying over the survivor index from the previous iteration and uses the value
    * to calculate the current survivor index. Afterwards, recursion continues to the next level.
    *
    * Note: using tail recursion here (rather than regular) to avoid stack overflow errors caused by large input values.
    *
    * @param count  the total number of participants
    * @param step   the increment of elimination
    * @return       the index of the 'last man standing'
    */
  def solve(count: Int, step: Int): Int = {

    @tailrec
    def solveTail(i: Int, result: Int): Int = i match {
      case _ if i == 0 => result
      case _ => solveTail(i - 1, (result + step - 1) % (count - i + 1) + 1)
    }

    (count, step) match {
      case (ValidValue(c), ValidValue(s)) =>
        solveTail(count, 1)
      case _ =>
        throw new IllegalArgumentException(s"Arguments need to be positive integers, given count: $count, step: $step")
    }
  }
}
