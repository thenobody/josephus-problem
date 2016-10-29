package net.thenobody.josephus.solver

/**
  * Created by antonvanco on 29/10/2016.
  */
class IterativeJosephusProblemSolver extends JosephusProblemSolver {

  /**
    * Linear implementation of the solver
    * Iterates over individual steps until only one person remains (the result)
    * During iteration the solver uses previous elimination step's index (survivor index) to calculate
    * the survivor index in the current step.
    *
    * @param count  the total number of participants
    * @param step   the increment of elimination
    * @return       the index of the 'last man standing'
    */
  def solve(count: Int, step: Int): Int = (count, step) match {
    case (ValidValue(c), ValidValue(s)) =>
      (1 to c).foldLeft(0) {
        case (result, i) if i == 1 => 1
        case (result, i) => (result + step - 1) % i + 1
      }
    case _ =>
      throw new IllegalArgumentException(s"Arguments need to be positive integers, given count: $count, step: $step")
  }
}