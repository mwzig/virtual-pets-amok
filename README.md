README file for the virtual-pet-shelter project

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
   - they will need to pee after they are watered, and poop after they are fed.
 
   -To get a Cage Status to be "Dirty", an organic dog must need to both pee and poop, and activity
    level must be less than 33.   

   -If you clean their cage, they will be let outside and not need to pee or poop.
   -If you walk them, they will not need to pee or poop.
 
   -Just playing with them does NOT change their need to pee or poop.
 
   - If hunger level is 50 or higher, he or she is hungry.
   - If thirst level is 50 or higher, he or she is thirsty.
   - If activity level is less than 33, he or she needs activity.
   
   
  
  
	