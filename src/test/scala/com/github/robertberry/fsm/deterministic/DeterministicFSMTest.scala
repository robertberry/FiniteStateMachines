package com.github.robertberry.fsm.deterministic

import examples.EndsWithZero
import org.scalatest.FlatSpec

/**
 * Deterministic Finite State Machine specification
 */
class DeterministicFSMTest extends FlatSpec {
  "A Deterministic Finite State Machine" should "only allow start states that are part of its set of states" in {
    val endsWithZero = EndsWithZero.machine

    intercept[IllegalArgumentException] {
      new BinaryDFSM(endsWithZero.states, endsWithZero.transitions,
        'q4, endsWithZero.acceptStates)
    }
  }

  it should "only allow finish states that are also members of its states" in {
    val endsWithZero = EndsWithZero.machine

    intercept[IllegalArgumentException] {
      new BinaryDFSM(endsWithZero.states, endsWithZero.transitions, endsWithZero.startState,
        Set(endsWithZero.startState, 'q4))
    }
  }
}

