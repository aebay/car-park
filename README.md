# car-park

Library for controlling traffic flow in a car park.

## Assumptions

- The car park capacity is set but should be variable e.g. opening/closing overflow areas.
- A car on arrival is parked at the *first* empty slot.
- Each car has a *4 digit* registration number.

## Actions

- PARK: a car with registration number *N* parks at the first *empty* slot.
- DEPART: most recently parked car departs.
- SMALLEST: return the smallest registration number in the car park.

### Extra:

- RESIZE: change the capacity of the existing car park.

## Notes:

It does not stop cars with identical registrations from being parked (the car park owners don't care if the population is using cloned plates...)
