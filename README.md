# Final Capstone: Tournament Tracker

## Features:
- **Browsing**: Users can browse existing tournaments and view the participants, schedule, and results of each. They can see tournaments grouped by past, ongoing, and upcoming. They can also filter tournaments by sport and sort by earliest or latest start dates.
- **Tournament Creation**: Users can register as tournament organizers to unlock options to create and manage tournaments. When creating a tournament, they can add a new sport to the database if it does not already exist as an option.
- **Joining**: Users can register as players and join tournaments. After joining, the player's team is added to a list of tournament participants.
- **Invitations**: Organizers can send invitations to players to join a tournament. The player can then accept or reject the invitation and their team will be added to the participants list if they accept. Organizers can view the status of sent invitations.
- **Bracket**: Organizers can generate a tournament bracket. This randomly pairs up teams for the first round and creates placeholder matches for future rounds.
  - If the starting number of teams isn't a power of two, an appropriate number of teams are left unmatched as "byes" and only begin competing in the second round.
  - Organizers can set time, date, and location for the generated matches. An external holiday API is called so that if the organizer sets the date of a match on a holiday, they will be notified of it.
  - Organizers can record a winner for each match. After all winners for the current round are recorded, the organizer will be prompted to generate matches for the next round, which will randomly pair up the winners of the current round.

## Notes
Produced in 11 days as a final capstone for Tech Elevator. Uses Java, Spring Boot, PostgreSQL, JavaScript, and Vue.js.

The developers for this project were Autumn Tartt, Nikolai Humphrey-Blanco, Nikolay Karamov, Robert Gates, and Spencer Walker.
