README file for the virtual-pet-shelter project

 (Consider future change to add a type to the VirtualPet to indicate the
  type of pet to make sorting by pet type more efficient in the user interface).
 
 If all pets are adopted, the game ends.  (Assume that paid employees are still
 working in case a pet comes in to be admitted).
 
 A litter box waste level that is between 0 and 40 is considered "clean".
 
 For organic cats and dogs:
   - After each user interaction (even if you choose to do nothing) the tick() method 
     executes to mimic the passing of time.  This increases the hunger and thirst levels 
     by +5, and decreases the activity level by 5.
   
   - If you give food or water to a pet, it resets his/her hunger and thirst levels to 0. 
   - However, because of the passage of time (the tick() method), 
     those levels are quickly incremented by 5, thus they show up as 5 rather than 0 
     immediately after feeding or watering.
   
 For organic dogs:
   - They will need to pee after they are watered, and poop after they are fed.
 
   - To get a Cage Status to be "Dirty", an organic dog must need to both pee and poop, and activity
     level must be less than 33.   

   - If you clean their cage, they will be let outside and not need to pee or poop.
   - If you walk them, they will not need to pee or poop.
 
   - Just playing with them does NOT change their need to pee or poop.
 
   - If hunger level is 50 or higher, he or she is hungry.
   - If thirst level is 50 or higher, he or she is thirsty.
   - If activity level is less than 33, he or she needs activity.
   
   - Fifi, contrary to her name, is a very large dog.  Her waste amount is 10.
   - Fido's waste amount is 1.  If there is a mess in their cages, then that is how
     much waste each generates (11 total).
   - The app displays the total amount of waste in dog cages above the table
     of status values.
   
  
    Some comments copied from the Organic Cat class tick() method regarding possible future changes:
	// This is coded to be as close to meeting the specs as possible.
	// It does result in a little timing thing - the cat generates waste that
	// goes into the status of the litter box <after> it gets its status of the box.
	// A potential change - if specs would allow - would be to change logic so the 
	// cat generates waste into the litter box in this method (rather than having
	// the shelter class do that), and then getting the status of the box.
	// Then, you could have a cage object for the organic dogs, and pass that cage
	// object to the dog's tick method.
	- basically this means we pass the litter box to the cat on the tick method, have it
	 call the litterbox.addWaste method right there rather than having the Shelter method
	 do that.  Same thing for dogs, but with a cage.