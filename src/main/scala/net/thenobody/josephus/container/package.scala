package net.thenobody.josephus

import net.thenobody.josephus.solver.{IterativeJosephusProblemSolver, RecursiveJosephusProblemSolver}

/**
  * Created by antonvanco on 29/10/2016.
  */
package object container {

  lazy val iterativeProblemSolverInstance = new IterativeJosephusProblemSolver
  lazy val recursiveProblemSolverInstance = new RecursiveJosephusProblemSolver

}
