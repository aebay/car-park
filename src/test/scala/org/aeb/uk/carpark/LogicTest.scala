package org.aeb.uk.carpark

import org.scalatest.FlatSpec

class LogicTest extends FlatSpec {

  behavior of "car park"

  it should "park a new car in an empty car park" is pending

  it should "park a new car in the first empty slot in an occupied car park" is pending

  it should "not park a new car in a full car park" is pending

  it should "remove the most recently parked car" is pending

  it should "be empty after the last car departs" is pending

  it should "remove the most recently parked cars if the capacity is reduced below the number of cars present" is pending

  it should "contain the same cars in the order they were parked if the capacity is increased" is pending

  it should "return the car with the smallest registration number" is pending

}